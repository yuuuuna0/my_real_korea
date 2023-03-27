/**********************userinfo insert************************/

-- insert_user_info
insert into user_info(user_Id,password,name,nickname,phone,email,birth,address,gender,point,is_Admin) 
values('mrk111','mrk_1111','마리코','마리코','010-1111-1111','mrk111@korea.com','1999-11-11','서울시 강남구 역삼동',0,0,1);
insert into user_info(user_Id,password,name,nickname,phone,email,birth,address,gender,point,is_Admin) 
values('mrk222','mrk_2222','가리코','가리코','010-2222-2222','mrk222@korea.com','1998-12-12','부산시 해운대구',0,0,1);
insert into user_info(user_Id,password,name,nickname,phone,email,birth,address,gender,point,is_Admin) 
values('mrk333','mrk_3333','나리코','나리코','010-3333-3333','mrk333@korea.com','1997-10-10','제주시 서귀포',1,0,1);


-- insert_user_add_info

insert into user_add_info(introduce,alcohol,smoking,user_Id)
values('안녕하세요. 마리코입니다.',1,1,'mrk111')
insert into user_add_info(introduce,alcohol,smoking,user_Id)
values('안녕하세요. 가리코입니다.',0,1,'mrk222')
insert into user_add_info(introduce,alcohol,smoking,user_Id)
values('안녕하세요. 나리코입니다.',0,0,'mrk333')

-- insert_user_img

insert into user_img(user_img_no,user_img_url,user_id)
values(1,'img1.png','mrk111')
insert into user_img(user_img_no,user_img_url,user_id)
values(2,'img2.png','mrk222')
insert into user_img(user_img_no,user_img_url,user_id)
values(3,'img3.png','mrk333')