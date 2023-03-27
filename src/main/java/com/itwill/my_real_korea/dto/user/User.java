package com.itwill.my_real_korea.dto.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

/*
user_id  NOT NULL VARCHAR2(50)  
password NOT NULL VARCHAR2(100) 
name     NOT NULL VARCHAR2(50)  
nickname NOT NULL VARCHAR2(50)  
phone    NOT NULL VARCHAR2(100) 
email    NOT NULL VARCHAR2(100) 
birth    NOT NULL DATE          
address  NOT NULL VARCHAR2(500) 
gender   NOT NULL NUMBER        
point             NUMBER        
is_admin          NUMBER    
 */
	
	private String userId;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private Date birth;
	private String address;
	private int gender;
	private int point;
	private int isAdmin;
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	

