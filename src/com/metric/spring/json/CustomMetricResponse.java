package com.metric.spring.json;

import java.util.List;

import com.metric.spring.*;
import com.metric.spring.domain.Metricname;

public class CustomMetricResponse {
	
	/**
	* Current page of the query
	*/
	private String page;
	 
	/**
	* Total pages for the query
	*/
	private String total;
	 
	/**
	* Total number of records for the query
	*/
	private String records;
	 
	/**
	* An array that contains the actual objects
	*/
	private List<Metricname> rows;
	 
	 
	public CustomMetricResponse() {
	}
	 
	public String getPage() {
	return page;
	}
	 
	public void setPage(String page) {
	this.page = page;
	}
	 
	public String getTotal() {
	return total;
	}
	 
	public void setTotal(String total) {
	this.total = total;
	}
	 
	public String getRecords() {
	return records;
	}
	 
	public void setRecords(String records) {
	this.records = records;
	}
	 
	public List<Metricname> getRows() {
	return rows;
	}
	 
	public void setRows(List<Metricname> rows) {
	this.rows = rows;
	}

}
