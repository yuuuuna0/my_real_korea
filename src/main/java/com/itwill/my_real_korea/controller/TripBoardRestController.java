package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.tripboard.TripBoardService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class TripBoardRestController {
	
	@Autowired
	private TripBoardService tripBoardService;
	@Autowired
	private CityService cityService;
	/*
	* 동행 게시글 추가 
	*/
	@LoginCheck
	@ApiOperation(value = "동행게시글 추가")
	@PostMapping(value = "/tripboard", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripboard_write_action(@ModelAttribute TripBoard tripBoard, @RequestParam int cityNo){
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<TripBoard> data = new ArrayList<TripBoard>();
		
		try {
			// 동행 게시글 쓰기, 성공시 code 1
			City city=cityService.findByCityNo(cityNo);
			tripBoard.setCity(city);
			tripBoardService.insertTripBoard(tripBoard);
			code = 1;
			msg = "성공";
			// 동행 게시글 쓰기 후 데이터 자동 붙여줌
			tripBoard = tripBoardService.selectByTbNo(tripBoard.getTBoNo());
			data.add(tripBoard);
		} catch (Exception e) {
			// 실패 시 code 2
			e.printStackTrace();
			code = 2;
			msg = "게시글 쓰기 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	/*
	 * 동행 게시글 수정
	 */				
	@LoginCheck
	@ApiOperation(value = "동행게시글 수정")
	@ApiImplicitParam(name = "tBoNo", value = "동행게시글 번호")/*Api 의 파라미터(하나)만 가지고 오려고 사용*/
	@PutMapping(value = "/tripboard/{tBoNo}", produces = "application/json;charset=UTF-8")/*text*/
	public Map<String,Object> tripboard_modify_action(@PathVariable(value = "tBoNo")int tBoNo,@ModelAttribute TripBoard tripBoard, @RequestParam int cityNo){
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<TripBoard> data = new ArrayList<TripBoard>();
		try {
			// tBoNo로 동행 게시글 1개 찾기, 수정 성공시 code 1
			City city=cityService.findByCityNo(cityNo);
			tripBoard.setCity(city);
			
			TripBoard findTripBoard = tripBoardService.selectByTbNo(tBoNo);
			if(findTripBoard != null) {
				tripBoard.setTBoNo(tBoNo);
				tripBoardService.updateTripBoard(tripBoard);
				code = 1;
				msg = "성공";
				// 수정 성공한 동행 게시판 객체 데이터 붙임
				data.add(tripBoard);
			} else {
				//실패시 code 2
				code = 2;
				msg = "게시글 수정 실패";
			}
		
		} catch (Exception e) {
			// 에러 발생 시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	/*
	 * 동행 게시글 삭제
	 */
	@LoginCheck
	@ApiOperation(value = "동행 게시글 삭제")/*swagger 에서 출력 값*/
	@ApiImplicitParam(name = "tBoNo", value = "동행 게시글 번호")/*swagger 에서 출력 값*/
	@DeleteMapping(value = "/tripboard/{tBoNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripboard_delete_action(@PathVariable(value = "tBoNo")int tBoNo, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<TripBoard> data = new ArrayList<TripBoard>();
		try {
			int rowCount = tripBoardService.deleteTripBoard(tBoNo);
			if(rowCount == 1) {
				code = 1;
				msg = "성공";
			}else {
				code = 2;
				msg = "게시글 삭제 실패";
				TripBoard failTripBoard = tripBoardService.selectByTbNo(tBoNo);
				data.add(failTripBoard);
			}
		} catch (Exception e) {
			// 에러시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의바랍니다.";
		}
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	/*
	 * 키워드로 검색된 동행게시판 리스트(keyword) - 페이징 처리
	 */
	@ApiOperation(value = "동행게시판 title 검색 결과 리스트")
	@GetMapping(value = "/tripboard-search/{keyword}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_search_list(@RequestParam(required = false, defaultValue = "1")int pageNo,
														@PathVariable String keyword){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			//페이지 번호(default 값 1)와 검색 keyword로 동행 게시글 키워드로 찾기. 성공시 code 1
			tripBoardList = tripBoardService.selectSearchTbList(pageNo, keyword);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";
			}else {
				code = 2;
				msg = "해당 키워드와 일치하는 게시글이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	/*
	 * 동행 게시글 모집 상태별로 보기(tBoStatus) - 페이징 처리
	 */
	@ApiOperation(value = "동행 게시글 모집 상태별로 보기")
	@GetMapping(value = "/tripboard-status-list", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_status_list(@RequestParam(required = false, defaultValue = "1")int tBoNo,
													 @RequestParam(required = true) int tBoStatus){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			//페이지 번호(default 값 1)와 검색 status로 동행 게시글 키워드로 찾기. 성공시 code 1
			tripBoardList = tripBoardService.selectByTbStatusList(tBoNo, tBoStatus);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";
			}else {
				code = 2;
				msg = "해당 키워드 결과 값이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	/*
	 * 동행 게시글 해시태그별로 보기(hashtag) - 페이징 처리
	 */
	@ApiOperation(value = "동행 게시글 해시태그별로 보기(hashtag)")
	@GetMapping(value = "/tripboard-hashtag-list", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_hashtag_list(@RequestParam(required = false, defaultValue = "1")int tBoNo,
													 @RequestParam(required = true) String hashtag){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			//페이지 번호(default 값 1)와 검색 hashtag로 동행 게시글 키워드로 찾기. 성공시 code 1
			tripBoardList = tripBoardService.selectByHashtagList(tBoNo, hashtag);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";
			}else {
				code = 2;
				msg = "해당 키워드 결과 값이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	/*
	 * 동행 게시글 지역별로 보기(cityNo) - 페이징 처리
	 */
	@ApiOperation(value = "동행 게시글 지역별로 보기(cityNo)")
	@GetMapping(value = "/tripboard-city-list", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_hashtag_list(@RequestParam(required = false, defaultValue = "1")int tBoNo,
													 @RequestParam(required = true) int cityNo){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			//페이지 번호(default 값 1)와 검색 cityNo로 동행 게시글 키워드로 찾기. 성공시 code 1
			tripBoardList = tripBoardService.selectByCityNoList(tBoNo, cityNo);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";
			}else {
				code = 2;
				msg = "해당 지역과 일치하는 게시글이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	/*
	 * 동행 게시판 리스트 정렬(조회수 기준 내림차순(readcount)) - 페이징 처리
	 */
	@ApiOperation(value = "동행 게시판 조회수 정렬 리스트(readcount)")
	@GetMapping(value = "/tripboard-readcount", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripboard_readcount_list(@RequestParam(required = false, defaultValue = "1")int pageNo){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			// 페이지 번호(default 값 1)로 동행 게시글 조회순 찾기, 성공시 code 1
			tripBoardList = tripBoardService.selectAllOrderByReadCount(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
		
	}
	/*
	 * 동행 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순(date)) - 페이징 처리
	 */
	@ApiOperation(value = "동행 게시판 작성 날짜 정렬 리스트(date)")
	@GetMapping(value = "/tripboard-date-desc", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripboard_date_list(@RequestParam(required = false, defaultValue = "1")int pageNo){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			// 페이지 번호(default 값 1)로 동행 게시글 작성 날짜순 찾기, 성공시 code 1
			tripBoardList = tripBoardService.selectAllOrderByDate(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
		
	}
	/*
	 * 동행 게시판 리스트 - 페이징 처리
	 */
	@ApiOperation(value = "동행 게시판 리스트")
	@GetMapping(value = "/tripboard-all-list", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripboard_all_list(@RequestParam(required = false, defaultValue = "1")int pageNo){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			// 페이지 번호(default 값 1)로 동행 게시판 리스트, 성공시 code 1
			tripBoardList = tripBoardService.selectAllTb(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
		
	}
	
}
