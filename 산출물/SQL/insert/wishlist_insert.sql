/*****user info*******/
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1); 

/*****wishlist*******/

insert into wishlist(wish_no,user_id) values(WISHLIST_WISH_NO_SEQ.nextval,'admin');
insert into wishlist(wish_no,user_id) values(WISHLIST_WISH_NO_SEQ.nextval,'user1');
insert into wishlist(wish_no,user_id) values(WISHLIST_WISH_NO_SEQ.nextval,'user2');
