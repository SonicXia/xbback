package com.xiaobao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * 打开首页
	 * 返回一个逻辑视图，index为index.jsp对应的视图名称
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	/**
	 * 展示其他页面
	 * 对应index.jsp页面中attributes:{'url':'order-add'}等，返回的page即为order-add等视图
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
}
