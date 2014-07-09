package com.bridge.bridgepmt.app;



import java.io.File;



import android.app.Application;

public class Bridgepmt extends Application
{
	private static Bridgepmt sharedApplication;
	private static int currentlogin=1;
	private static File baseLocation;
	private static int clientid;
	private static int projectid;
	private static int developerid;
	private static String accessToken;
	private static int survey_id;
	private static int month;
	
	


	


	@Override
	public void onCreate() {
		super.onCreate();
		sharedApplication = this;
		if (isSdCardPresent()) {
			setBaseLocation(this.getExternalFilesDir(null));
		} else {
			setBaseLocation(this.getFilesDir());
		}
	}
	
	
	public static int getCurrentlogin() {
		return currentlogin;
	}



	public static void setCurrentlogin(int currentlogin) {
		Bridgepmt.currentlogin = currentlogin;
	}
	
	public static int getClientid() {
		return clientid;
	}


	public static void setClientid(int clientid) {
		Bridgepmt.clientid = clientid;
	}


	public static int getDeveloperid() {
		return developerid;
	}


	public static void setDeveloperid(int developerid) {
		Bridgepmt.developerid = developerid;
	}

	public static int getProjectid() {
		return projectid;
	}


	public static void setProjectid(int projectid) {
		Bridgepmt.projectid = projectid;
	}
	
	public static String getAccessToken() {
		return accessToken;
	}


	public static void setAccessToken(String accessToken) {
		Bridgepmt.accessToken = accessToken;
	}
	
	public static int getSurvey_id() {
		return survey_id;
	}


	public static void setSurvey_id(int survey_id) {
		Bridgepmt.survey_id = survey_id;
	}

	public static int getMonth() {
		return month;
	}


	public static void setMonth(int month) {
		Bridgepmt.month = month;
	}
	
	
	public static boolean isSdCardPresent() {
		return android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}
	
	public void setBaseLocation(File baseLocation) {
		sharedApplication.baseLocation = baseLocation;
	}
	

}
