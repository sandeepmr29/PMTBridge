package com.bridge.bridgepmt.fragments;


import com.bridge.bridgepmt.activities.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;



public class FragmentMyContactUs extends Fragment {
   
    TextView mTitletxtview;
    public FragmentMyContactUs() {
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contactus, null);
    
       
        View v=getActivity().getActionBar().getCustomView();
        
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

	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	     View v=getActivity().getActionBar().getCustomView();
	     TextView mhead=(TextView)v.findViewById(R.id.mytext);
	     mhead.setText("Contact Us");
	     TextView maptxtview=(TextView)v.findViewById(R.id.txt_map);

if(maptxtview.getVisibility()==View.VISIBLE)
{
maptxtview.setVisibility(View.INVISIBLE);

}
	}
	
	
}
