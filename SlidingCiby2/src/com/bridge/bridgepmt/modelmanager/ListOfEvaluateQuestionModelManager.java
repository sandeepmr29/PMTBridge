package com.bridge.bridgepmt.modelmanager;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.util.Log;

import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.helper.AsyncWebHandler;
import com.bridge.bridgepmt.helper.AsyncWebHandlerForGetApi;
import com.bridge.bridgepmt.interfaces.ListOfEvaluateQuestionManagerListner;
import com.bridge.bridgepmt.interfaces.PMTQuestionAnswerPOstListner;
import com.bridge.bridgepmt.model.PMTEvaluationQuestionsScreenReturns;
import com.google.gson.Gson;

public class ListOfEvaluateQuestionModelManager {
	 public ListOfEvaluateQuestionManagerListner IListOfEvaluateQuestionManagerListner;
	public PMTQuestionAnswerPOstListner IPMTQuestionAnswerPOstListner;
	 
	
	public  ListOfEvaluateQuestionModelManager()
	{
		
	}


	public void evaluationQuestions(Context mContext, String ifGetRequest) 
	{
		 new AsyncWebHandlerForGetApi() {

			@Override
			public HttpUriRequest getHttpRequestMethod() {
				HttpGet httpget = new HttpGet("http://10.0.0.113:8080/api/evaluationquestions/"+Bridgepmt.getClientid()
						+"/"+Bridgepmt.getAccessToken());
				return httpget;
			}

			@Override
			public void ongetResponse(String result) {
				PMTEvaluationQuestionsScreenReturns pMTEvaluationQuestionsScreenReturns = null;
				
				Gson gson = new Gson();
				
				 try {
					 pMTEvaluationQuestionsScreenReturns=gson.fromJson(result, PMTEvaluationQuestionsScreenReturns.class);
//						 developerDetails= listOfDeveloperScreenReturns.getProjects();
						 
//						 IListOfProjectsModelmanagerListner.onDidFinished(listOfProjectScreenReturns);
					  IListOfEvaluateQuestionManagerListner.evaluateQuestionFinished(pMTEvaluationQuestionsScreenReturns);
					  
//					  IPMTQuestionAnswerPOstListner.postSuccess(pMTEvaluationQuestionsScreenReturns);
				  } catch (Exception ex) {
				   
				   Log.e("error", ex.getMessage());
				   
				  }
				
			}
			 
			 
			}.execute(ifGetRequest);
			
		
	}


	public void postEvaluatedAnswers(Context mContext, String method, final String date, final int year, final ArrayList<String> mannschaftsnamen)
	{
		new AsyncWebHandler() {

			@Override
			public HttpUriRequest postHttpRequestMethod()
					throws UnsupportedEncodingException {
//				String datas=("token"+":"+"8c74befdb52d02913813152fd01a4312"+","+"survey_id"+":"+"9"+","+"client_id"+":"+"748"+","+
//						"devid"+":"+"791"+","+"month"+":"+"4"+","+"year"+":"+"2014"+","+"date"+":"+"2014-07-08"+","+"answers"+":"+"1"+":"+"2"+","+"3"+":"+"5"+","+"3"+":"+"7");
						
				HttpPost httppost = new HttpPost("http://10.0.0.113:8080/api/submitevaluation");
				 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				 nameValuePairs.add(new BasicNameValuePair("token",Bridgepmt.getAccessToken()));
		         nameValuePairs.add(new BasicNameValuePair("survey_id",Integer.toString(Bridgepmt.getSurvey_id())));
		         nameValuePairs.add(new BasicNameValuePair("client_id",Integer.toString(Bridgepmt.getClientid())));
		         nameValuePairs.add(new BasicNameValuePair("devid",Integer.toString(Bridgepmt.getDeveloperid())));
		         nameValuePairs.add(new BasicNameValuePair("month",Integer.toString(Bridgepmt.getMonth())));
		         nameValuePairs.add(new BasicNameValuePair("year",Integer.toString(year)));
		         nameValuePairs.add(new BasicNameValuePair("date",date));
//		         nameValuePairs.add(new BasicNameValuePair("answers",":"+"1"+":"+"2"+","+"3"+":"+"5"+","+"3"+":"+"7"));
		         nameValuePairs.add(new BasicNameValuePair("answers",mannschaftsnamen.toString()));
		         
		         try {
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         catch(Exception e)
		         {
		        	 Log.e("Error", "Error");
		         }
				
				return httppost;
			}

			@Override
			public void onResponse(String result) 
			{
				
        PMTEvaluationQuestionsScreenReturns pMTEvaluationQuestionsScreenReturns = null;
				
				Gson gson = new Gson();
				
				 try {
					 pMTEvaluationQuestionsScreenReturns=gson.fromJson(result, PMTEvaluationQuestionsScreenReturns.class);
//						 developerDetails= listOfDeveloperScreenReturns.getProjects();
						 
//						 IListOfProjectsModelmanagerListner.onDidFinished(listOfProjectScreenReturns);
//					  IListOfEvaluateQuestionManagerListner.evaluateQuestionFinished(pMTEvaluationQuestionsScreenReturns);
					  
					  IPMTQuestionAnswerPOstListner.postSuccess(pMTEvaluationQuestionsScreenReturns);
				  } catch (Exception ex) {
				   
				   Log.e("error", ex.getMessage());
				   
				  }
			}
			
		}.execute(method);
		
	}
}
