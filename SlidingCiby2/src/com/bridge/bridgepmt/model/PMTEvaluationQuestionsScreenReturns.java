package com.bridge.bridgepmt.model;

import java.util.ArrayList;

public class PMTEvaluationQuestionsScreenReturns 
{
	ArrayList<EvaluationQuestiondetails> questions;
	public ArrayList<EvaluationQuestiondetails> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<EvaluationQuestiondetails> questions) {
		this.questions = questions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String status;

}
