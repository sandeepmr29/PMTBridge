package com.bridge.bridgepmt.viewmanager;

import java.util.ArrayList;

import android.content.Context;

import com.bridge.bridgepmt.interfaces.ListOfEvaluateQuestionManagerListner;
import com.bridge.bridgepmt.interfaces.PMTQuestionAnswerPOstListner;
import com.bridge.bridgepmt.model.PMTEvaluationQuestionsScreenReturns;
import com.bridge.bridgepmt.modelmanager.ListOfEvaluateQuestionModelManager;

public class ListOfEvaluateQuestionManager implements ListOfEvaluateQuestionManagerListner,PMTQuestionAnswerPOstListner{

	 public ListOfEvaluateQuestionManagerListner IListOfEvaluateQuestionManagerListner;
	 public PMTQuestionAnswerPOstListner  IPMTQuestionAnswerPOstListner;
	 
	 public  ListOfEvaluateQuestionManager()
		{
			
		}
	 
	 public void questions(Context mContext, String ifGetRequest) 
		{
			 ListOfEvaluateQuestionModelManager listOfEvaluateQuestionModelManager = new ListOfEvaluateQuestionModelManager();
			 listOfEvaluateQuestionModelManager.IListOfEvaluateQuestionManagerListner=ListOfEvaluateQuestionManager.this;
			 listOfEvaluateQuestionModelManager.evaluationQuestions(mContext,ifGetRequest);
			
		}

	@Override
	public void evaluateQuestionFinished(
			PMTEvaluationQuestionsScreenReturns pMTEvaluationQuestionsScreenReturns) {
		IListOfEvaluateQuestionManagerListner.evaluateQuestionFinished(pMTEvaluationQuestionsScreenReturns);
		
	}

	public void postAnswers(Context mContext, String method, String date, int year, ArrayList<String> mannschaftsnamen) 
	{
		ListOfEvaluateQuestionModelManager listOfEvaluateQuestionModelManager = new ListOfEvaluateQuestionModelManager();
		 listOfEvaluateQuestionModelManager.IPMTQuestionAnswerPOstListner=ListOfEvaluateQuestionManager.this;
		 listOfEvaluateQuestionModelManager.postEvaluatedAnswers(mContext,method,date,year,mannschaftsnamen);
		
	}

	

	@Override
	public void postSuccess(
			PMTEvaluationQuestionsScreenReturns pMTEvaluationQuestionsScreenReturns)
	{
		IPMTQuestionAnswerPOstListner.postSuccess(pMTEvaluationQuestionsScreenReturns);
		
		
	}

}
