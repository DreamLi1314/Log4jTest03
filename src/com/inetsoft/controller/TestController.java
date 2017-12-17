package com.inetsoft.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	private static final Logger LOGGER = Logger.getLogger(TestController.class);
	
	@RequestMapping("/test")
	public ModelAndView testLog4j() {
		LOGGER.debug("This is debug message...");
		
		LOGGER.info("This is info message...");
		
		LOGGER.error("This is error message...");

		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "value");
		mv.setViewName("test");
		return mv;
	}
	
}
