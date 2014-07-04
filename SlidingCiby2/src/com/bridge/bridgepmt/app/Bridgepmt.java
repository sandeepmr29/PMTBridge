package com.bridge.bridgepmt.app;



import java.io.File;



import android.app.Application;

public class Bridgepmt extends Application
{
	private static Bridgepmt sharedApplication;
	private static int currentlogin=1;
	private static File baseLocation;
	
	
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


	public static boolean isSdCardPresent() {
		return android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}
	
	public void setBaseLocation(File baseLocation) {
		sharedApplication.baseLocation = baseLocation;
	}
	

}
