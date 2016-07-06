package com.lei.demo.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lei.demo.entity.UploadFile;

  
@Controller("uploadAction")
@RequestMapping("user")
public class UploadAction {  
  

	
    @RequestMapping(value = "/upload.do") 
    public void upload(@RequestParam MultipartFile file, HttpServletRequest request , HttpServletResponse response, ModelMap model) {  
    	System.out.println("yes");
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
        System.out.println(path);  
        String name = "file"+System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        File targetFile = new File(path, name);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        UploadFile file2 = new UploadFile();
        file2.setFileName(fileName);
        file2.setUrl(request.getContextPath()+"/upload/"+name);
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
        
        JSONObject json = new JSONObject(file2);
        try {
			response.getWriter().write(""+json);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }  
}