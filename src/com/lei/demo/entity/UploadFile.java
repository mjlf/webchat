package com.lei.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="uploadFile")
public class UploadFile {
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	    private Integer id;
	    
	    @Column(name="user_id")
	    private Integer user_id;
	    
	   @Column(name="fileName", length=100)
	   private String fileName;
	   
	   @Column(name="url",length=100)
	   private String url;
	   
	   @Column(name="time",length=100)
	   private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
