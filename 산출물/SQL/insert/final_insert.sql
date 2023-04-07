/*************** user ***********************/
--user_info
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key)
	values('admin','admin0000','관리자','관리자','010-0000-0000','admin0@gmail.com','2000-01-01','테헤란로0',0,0,0,1,0);

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key)
	values('user1','user1111','회원1','마리코1','010-1111-1111','user1@gmail.com','2001-01-01','테헤란로1',0,0,1,1,0);

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key)
	values('user2','user2222','회원2','마리코2','010-2222-2222','user2@gmail.com','2002-02-02','테헤란로2',1,0,1,1,0);

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key)
	values('user3','user3333','회원3','마리코3','010-3333-3333','user3@gmail.com','2003-03-03','테헤란로3',1,0,1,1,0);

insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender,point,is_admin,mail_auth,mail_key)
	values('user4','user4444','회원4','마리코4','010-4444-4444','user4@gmail.com','2004-04-04','테헤란로4',1,0,1,0,1234);

select * from user_info;
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
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'전주',6,6);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'제주',7,7);

/*************** notice ***********************/
-- 공지사항 notice insert

insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항은1','공지사항내용1',sysdate,1,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항은2','공지사항내용2',sysdate,2,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항삼3','공지사항내용3',sysdate,3,'img.png','user3');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다4','공지사항내용4','2023/04/02',4,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야5','공지사항내용5','2023/04/03',8,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내6','공지사항내용6','2023/04/05',10,'img.png','user3');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내7','공지사항내용7','2023/05/02',15,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제8','공지사항내용8','2023/06/03',23,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론9','공지사항내용9','2023/07/05',2,'img.png','user3');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다10','공지사항내용4','2023/04/02',4,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야11','공지사항내용5','2023/04/03',8,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내12','공지사항내용6','2023/04/05',10,'img.png','user3');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내13','공지사항내용7','2023/05/02',15,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제14','공지사항내용8','2023/06/03',23,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론15','공지사항내용9','2023/07/05',2,'img.png','user3');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이다16','공지사항내용4','2023/04/02',4,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항이야17','공지사항내용5','2023/04/03',8,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내18','공지사항내용6','2023/04/05',10,'img.png','user3');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항안내19','공지사항내용7','2023/05/02',15,'img.png','user1');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결제20','공지사항내용8','2023/06/03',23,'img.png','user2');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항결론21','공지사항내용9','2023/07/05',2,'img.png','user3');


/*************** tour ***********************/
--insert tour
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'레저여행',1,2,10,'잠실역',200000,'바다에서놀아요','준비물:여벌옷',0,3);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'별자리탐험',2,1,10,'강릉기차역',30000,'별보러가요','운동화',0,3);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'빵집투어',2,1,5,'대전역',40000,'성심당을시작으로','굶주린배',0,5);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'야경투어',2,1,10,'서울역',50000,'부산야경투어','사투리공부하기',0,4);
insert into tour(to_no,to_name,to_type,to_time,to_person,to_meet,to_price,to_info,to_notice,to_count,city_no)
    values(TOUR_TO_NO_SEQ.nextval,'호수탐험',1,2,10,'사당역',60000,'근교호수투어','인생사진찍어드려요',0,2);


--insert tourImg
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'a',1);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'b',2);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'c',3);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'d',4);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'e',3);
/*--insert tourReserve
insert into tour_reserve(to_rs_no,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'2023-03-27',2,'테스트1',1,'admin');
insert into tour_reserve(to_rs_no,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'2023-02-27',2,'테스트2',2,'user2');
insert into tour_reserve(to_rs_no,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'2023-01-27',2,'테스트3',3,'admin');*/
--insert tourReview
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰1','테스트1',null,3,1,'admin');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰2','테스트2',null,5,2,'user2');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰3','테스트3',null,4,3,'admin');

/*************** chat ***********************/

-- chat_room
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방1','user1','user2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방2','user3','user2');
insert into chat_room(room_no,room_name,from_id,to_id) values (chat_room_room_no_seq.nextval,'채팅방3','user2','user3');

