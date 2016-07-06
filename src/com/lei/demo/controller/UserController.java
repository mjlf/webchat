package com.lei.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lei.demo.entity.ChatMessage;
import com.lei.demo.entity.UploadFile;
import com.lei.demo.entity.Users;
import com.lei.demo.service.*;
import org.apache.catalina.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Resource(name="userService")
    private UserService service;
    
    @RequestMapping(value="/index.do",method=RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response){
        return "index";
    }
    @RequestMapping(value="/main.do",method=RequestMethod.GET)
    public ModelAndView tomain(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("myName", ((Users)request.getSession().getAttribute("logined_user")).getUser_name());
        modelAndView.addObject("toUserId", ((Users)request.getSession().getAttribute("logined_user")).getId());
        modelAndView.addObject("toUserICON", ((Users)request.getSession().getAttribute("logined_user")).getUser_icon());
        modelAndView.addObject("alluser", service.getAllUser());
        return modelAndView;
    }
    @RequestMapping(value="/regist.do",method=RequestMethod.POST)
    public void regist(HttpServletRequest request, HttpServletResponse response){
    	try {
			String user_name = request.getParameter("user_name");
			String user_email = request.getParameter("user_email");
			String user_password = request.getParameter("user_password");
			
			Users users = new Users();
			users.setUser_name(user_name);
			users.setUser_email(user_email);
			users.setUser_password(user_password);
			
			service.save(users);
			response.getWriter().write("Y");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/sign.do",method=RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response){
    	try {
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			
			Users users = new Users();
			users.setUser_name(user_name);
			users.setUser_password(user_password);
			
			if(service.login(users)){
				users = service.find(users);
				request.getSession().setAttribute("logined_user", users);
				response.getWriter().write("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/finduserlogined.do",method=RequestMethod.GET)
    public void findlogineduser(HttpServletRequest request, HttpServletResponse response){
    	try {
			Users users = (Users)request.getSession().getAttribute("logined_user");
			JSONObject json = new JSONObject(users);
			response.getWriter().write(""+json);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    @RequestMapping(value="/getAlluser.do",method=RequestMethod.GET)
    public void getAlluser(HttpServletRequest request, HttpServletResponse response){
    	try {
			List<Users> users = service.getAllUser();
			JSONArray json = new JSONArray(users); 

			response.getWriter().write(""+json);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/savemessage.do",method=RequestMethod.POST)
    public void savemessage(HttpServletRequest request, HttpServletResponse response){
    	try {
			int fromid = Integer.parseInt(request.getParameter("fromid"));
			int toid = Integer.parseInt(request.getParameter("toid"));
			String time = request.getParameter("time");
			String data = request.getParameter("data");
			
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setChatData(data);
			chatMessage.setFromid(fromid);
			chatMessage.setToid(toid);
			chatMessage.setChatTime(time);
			
			service.savemessage(chatMessage);
			
			response.getWriter().write("Y");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/savefile.do",method=RequestMethod.POST)
    public void svaeFile(HttpServletRequest request, HttpServletResponse response){
    	try {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String url = request.getParameter("url");
			String fileName = request.getParameter("fileName");
			String time = request.getParameter("time");
			
			UploadFile file = new UploadFile();
			file.setFileName(fileName);
			file.setTime(time);
			file.setUrl(url);
			file.setUser_id(user_id);
			
			service.savefile(file);
			
			response.getWriter().write("Y");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/findMessage.do",method=RequestMethod.POST)
    public void findMessage(HttpServletRequest request, HttpServletResponse response){
    	try {
			int fromid = Integer.parseInt(request.getParameter("fromid"));
			int toid = Integer.parseInt(request.getParameter("toid"));
			
			ChatMessage message = new ChatMessage();
			message.setFromid(fromid);
			message.setToid(toid);
			
			List<ChatMessage> list = service.findmessage(message);

			JSONArray json = new JSONArray(list);
			response.getWriter().write("" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/findFile.do",method=RequestMethod.POST)
    public void findFile(HttpServletRequest request, HttpServletResponse response){
    	try {
			
    		String fileName = request.getParameter("fileName");
    		List<UploadFile> list = null;
    		if(fileName == null || fileName.length() == 0){
    			list = service.find();
    		}
    		
    		UploadFile file = new UploadFile();
    		file.setFileName(fileName);
    		
    		list = service.find(file);
    		
			JSONArray json = new JSONArray(list);
			response.getWriter().write("" + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}