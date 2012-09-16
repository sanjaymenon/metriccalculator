package com.metric.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.*;


@Controller
@RequestMapping("/main")
public class MediatorController {

	@RequestMapping(value="/metrics",method= RequestMethod.GET )
	public String getMetricsPage()
	{
		return "metrics";
	}
	
}
