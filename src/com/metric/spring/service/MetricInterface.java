package com.metric.spring.service;

import com.metric.spring.domain.Metricname;
import java.util.List;

public interface MetricInterface {
	
	public List<Metricname> getAll();
	
	public Boolean add(Metricname metricname);
	
	
	

}
