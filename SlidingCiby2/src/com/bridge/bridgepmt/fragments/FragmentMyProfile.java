package com.bridge.bridgepmt.fragments;

import java.io.File;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.utilities.SMUtility;
import com.bridge.bridgepmt.views.LoginScreen;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class FragmentMyProfile  extends Fragment {
   

    ImageView mImClientImage;
    Fragment  mSelectProfilePicFragment;
   
    
 // this is the action code we use in our intent, 
    // this way we know we're looking at the response from our own action
    private static final int SELECT_PICTURE = 1;
    
    private String selectedImagePath;
  
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myprofile, null);
        Bridgepmt.setCurrentlogin(2);
        mImClientImage=(ImageView)view.findViewById(R.id.ImClientImage);
        
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    Log.i("tag", "keyCode: " + keyCode);
                    if( keyCode == KeyEvent.KEYCODE_BACK ) {
                            Log.i("tag", "onKey Back listener is working!!!");
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        
        
        return view;
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	
	       onImageClick();
   
	}

	private void onImageClick() 
	{
		  mImClientImage.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
					 showProfilePicAlertDialog();
					

				}
			});    
		     
		
	}

	protected void showProfilePicAlertDialog() 
	{
		 final Dialog dialog = new Dialog(getActivity());
		  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		  //tell the Dialog to use the dialog.xml as it's layout description
          dialog.setContentView(R.layout.fragment_selectprofilepic);
          
          TextView mtxt = (TextView) dialog.findViewById(R.id.txt_nearby);
          TextView mtxttvTakePhoto = (TextView) dialog.findViewById(R.id.tvTakePhoto);
          TextView mtxttvChoosePhoto = (TextView) dialog.findViewById(R.id.tvChoosePhoto);
          Button mtxttvCancel = (Button) dialog.findViewById(R.id.btnCancel);
          
          mtxttvCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				dialog.dismiss(); 
				
			}
		});
          
          
          mtxttvTakePhoto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				PackageManager pm = getActivity().getPackageManager();

				if (pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) 
				{
					Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					startActivityForResult(takePicture, 0);//zero can be replaced with any action code
					dialog.dismiss();  
				}
				else
				{
					SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoCameraAvailable));
				}
				
			}
		});
          
          mtxttvChoosePhoto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{

				
				Intent pickPhoto = new Intent(Intent.ACTION_PICK,
				           android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
				dialog.dismiss(); 
			}
		});
          
          dialog.show();  
          
	}


	
	
	
	public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 
		switch(requestCode) {
		case 0:
		    if(resultCode == getActivity().RESULT_OK){  
		        Uri selectedImage = imageReturnedIntent.getData();
		        mImClientImage.setImageURI(selectedImage);
		       
		    }

		break; 
		case 1:
		    if(resultCode == getActivity().RESULT_OK){  
		        Uri selectedImage = imageReturnedIntent.getData();
		        mImClientImage.setImageURI(selectedImage);
		      
		    }
		break;
		}
		
		}
	
	/**
     * helper to retrieve the path of an image URI
     */
    public String getPath(Uri uri) {
            // just some safety built in 
            if( uri == null ) {
                // TODO perform some logging or show user feedback
                return null;
            }
            // try to retrieve the image from the media store first
            // this will only work for images selected from gallery
            String[] projection = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
            if( cursor != null ){
                int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            }
            // this is our fallback here
            return uri.getPath();
    }
    
    
    

	
}
