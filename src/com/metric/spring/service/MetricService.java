package com.metric.spring.service;

import com.metric.spring.domain.*;

import java.util.*;

import javax.annotation.*;

import org.apache.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Service("metricService")
@Transactional
public class MetricService  implements MetricInterface{

	private List<Metricname> dummyMetricList = new ArrayList<Metricname>();
	
	public MetricService()
	{
		init();
	}
	
	public void init()
	{
		Metricname mname = new Metricname();
		mname.setMetricNumber("METRIC1");
		mname.setMetricDisplayName("Clicks");
		dummyMetricList.add(mname);
		
		mname = new Metricname();
		mname.setMetricNumber("METRIC2");
		mname.setMetricDisplayName("Conversions");
		dummyMetricList.add(mname);
		
		mname = new Metricname();
		mname.setMetricNumber("METRIC3");
		mname.setMetricDisplayName("MediaSpend");
		dummyMetricList.add(mname);
	}
	
	public Boolean add(Metricname mname)
	{
		try
		{
			dummyMetricList.add(mname);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public List<Metricname> getAll()
	{
		return dummyMetricList;
	}
}
