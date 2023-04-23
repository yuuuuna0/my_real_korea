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
	values('user4','user4444','회원4','마리코4','010-4444-4444','user4@gmail.com','2004-04-04','테헤란로4',1,0,1,0,123456);
    

select * from user_info;
--user_img
insert into user_img(user_img_no,user_img_url,user_id) values(9000,'9000.png','admin');
insert into user_img(user_img_no,user_img_url,user_id) values(9001,'9001.png','user1');
insert into user_img(user_img_no,user_img_url,user_id) values(9002,'9002.png','user2');
insert into user_img(user_img_no,user_img_url,user_id) values(9003,'9003.png','user3');
insert into user_img(user_img_no,user_img_url,user_id) values(9004,'9004.png','user4');

--user_add_info
insert into user_add_info(introduce,alcohol,smoking,user_id) values('관리자인사',0,0,'admin');
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕1',0,0,'user1');
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕2',1,0,'user2');
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕3',0,1,'user3');
insert into user_add_info(introduce,alcohol,smoking,user_id) values('안녕4',0,1,'user4');



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

insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항은1','공지사항내용1',sysdate,1,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항은2','공지사항내용2',sysdate,2,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항삼3','공지사항내용3',sysdate,3,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항이다4','공지사항내용4','2023/04/02',4,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항이야5','공지사항내용5','2023/04/03',8,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항안내6','공지사항내용6','2023/04/05',10,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항안내7','공지사항내용7','2023/05/02',15,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항결제8','공지사항내용8','2023/06/03',23,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항결론9','공지사항내용9','2023/07/05',2,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항이다10','공지사항내용4','2023/04/02',4,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항이야11','공지사항내용5','2023/04/03',8,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항안내12','공지사항내용6','2023/04/05',10,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,user_id) values (notice_n_no_seq.nextval,'공지사항안내13','공지사항내용7','2023/05/02',15,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'[상품추첨]나의 여행스타일을 공유해주세요 ','공지사항내용8','2023/06/03',23, 'notice6.png','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'걷다보니 부평 역사투어 안내','공지사항내용9','2023/04/23',0, 'notice3.jpg','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'[할인]제주관광공사 면세점 할인쿠폰 이벤트','제주 면세점 할인쿠폰 이벤트를 진행합니다!','2023/04/02',0, 'notice4.jpg','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'마이리얼코리아 여행후기 이벤트','여행 후기 이벤트를 진행합니다!','2023/04/03', 0, 'notice1.png','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'한강 요트투어 참가자 모집','한강 요트투어 참가자를 모집합니다!','2023/04/05', 0, 'notice2.jpg','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'나만 알던 착한 가게 돈쭐내러 가자!','착한 가게를 알려주세요!','2023/04/08', 0, 'notice7.png','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'[할인]마이리얼 코리아 즉시 15만원 할인 이벤트 ','마이리얼코리아와 함께하는 할인이벤트입니다!','2023/04/12', 0, 'notice5.png','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'[할인]선착순 서울 투어 할인 이벤트','선착순 서울 투어 할인 이벤트입니다.','2023/05/02',0, 'notice_seoul.png','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'[할인]제주 투어 50% 파격 할인','마이리얼코리아에만 있는 제주투어 50% 할인!','2023/06/03',0,'notice_jeju.png' ,'admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'[신규가입]마이리얼코리아 회원가입 이벤트 : 적립금 2000 쏜다!','마이리얼코리아 신규가입 이벤트입니다.','2023/07/05',0, 'notice_point.png','admin');
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img, user_id) values (notice_n_no_seq.nextval,'봄X섬 인증샷 이벤트','2023 찾아가고 싶은 섬과 함께 인증샷을 찍어주세요!','2023/04/15', 0, 'notice8.png','admin');



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
insert into chat_room(room_name) values ('채팅방1');
insert into chat_room(room_name) values ('채팅방2');
insert into chat_room(room_name) values ('채팅방3');

--chat_msg
insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_name,user_id)
values(chat_msg_msg_no_seq.nextval,'안녕하세요1','토요일',0,'채팅방1','aaa111');

