desc notice;
desc user_info;

-- 회원 user_info insert(Parent key)
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('kms1','1111','김1','별명1','010-1111-1111','kms1@korea.com','1991-01-01','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('kms2','2222','김2','별명2','010-2222-2222','kms2@korea.com','1992-02-02','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('kms3','3333','김3','별명3','010-3333-3333','kms3@korea.com','1993-03-03','강남구',0);

-- 공지사항 notice insert
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항1','공지사항내용1',sysdate,1,'img.png','kms1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항2','공지사항내용2',sysdate,2,'img.png','kms2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항3','공지사항내용3',sysdate,1,'img.png','kms3'); 


insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항4','공지사항내용4','2023/04/02',4,'img.png','kms1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항5','공지사항내용5','2023/04/03',8,'img.png','kms2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항6','공지사항내용6','2023/04/05',10,'img.png','kms3'); 

insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항7','공지사항내용7','2023/05/02',15,'img.png','kms1'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항8','공지사항내용8','2023/06/03',23,'img.png','kms2'); 
insert into notice(n_no,n_title,n_content,n_date,n_readcount,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항9','공지사항내용9','2023/07/05',2,'img.png','kms3'); 


