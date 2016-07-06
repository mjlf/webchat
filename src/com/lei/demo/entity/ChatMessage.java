package com.lei.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "chatMessage")
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "toid")
	private Integer toid;

	@Column(name = "formid")
	private Integer fromid;

	@Column(name = "chatData", length = 10000)
	private String chatData;
	
	@Column(name="chatTime" , length=32)
	private String chatTime;
	
	@Column(name="type", length=32)
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getToid() {
		return toid;
	}

	public void setToid(Integer toid) {
		this.toid = toid;
	}

	public Integer getFromid() {
		return fromid;
	}

	public void setFromid(Integer fromid) {
		this.fromid = fromid;
	}

	public String getChatData() {
		return chatData;
	}

	public void setChatData(String chatData) {
		this.chatData = chatData;
	}

	public String getChatTime() {
		return chatTime;
	}

	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ChatMessage [id=" + id + ", toid=" + toid + ", fromid=" + fromid + ", chatData=" + chatData
				+ ", chatTime=" + chatTime + ", type=" + type + "]";
	}
}
