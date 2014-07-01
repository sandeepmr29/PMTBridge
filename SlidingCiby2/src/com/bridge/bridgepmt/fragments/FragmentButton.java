package com.bridge.bridgepmt.fragments;

import com.bridge.bridgepmt.activities.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class FragmentButton extends Fragment {
    Button button;
    
    public FragmentButton() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, null);
    
        button = (Button) view.findViewById(R.id.fragment_button_button);
        button.setText("Button after clicked");
        
        return view;
    }
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	     View v=getActivity().getActionBar().getCustomView();
	     TextView mhead=(TextView)v.findViewById(R.id.mytext);
	     mhead.setText("Button");
	}
}
