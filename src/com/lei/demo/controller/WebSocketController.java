package com.lei.demo.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;


@ServerEndpoint("/user/websocket.do")
public class WebSocketController {
	
    private static final Set<WebSocketController> connections = new CopyOnWriteArraySet<>();
 
    private Session session;
    private long id;
    private String nickname;
 
    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.add(this);
    }
 
    @OnClose
    public void end() {
       connections.remove(this);
    }
 
    @OnMessage
    public void incoming(String message) {
    	try {
    		if(message.startsWith("!!<<id>>!!:")){
    			long userId = Long.parseLong(message.split(":")[1]);
    			setNickname(userId);
    		}else{
    			
    			int startIndex = message.indexOf("<!!!>")+5;
    			int endIndex = message.lastIndexOf("<!!!>");
    			String toid = message.substring(startIndex, endIndex);
    			long toUserid = Long.parseLong(toid);
    			broadcast(message, toUserid);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    @OnError
    public void onError(Throwable t) throws Throwable {
    	System.out.println(t.getMessage());
    }
 
    private static void broadcast(String msg, long toUserid) {
        for (WebSocketController client : connections) {
        	System.out.println(client.id);
            try {
            	if(toUserid == -1){
            		client.session.getBasicRemote().sendText(msg);
            	}else if(client.id == toUserid){
            		synchronized (client) {
            			client.session.getBasicRemote().sendText(msg);
            			break;
            		}
            	}
            } catch (IOException e) {
            	e.printStackTrace();
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                	e1.printStackTrace();
                }
            }
        }
    }
 
    
    public void setNickname(long id){
    	this.id = id;
    }
   
}
