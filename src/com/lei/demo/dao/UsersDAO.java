package com.lei.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jgroups.demos.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lei.demo.entity.ChatMessage;
import com.lei.demo.entity.UploadFile;
import com.lei.demo.entity.Users;


@Component

public class UsersDAO {
	@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Users> getAllUser(){
        String hsql="from users";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        
        return query.list();
    }
    
    @Transactional
    public void save(Users users){
    	Session session = sessionFactory.getCurrentSession();
    	session.save(users);
    }
    
    @Transactional
    public boolean login(Users users){
    	String hsql="from users";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        List<Users> usersList = query.list();
        for(Users user : usersList){
        	System.out.println(user);
        	if(user.getUser_name().equals(users.getUser_name()) && user.getUser_password().equals(users.getUser_password())){
        		return true;
        	}
        }
        return false;
    }
    
    @Transactional
    public Users find(Users users){
    	String hsql="from users";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        Criteria criteria = session.createCriteria(Users.class); 
        criteria.add(Restrictions.eq("user_name", users.getUser_name())); 
        List list = criteria.list();
        if(list == null || list.size() == 0){
        	return null;
        }else{
        	return (Users)list.get(0);
        }
    }
    
    @Transactional
    public void savemessage(ChatMessage message){
    	sessionFactory.getCurrentSession().save(message);
    }
    
    @Transactional
    public void savefile(UploadFile file){
    	sessionFactory.getCurrentSession().save(file);
    }
    
    @Transactional
    public List<UploadFile> findfile(){
    	 String hsql="from uploadFile";
         Session session = sessionFactory.getCurrentSession();
         Query query = session.createQuery(hsql);
         
         return query.list();
    }
    
    @Transactional
    public List<UploadFile> findfileByName(UploadFile file){
    	 String hsql="from uploadFile";
         Session session = sessionFactory.getCurrentSession();
         Query query = session.createQuery(hsql);
         Criteria criteria = session.createCriteria(UploadFile.class); 
         if(file.getId() != null){
        	 criteria.add(Restrictions.eq("id", file.getId())); 
         }
         if(file.getFileName() != null){
        	 criteria.add(Restrictions.like("fileName", "%"+file.getFileName()+"%"));
         }
         List list = criteria.list();
         return list;
    }
    
    @Transactional
    public List<ChatMessage> findMessage(ChatMessage message){
    	 String hsql="from uploadFile";
         Session session = sessionFactory.getCurrentSession();
         Query query = session.createQuery(hsql);
         Criteria criteria = session.createCriteria(ChatMessage.class); 
         if(message.getFromid() != null){
        	 criteria.add(Restrictions.or(Restrictions.eq("fromid", message.getFromid()),Restrictions.eq("toid", message.getFromid())));
         }
         if(message.getToid() != null){
        	 criteria.add(Restrictions.or(Restrictions.eq("fromid", message.getToid()),Restrictions.eq("toid", message.getToid())));
         }
         List list = criteria.list();
         return list;
    }
}