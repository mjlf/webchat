package com.lei.demo.entity;

import javax.persistence.*;

@Entity(name="users")
public class Users {
    
    public Users(){
        super();
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(name="user_name",length=32)
    private String user_name;
    
    @Column(name="user_email",length=32)
    private String user_email;
    
    @Column(name="user_password",length=32)
    private String user_password;

    @Column(name="user_icon",length=32)
    private String user_icon="/webchat/img/head/2016.jpg";
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_icon() {
		return user_icon;
	}

	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_password="
				+ user_password + "]";
	}
    
}