--chat_msg
insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'안녕하세요1',sysdate,0,1,'user1');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'혹시1',sysdate,0,1,'user1');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'네 안녕하세요2',sysdate,0,1,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'말씀하세요2',sysdate,0,1,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'반갑습니다3',sysdate,0,2,'user3');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'하이요2',sysdate,0,2,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'저기요2',sysdate,0,3,'user2');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_no,user_id)
values(chat_msg_msg_no_seq.nextval,'안녕하세요3',sysdate,0,3,'user3');

/*************** freeBoard ***********************/
-- freeboard
insert into free_board values (free_board_f_bo_no_seq.nextval,'서울 맛집 추천','위생깔끔한곳 선호합니다','2023-01-11',0,1,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'경기 맛집 추천','클린한 음식으로 추천부탁합니다','2023-01-19',3,2,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'강원 맛집 추천','면류 좋아합니다','2023-01-22',0,3,'user3');
insert into free_board values (free_board_f_bo_no_seq.nextval,'부산 해운대 1박2일 추천','자연보는거 좋아합니다','2022-01-19',7,4,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'대전 여행코스 추천해주세요','2박 3일 코스로 여행 예정입니다','2023-02-12',1,5,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'서울 핫플 추천받습니다','사람많은곳 선호합니다','2023-03-19',9,1,'user3');
insert into free_board values (free_board_f_bo_no_seq.nextval,'경기도 풍경 좋은곳 추천해주세요','1박2일 여행가려고요','2022-01-03',6,2,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'경기도 파주쪽 어죽맛집 추천해주세요','파주여행갑니다','2022-07-03',6,2,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'강원도 벚꽃축제 하나요?','벚꽃좀 보고 싶네요','2022-09-03',13,3,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'부산 국밥집 어디가 잘하나요','근본있는곳으로 추천부탁합니다','2022-11-03',11,4,'user3');
insert into free_board values (free_board_f_bo_no_seq.nextval,'대전 유성온천 어떤가요','가보신분 후기좀 남겨주세요',sysdate,4,5,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판12','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,5,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판13','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,1,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판14','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,1,'user3');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판15','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,1,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판16','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,3,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판17','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,5,'user3');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판18','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,5,'user1');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판19','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,4,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판20','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,3,'user2');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판21','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,3,'user3');
insert into free_board values (free_board_f_bo_no_seq.nextval,'자유게시판22','2박3일 여행 가려는데 명소 추천좀 해주세요',sysdate,4,2,'user3');

-- freeboard comment
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'여의도 더현대서울 지하 1층 삼성혈해물탕, 호우섬 추천 드려요. ',sysdate,1,'user3');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'연평도에서 잡은 싱싱한 게로 만든 백년게장 추천드려요. 경기도 화성입니다.',sysdate,2,'user1');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'면류 좋아하시면 삼척시 장호감자탕 문어막국수 추천해요.',sysdate,3,'user2');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'엘시티에 있는 연화리해물천국에서 와인과 저녁 식사 한 끼 추천합니다. ',sysdate,1,'user3');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'연평도에서 잡은 싱싱한 게로 만든 백년게장 추천 드려요. 경기도 화성입니다.',sysdate,2,'user1');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'청와대, 삼청동, 국립현대미술관 코스 추천해요.',sysdate,3,'user2');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'어린이와 함께라면  아쿠아리움 관광, 과학관 관람을 추천해요. 티켓예약 플랫폼을 통해 할인된 가격으로 입장하실 수 있어요.',sysdate,1,'user3');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'인천 지역 추천해요. 드라이브 가려면 영종도에 가보세요.',sysdate,3,'user2');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'벚꽃 많은 곳은 춘천 의암 호수 추천해요.',sysdate,1,'user3');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'부산 진구 송정3대국밥 추천합니다.',sysdate,2,'user1');
insert into free_board_comment values (FREE_BOARD_COMMENT_F_CO_NO_SEQ.nextval,'다양한 레저 시설이 있어요. 대전역에서는 20분 걸려요.',sysdate,1,'user3');


