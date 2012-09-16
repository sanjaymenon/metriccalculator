package com.metric.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.*;

import com.metric.spring.domain.Metricname;
import com.metric.spring.json.CustomMetricResponse;
import com.metric.spring.service.MetricService;
import com.metric.spring.json.CustomGenericResponse;

@Controller
@RequestMapping("/crud")

public class MetricController {
	
	@Resource(name="metricService")
	private MetricService metricService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody CustomMetricResponse getAll()
	{
		List <Metricname> mnames = metricService.getAll();
		
		CustomMetricResponse response =new CustomMetricResponse();
		
		response.setRows(mnames);
		response.setRecords(String.valueOf(mnames.size()));
		response.setPage("1");
		response.setTotal("10");
		
		return response;
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public @ResponseBody CustomGenericResponse add(@RequestParam("displayname") String displayName, @RequestParam("value") String value)
	 {
		 Metricname mname =new Metricname();
		 mname.setMetricDisplayName(displayName);
		 String metricvalue = value;
		 
		 mname.setMetricNumber(value);
		 Boolean success = metricService.add(mname);
		 
		 if(success == true)
		 {
			 CustomGenericResponse response = new CustomGenericResponse();
		       response.setSuccess(true);
		       response.setMessage("Action successful!");
		          return response;
		 }
		 else 
		 {
			 CustomGenericResponse response = new CustomGenericResponse();
		       response.setSuccess(false);
		       response.setMessage("Action failure!");
		          return response;
		 }
		 
	 }
	
}
