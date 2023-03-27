/*************** user ***********************/
--user_info
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1); 

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin) 
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1); 
--user_photo
insert into user_img(user_img_no,user_img_url,user_id) values(10,'010.png','admin');
insert into user_img(user_img_no,user_img_url,user_id) values(11,'011.png','user1');
insert into user_img(user_img_no,user_img_url,user_id) values(12,'012.png','user2');
insert into user_img(user_img_no,user_img_url,user_id) values(13,'013.png','user3');
--user_add_info
insert into user_add_info(introduce,alcohol,smoking,user_id) values('관리자인사',0,0,'admin'); 
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕1',0,0,'user1'); 
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕2',1,0,'user2'); 
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕3',0,1,'user3'); 

/*************** city ***********************/
-- city
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'서울',1,1);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'경기',2,2);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'강원',3,3);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'부산',4,4);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'대전',5,5);

/*************** wishlist ***********************/
--wishlist
insert into wishlist(wish_no,user_id) values(WISHLIST_WISH_NO_SEQ.nextval,'admin');
insert into wishlist(wish_no,user_id) values(WISHLIST_WISH_NO_SEQ.nextval,'user1');
insert into wishlist(wish_no,user_id) values(WISHLIST_WISH_NO_SEQ.nextval,'user2');


/*************** notice ***********************/
-- 공지사항 notice insert
insert into notice(n_no,n_title,n_content,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항1','공지사항내용1','img.png','kms1'); 
insert into notice(n_no,n_title,n_content,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항2','공지사항내용2','img.png','kms2'); 
insert into notice(n_no,n_title,n_content,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항3','공지사항내용3','img.png','kms3'); 

/*************** tour ***********************/
--insert tour
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'서울',1,1);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'경기',2,2);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'강원',3,3);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'부산',4,4);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'대전',5,5);
--insert tourImg
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'a',1);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'b',2);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'c',3);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'d',4);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'e',3);
--insert tourReserve
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-03-27',2,'테스트1',1,'admin');
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-02-27',2,'테스트2',2,'user2');
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-01-27',2,'테스트3',3,'admin');
--insert tourReview
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰1','테스트1',null,3,1,'admin');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰2','테스트2',null,5,2,'user2');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰3','테스트3',null,4,3,'admin');
--insert tourWishlist
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,1,'admin',1);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,4,'admin',1);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,2,'user1',2);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,1,'user2',3);

/*************** chat ***********************/
--chat_room
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방1','kms1','kms2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방2','kms3','kms2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방3','kms2','kms3');
--chat_msg
insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'안녕하세요1',sysdate,0,1,'kms1');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'혹시1',sysdate,0,1,'kms1');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'네 안녕하세요2',sysdate,0,1,'kms2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'말씀하세요2',sysdate,0,1,'kms2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'반갑습니다3',sysdate,0,2,'kms3');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'하이요2',sysdate,0,2,'kms2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'저기요2',sysdate,0,3,'kms2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id) 
values(chat_msg_msg_no_seq.nextval,'안녕하세요3',sysdate,0,3,'kms3');

/*************** freeBoard ***********************/
-- freeboard
insert into free_board values (free_board_f_bo_no_seq.nextval,'서울 맛집 추천','추천받습니다',sysdate,0,1,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'경기 맛집 추천','추천받습니다',sysdate,0,2,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'강원 맛집 추천','추천받습니다',sysdate,0,3,'user3');