insert into chat_msg(msg_no,msg_content,msg_send_time,msg_read,room_name,user_id)
values(chat_msg_msg_no_seq.nextval,'혹시1','토요일',0,'채팅방1','aaa111');



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
            values (trip_board_t_bo_no_seq.nextval,
            '제주 2주간 머무는데 시간 되실때 저녁 같이 드실 분 있으실까요:)',--제목
            '올해 30 여자입니다!
            내도동에 혼자 2주정도 머물 예정입니다.
            혼밥하기 힘든 메뉴들(?) 먹을 때 함께 하실 분 계시면 좋을거 같아요!
            해산물 좋아합니당:)
            딱히 여행 일정을 잡고 가는건 아니고 평일은 오후4시까진 재택 근무를 해야해서 하루라도 저녁에 밥이나 맛있는거 먹으실 분 계시면 같이 먹어요!
            여행 스타일 비슷하시면 같이 관광하는것도 좋구용!ㅎㅎ',--내용
            sysdate,
            342,--조회수
            0,-- 모집상태
            1,--모집인원
            'img1.png',
            '2023-05-01','2023-05-10',
            '계획적인',--여행스타일
            '아무나다좋아',--해시태그
            7,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '강릉바다 보러가실 분 구해요',--제목
            '저 포함 남자 셋이고요
             차타고 강릉 바다 보러가려해요
             펜션잡고 바베큐하면서 그냥 영화얘기하려는데
             동행 하실 분 구합니당',--내용
            sysdate,
            39,--조회수
            0,-- 모집상태
            3,--모집인원
            'img1.png',
            '2023-07-23','2023-07-26',
            '즉흥적인',--여행스타일
            '재밌게놀아요',--해시태그
            3,--city
            'myrealkorea2');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '오늘 저녁 대전에서 같이 술한잔 하실분들 모셔요',--제목
            '현재 동행은 없구요 
             이곳에온지 몇일 안되서 술은 먹고싶은데 혼술은 못해요 그래서 술 같이드실분 모셔요  
             성별나이 전혀 무관합니다.',--내용
            sysdate,
            29,--조회수
            0,-- 모집상태
            5,--모집인원
            'img1.png',
            '2023-05-21','2023-05-23',
            '느긋한',--여행스타일
            '좋은시간보냅시다.',--해시태그
            5,--city
            'myrealkorea3');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '에버랜드 같이 가실 20대 여성분들 모집해요.',--제목
            '급 에버랜드 가고 싶어서 주변 친구들한테 다 물어봤는데 다들 개강이 빠르거나 약속이 이미 잡혀있어서 ㅜㅜ 
            아무튼 같이 가실 20대 여성분들은 연락 주세요
            날짜는 8월 29일 또는 30일 중 하루로 갈 거고 같이 신나게 놀이기구 타면서 스트레스도 풀고 재밌게 놀아요!!
            인원은 저 포함 최대 4명 생각하고 있습니다.',--내용
            sysdate,
            754,--조회수
            0,-- 모집상태
            4,--모집인원
            'img1.png',
            '2023-08-29','2023-08-30',
            '사진찍는',--여행스타일
            '아무나다좋아',--해시태그
            2,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '가평 가실 분 손들어봐요~:)',--제목
            '가평 빠지가요!  남자 둘이 기구타기가 그래서..여성 2분 구합니다! 
            20대 후반이고 차있고 재미있고 배려있고 술도있고 필요한거 말하면 다있어요! 
            그리고 돼지고기에 서 소고기맛 나게 굽고 소고기에서 유니콘 맛나게 구울 수 있습니다! 
            친구가^^
            ps: 원하시면 가기전에 미리 잠깐만나서 계획세워도 됩니다!',--내용
            sysdate,
            32,--조회수
            0,-- 모집상태
            1,--모집인원
            'img1.png',
            '2023-05-01','2023-05-10',
            '느긋한',--여행스타일
            '달려',--해시태그
            2,--city
            'myrealkorea2');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '토요일 아침 가벼운 트래킹 어떠실까요~?',--제목
            '토요일 아침 일찍 인왕산이든 북악산이든 
             서울 근교 트래킹 다녀와서 주말을 길게 보냈으면 
             좋겠어서 오픈해보았어요 ! 

             저는 서른넷 남자 평범한 직장인이구요 ~
             서로 트래킹메이트가 있으면 좋을 거 같습니다 !',--내용
            sysdate,
            55,--조회수
            0,-- 모집상태
            3,--모집인원
            'img1.png',
            '2023-06-05','2023-06-05',
            '계획적인',--여행스타일
            '아무나다좋아',--해시태그
            1,--city
            'myrealkorea3');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '5월 3일 ~ 7일까지 제주여행',--제목
            '혼자 가고, 첫날을 책관련 게스트하우스에서 숙박예정이고
            그 이후에는 일정 없어요~ 물놀이하고 싶은데 기온 보면서 정하려구요. 
            자세한 일정은 아직이고 같이 조율해가도 좋을거 같아요. 
            유채꽃 같이 보러 다닐 메이트 한 분 구해요!',--내용
            sysdate,
            239,--조회수
            0,-- 모집상태
            3,--모집인원
            'img1.png',
            '2023-05-03','2023-05-07',
            '사진찍는',--여행스타일
            '제주도여행',--해시태그
            7,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '1박2일 부산여행 하실 분(여자입니다.)',--제목
            '1.현재 혼자고, 1분만 더 구해요!
             2.제 나이는 스무살이고, 20살,21살,22살 여성분까지 함께 할 수 있습니다!! 친구랑 여행하듯이 편하게 여행 해용ㅎㅎ
             3.숙소는 Airbnb로 예약했습니다! 2인실 1인당 3만 2천원이고, 숙소 제외 부분동행도 가능해요🐳
             4.ktx를 서울역에서 타고 갈 예정인데, 괜찮으시다면 그때부터 동행 가능합니다 좌석은 떨어질 수 있어요!🍭
             메시지로 자세한 것 논의해봐요! 답변 느리더라도 양해 부탁해용',--내용
            sysdate,
            65,--조회수
            0,-- 모집상태
            2,--모집인원
            'img1.png',
            '2023-04-27','2023-05-10',
            '계획적인',--여행스타일
            '모험추구형',--해시태그
            4,--city
            'myrealkorea2');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '배낭 하나메고 내일로 여행! 전국 가고싶은 지역가서 맞집투어 할분!',--제목
            '여행 좋아하는 30대 초반 남자입니다
             잠시 쉬게되어 내일로 여행을 다녀올까 합니다.
             여행 스타일은 안가본곳을 가보고 도전해보는걸 좋아하고 약간 뚜벅이 여행스타일 입니다.
             영등포 역이나 서울역에서 출발해서 부산에서부터 올라올 예정이고 가고싶으신 지역이 있다면  조율 가능 합니다.
             짧으면 3박에서 길면 6박 생각하고 있습니다.
             편하게 연락주세용!',--내용
            sysdate,
            98,--조회수
            0,-- 모집상태
            4,--모집인원
            'img1.png',
            '2023-07-01','2023-07-05',
            '계획적인',--여행스타일
            '아무나다좋아',--해시태그
            4,--city
            'myrealkorea3');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '부산여행(6/13-14)여행',--제목
            '부산 첫 여행이에요!!
             여자 27살 2명이고 차를 렌트해서 다니고 싶은데
             운전을 못해서 운전 가능하신분이면 좋을거같아요
             대신 렌트비를 조금만 내셔도돼용,,,안내셔도,,
             서면 해운대 광안리 영도 쪽으로 여행 고민하고있어요! 숙소는 광안리입니다ㅎㅎ',--내용
            sysdate,
            42,--조회수
            0,-- 모집상태
            2,--모집인원
            'img1.png',
            '2023-06-13','2023-06-14',
            '즉흥적인',--여행스타일
            '아무나다좋아',--해시태그
            4,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '대전 여행 처음입니다.',--제목
            '올해 31 여자입니다!
            대전 여행 처음인데 동행해서 즐거운 시간 보내실 분
            댓글이나 채팅 걸어주세요~
            ',--내용
            sysdate,
            32,--조회수
            0,-- 모집상태
            1,--모집인원
            'img1.png',
            '2023-08-01','2023-08-10',
            '뚜벅이',--여행스타일
            '아무나다좋아',--해시태그
            5,--city
            'myrealkorea2');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '대전오월드 같이 가실 분~',--제목
            '25살 남자구요.
            날씨 좋아서 대전오월드 놀러가려고 하는데
            2명 정도 모여서 갔으면 좋겠습니다.',--내용
            sysdate,
            76,--조회수
            0,-- 모집상태
            2,--모집인원
            'img1.png',
            '2023-06-23','2023-06-23',
            '즉흥적인',--여행스타일
            '아무나다좋아',--해시태그
            5,--city
            'myrealkorea3');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '대전 엑스포 다녀오실 분',--제목
            '대전 엑스포에 가보고 싶은데
            같이 가실 분 연락주세요.
            저녁에는 같이 밥먹는거도 좋습니다.',--내용
            sysdate,
            40,--조회수
            0,-- 모집상태
            3,--모집인원
            'img1.png',
            '2023-05-01','2023-05-02',
            '계획적인',--여행스타일
            '아무나다좋아',--해시태그
            5,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '처음이라,, 4월 22-23일 강원도 혼자 여행가시는분 계신가요',--제목
            '혼자 여행가려다 막상 어려울수도 있다는 생각에 동행도 좋겠다 싶어 가입했어요 ! 

            힐링이 목적이신분들 환영해요 :-)

            전 20대중반, 힐링이 너무 하고싶어 갑자기 떠나기로한 여자사람이에요 !

            누구든 무계획으로 힐링이 하고싶은 분들 환영해요 ㅎㅎ',--내용
            sysdate,
            13,--조회수
            1,-- 모집상태
            1,--모집인원
            'img1.png',
            '2023-04-22','2023-04-23',
            '즉흥적인',--여행스타일
            '아무나다좋아',--해시태그
            3,--city
            'myrealkorea2');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '강릉이나 속초 쪽으로 여행가실분 계신가요?',--제목
            '저는 33살 남자입니다.자차로 이동생각입니다.
            강릉 이나 속초 쪽으로 여행가볼 생각입니다.
            혹시 같이 가실분 계신가요?? 
            맛집위주로 다니고 싶은데 혼자는 처음이기도하고 1인분은 잘 안판다고해서요 ㅠㅠ
            굳이 강원도 아니여도 괜찮습니다. 연락 주세용 ㅠㅠ',--내용
            sysdate,
            76,--조회수
            1,-- 모집상태
            2,--모집인원
            'img1.png',
            '2023-04-10','2023-04-14',
            '계획적인',--여행스타일
            '아무나다좋아',--해시태그
            3,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '쌀쌀해지기 전에 뚝섬 한강공원에 가요',--제목
            '오늘 뚝섬 한강공원에 피크닉을 갑니다
             화장실 갔다 돌아오는 것처럼 자연스럽게
             저희 돗자리에 합류하시면 피크닉에 끼워드립니다

             피크닉 시작시간 : 6시 이후
             피크닉 종료시간 : 자유

             ',--내용
            sysdate,
            45,--조회수
            1,-- 모집상태
            6,--모집인원
            'img1.png',
            '2023-04-01','2023-04-10',
            '계획적인',--여행스타일
            '아무나다좋아',--해시태그
            1,--city
            'myrealkorea3');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '글램핑 또는 펜션 같이가실 여성 두분 있나요~? 남자 둘입니당',--제목
            '서울 살고 있구요 ~
             강화도나 포천 또는 가평으로 갈 예정입니다.
             평일 주말 아무때나 가능하구여
             같이가실분 있으시면 시간 맞춰서 재밌게 놀고싶습니당
             재밌게 맛있는거 먹고 힐링하고 오실분 ~
             옵션으로 주둥이 드립 있습니다 ^^',--내용
            sysdate,
            342,--조회수
            0,-- 모집상태
            2,--모집인원
            'img1.png',
            '2023-05-07','2023-05-10',
            '느긋한',--여행스타일
            '아무나다좋아',--해시태그
            1,--city
            'myrealkorea1');
            
