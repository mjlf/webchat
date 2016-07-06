package com.lei.demo.service;

import java.util.List;

import org.jgroups.demos.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lei.demo.dao.*;
import com.lei.demo.entity.ChatMessage;
import com.lei.demo.entity.UploadFile;
import com.lei.demo.entity.Users;

@Service
public class UserService {
	@Autowired
    private UsersDAO userDao;
    
    public int userCount(){
        return userDao.getAllUser().size();
    }

    public UsersDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UsersDAO userDao) {
        this.userDao = userDao;
    }

    public void save(Users users){
    	this.userDao.save(users);
    }
    
    public boolean login(Users users){
    	return this.userDao.login(users);
    }
    public Users find(Users users){
    	return this.userDao.find(users);
    }
    public List<Users> getAllUser (){
    	return this.userDao.getAllUser();
    }
    
    public void savemessage(ChatMessage message){
    	this.userDao.savemessage(message);
    }
    
    public List<UploadFile> find(){
    	return this.userDao.findfile();
    }
    
    public List<UploadFile> find(UploadFile file){
    	return this.userDao.findfileByName(file);
    }
    
    public List<ChatMessage> findmessage(ChatMessage chatMessage){
    	return this.userDao.findMessage(chatMessage);
    }
    
    public void savefile(UploadFile file){
    	this.userDao.savefile(file);
    }
}