package com.hyungeerhee.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyungeerhee.spring.ex.mybatis.domain.Review;
import com.hyungeerhee.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	// 전달된 id를 가진 리뷰정보를 json으로 response에 담는다.
	// request parameter 
	// /mybatis/reveiw?id=3
	@RequestMapping("/mybatis/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		
		
		Review review = reviewService.getReview(id);
		return review;
	}
	
}