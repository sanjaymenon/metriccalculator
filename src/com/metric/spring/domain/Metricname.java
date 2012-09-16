package com.metric.spring.domain;

public class Metricname {

	private String metricNumber;
	private String metricDisplayname;
	
	public void setMetricNumber(String metricNumber)
	{
		this.metricNumber=metricNumber;
	}
	
	public String getMetricName()
	{
		return this.metricNumber;
	}
	
	public void setMetricDisplayName(String metricDisplayname)
	{
		this.metricDisplayname= metricDisplayname;
	}
	
	public String getMetricDisplayName()
	{
		return this.metricDisplayname;
	}
}
