package com.example.iss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
public class Forecast {
	public Observations observations;
	private String feedCreation;
	private String metric;
	

	public Observations getObservations() {
		return observations;
	}
	public void setObservations(Observations observations) {
		this.observations = observations;
	}
	public String getFeedCreation() {
		return feedCreation;
	}
	public void setFeedCreation(String feedCreation) {
		this.feedCreation = feedCreation;
	}
	public String getMetric() {
		return metric;
	}
	public void setMetric(String metric) {
		this.metric = metric;
	}
	
}