/*************** ticket ***********************/
--TICKET 티켓 상품
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'서울로 가보 자고', SYSDATE, 10000, '서울로 가는 티켓', '눈 뜨고 코 베이지 않게 주의 하세요.',default,1);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'경기도로 가보 자고', SYSDATE, 20000, '경기도 어딘가로 가는 티켓', '어디로 갈지 모르니 주의 하세요.',default,2);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'강원도로 가보 자고', SYSDATE, 30000, '강원도 어딘가로 가는 티켓', '여기가 어디지?',default,3);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'부산으로 가보 자고', SYSDATE, 40000, '부산으로 가는 티켓', '갈매기를 주의 하세요.',default,4);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'대전으로 가보 자고', SYSDATE, 50000, '대전으로 가는 티켓', '빵순이가 될 수 있으니 주의하세요.',default,5);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'전주로 가보 자고', SYSDATE, 60000, '전주로 가는 티켓', '막걸리에 취할 수 있으니 주의하세요',default,6);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'제주도로 가보 자고', SYSDATE, 70000, '제주도로 가는 티켓 ', '돌아 오기 싫을 수 있으니 주의 하세요.',default,7);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'서울 1111111111', SYSDATE, 11111, '서울로 가는 티켓', '눈 뜨고 코 베이지 않게 주의 하세요.',default,1);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'경기도 22222222', SYSDATE, 22222, '경기도 어딘가로 가는 티켓', '어디로 갈지 모르니 주의 하세요.',default,2);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'강원도 33333333', SYSDATE, 33333, '강원도 어딘가로 가는 티켓', '여기가 어디지?',default,3);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'부산  44444444', SYSDATE, 44444, '부산으로 가는 티켓', '갈매기를 주의 하세요.',default,4);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'대전  55555555', SYSDATE, 55555, '대전으로 가는 티켓', '빵순이가 될 수 있으니 주의하세요.',default,5);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'전주  66666666', SYSDATE, 66666, '전주로 가는 티켓', '막걸리에 취할 수 있으니 주의하세요',default,6);
INSERT INTO TICKET (TI_NO, TI_TITLE,TI_DATE,TI_PRICE,TI_INFO,TI_NOTICE,TI_COUNT,CITY_NO) VALUES (TICKET_TI_NO_SEQ.NEXTVAL,'제주도 7777777', SYSDATE, 77777, '제주도로 가는 티켓 ', '돌아 오기 싫을 수 있으니 주의 하세요.',default,7);

/*TICKET_RESERVE 티켓 예약
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-01-15', 1,'서울 티켓 요청입니다',1,'user1');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-02-17', 2,'경기도 어쩌구 요청할게 있어요',2,'user2');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-03-20', 3,'강원도,,,,3명 더 추가해려고하는데요...',3,'user3');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-04-21', 4,'부산.....맛집 추천 요청해도 되나요?',4,'user1');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-05-29', 5,'대전....성심당 진짜 맛있나요? 빵 추천 해주실 수 있나요?',5,'user2');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-06-05', 6,'전주..에서 막걸리 먹고 취했어요... < 이게 요청사항임',6,'user3');
INSERT INTO TICKET_RESERVE (TI_RS_NO, TI_RS_DATE, TI_RS_QTY, TI_RS_MSG, TI_NO, USER_ID) VALUES (TICKET_RESERVE_TI_RS_NO_SEQ.NEXTVAL,'2023-07-21', 7,'제주도 물가 비싸서 그런데 1명은 무료로 가능한가요?',7,'user1');*/
--TICKET_REVIEW 티켓 리뷰
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL,'2023-01-16','서울 어쩌구티켓 후기', '서울로 가보자고는 짱이다.',1,'user1');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-02-27','경기 어쩌구티켓 후기','어디로 갔는지 모르겠지만 좋았네요.',2,'user2');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-03-21','강원 어쩌구티켓 후기','강원도 짱',3,'user3');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-04-22','부산 어쩌구티켓 후기','부산 갈매기한테 아이스크림 뺏긴 후기',4,'user1');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-06-01','대전 어쩌구티켓 후기','대전 갔다가 빵순이 된 후기',5,'user2');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-06-07','전주 어쩌구티켓 후기','전주 어쩌구 저렴하게 가서 좋았어요.',6,'user3');
INSERT INTO TICKET_REVIEW (TI_REVIEW_NO, TI_REVIEW_DATE, TI_REVIEW_TITLE, TI_REVIEW_CONTENT, TI_NO, USER_ID) VALUES (TICKET_REVIEW_TI_REVIEW_NO_SEQ.NEXTVAL, '2023-07-27','제주 어쩌구티켓 후기','제주도...왜 한 명 무료로 안해주셨나요?',7,'user1');
--TICKET_IMG 티켓 사진
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'SEOUL.JPG',1);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'GYEONGI.JPG',2);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'GANGWON.JPG',3);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'BUSAN.JPG',4);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'DAEJEON.JPG',5);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'JEONJU.JPG',6);
INSERT INTO TICKET_IMG (TI_IMG_NO, TI_IMG_URL,TI_NO) VALUES(TICKET_IMG_TI_IMG_NO_SEQ.NEXTVAL,'JEJU.JPG',7);