insert into trip_board(t_bo_no,t_bo_title,t_bo_content,t_bo_date,t_bo_readcount,t_bo_status,t_bo_person,
                    t_bo_img,t_bo_start_date,t_bo_end_date,t_bo_style,hashtag,city_no,user_id) 
            values (trip_board_t_bo_no_seq.nextval,
            '동행구해요',--제목
            '휴가 받아서 여행가고 싶은데
             갑자기 받은 휴가라서 혼자갈 자신은 없고
             동행 구해요^^ 몇명이든 되시는분들 같이가요
             서울살고 있는데 제주도도 좋고 어디든 급하게 맞춰서 가는것도 좋고 여행중이시라면 그쪽으로 갈 수 있습니다
             연락주세요',--내용
            sysdate,
            342,--조회수
            0,-- 모집상태
            4,--모집인원
            'img1.png',
            '2023-06-24','2023-06-28',
            '뚜벅이',--여행스타일
            '아무나다좋아',--해시태그
            1,--city
            'myrealkorea1');
                    



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

/*************** wishlist ***********************/
insert into payment(p_no,p_price,p_qty,p_date,p_start_date,p_msg,p_point,p_method,ti_no,to_no,user_id)
		 values(payment_p_no_seq.nextval,3000,3,null,sysdate,'sdsd',30,1,null,1,'user1');

commit;