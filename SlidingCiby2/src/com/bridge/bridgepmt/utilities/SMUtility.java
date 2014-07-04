package com.bridge.bridgepmt.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.views.LoginScreen;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.util.Log;

public class SMUtility 
{
	public static final String TAG = "SMUtility";
	
	/**
	 * Checks network availability
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		Log.v(TAG, "isNetworkAvailable called.");
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (cm.getActiveNetworkInfo() == null) {
			Log.d(TAG, "no active network info found.");
			return false;
		}

		Log.v(TAG, "active network info found.");
		return cm.getActiveNetworkInfo().isConnectedOrConnecting();
	}
	
	public static boolean isCredentialsnull(Context context,String userName,String passWord)
	{
		if(userName.length()>0 && passWord.length()>0 )
			return true;
		else
		return false;
				
	}
	
	public static boolean isEmail(Context context,String email)
	{
		if(email.length()>0 )
			return true;
		else
		return false;
				
	}
	
	/**
	 * Converting input stream to string
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String convertStreamToString(InputStream is)
			throws IOException {
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				is.close();
			}
			return sb.toString();
		} else {
			return "";
		}
	}
	
	public static void buildAlertMessage(Context context, String message) {
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(message)
				.setCancelable(false)
				.setPositiveButton(R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {

								dialog.cancel();
							}
						});

		final AlertDialog alert = builder.create();
		alert.show();
	}
}
