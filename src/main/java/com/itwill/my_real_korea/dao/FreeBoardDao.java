package com.itwill.dao;

import java.util.ArrayList;

import com.itwill.my_real_korea.dto.FreeBoard;
import com.itwill.my_real_korea.dto.FreeBoardComment;

public class FreeBoardDao {
	private FreeBoard freeBoard;
	private FreeBoardComment freeBoardComment;
	/*게시물추가*/
	public int createContent(FreeBoard f_bo_content) throws Exception;
	
	/*게시물수정*/
	public int modifyContent(FreeBoard f_bo_content) throws Exception;

	/*게시물삭제 */
	public int removeContent(int fcomment_no);
		
	/*게시물조회수1올리기 */
	public int increaseContentReadCount(int qnaNo) throws Exception;
		
	/*게시물조회수가져오기 */
	public int getContentCount() throws Exception;

	/*게시물답글달기 */
	public int addComment(FreeBoardComment fcomment) throws Exception;
	
	/*게시물답글수정 */
	public int modifyComment(FreeBoardComment fcomment) throws Exception;
		
	/*게시물답글삭제 */
	public int removeComment(int fcomment_no);
		
	/*게시물조회수1올리기 */
	public int increaseCommentReadCount(int fcomment_no) throws Exception;
		
	/*게시물답글조회수가져오기 */
	public int getCommentCount() throws Exception;
		
	/*게시물가져오기 */
	public ArrayList<FreeBoard> getBoardList(int start, int end);
	
	/*게시물답글리스트*/
	public ArrayList<FreeBoardComment> getCommentList(int start, int end);
		
}