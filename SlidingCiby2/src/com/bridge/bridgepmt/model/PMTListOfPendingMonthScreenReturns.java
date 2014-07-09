package com.bridge.bridgepmt.model;

import java.util.ArrayList;

public class PMTListOfPendingMonthScreenReturns
{
	ArrayList<PendingMonthdetails> months;
	
	   public ArrayList<PendingMonthdetails> getMonths() {
		return months;
	}
	public void setMonths(ArrayList<PendingMonthdetails> months) {
		this.months = months;
	}
	String status;	
		

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



}