/*************** tripBoard ***********************/
-- 동행게시판 trip_board insert
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'서울 가자1','서울 가자1',sysdate,342,0,1,
                    'img1.png','2023-05-01','2023-05-10','무계획','아무나다좋아',1,'user1'); 
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'서울 갈래2','서울 갈래2',sysdate,4,1,2,
                    'img2.png','2023-06-01','2023-06-10','계획형','인싸만',1,'user2');
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'서울 가자3','서울 가자3',sysdate,75,0,6,
                    'img3.png','2023-07-01','2023-07-10','맛집투어','맛있는거좋아하는사람',1,'user3'); 
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'경기도 가볼래4','경기도 가볼래4',sysdate,27,1,3,
                    'img4.png','2023-08-01','2023-08-10','무계획','드라이브여행',2,'user1'); 
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'경기도 갈래5','경기도 갈래5',sysdate,86,0,7,
                    'img5.png','2023-09-01','2023-09-10','계획형','맛있는거좋아하는사람',2,'user2');
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'강원도 가자6','강원도 가자6',sysdate,22,1,10,
                    'img6.png','2023-10-01','2023-10-10','맛집투어','인싸만',3,'user3');
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'강원도 갈래7','강원도 갈래7',sysdate,46,0,3,
                    'img7.png','2023-11-01','2023-11-10','무계획','아무나다좋아',3,'user1'); 
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'부산 가자8','부산 가자8',sysdate,2,0,1,
                    'img8.png','2023-12-01','2023-12-10','계획형','맛있는거좋아하는사람',4,'user2');
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'부산 갈래9','부산 갈래9',sysdate,45,0,3,
                    'img9.png','2023-05-02','2023-05-10','맛집투어','드라이브여행',4,'user3');
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'대전 가자10','대전 가자10',sysdate,12,0,2,
                    'img10.png','2023-06-02','2023-07-12','무계획','아무나다좋아',5,'user1'); 
                    
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,'대전 갈래11','대전 갈래11',sysdate,67,1,8,
                    'img11.png','2023-07-02','2023-07-12','계획형','맛있는거좋아하는사람',5,'user2');


-- 동행게시판 댓글 insert
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id)
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글1', sysdate, 1, 'user2');
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id)
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글2', sysdate, 2, 'user3');
insert into trip_board_comment(t_co_no, t_comment_content, t_comment_date, t_bo_no, user_id)
                        values(TRIP_BOARD_COMMENT_T_CO_NO_SEQ.nextval, '댓글3', sysdate, 3, 'user1');

/*************** wishlist ***********************/
-- 티켓 상품 위시리스트에 추가
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',1,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',2,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',3,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',4,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',1,null);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',2,null);

-- 투어 상품 위시리스트에 추가
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',null,2);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user1',null,3);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',null,1);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user2',null,2);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',null,3);
insert into wishlist(wish_no,user_id,ti_no,to_no) values(WISHLIST_WISH_NO_SEQ.nextval,'user3',null,4);



commit;