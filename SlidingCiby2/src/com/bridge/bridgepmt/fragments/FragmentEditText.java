package com.bridge.bridgepmt.fragments;

import com.example.slidingciby.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;



public class FragmentEditText extends Fragment {
    EditText editText;
    
    public FragmentEditText() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edittext, null);
    
        editText = (EditText) view.findViewById(R.id.fragment_edittext_edittext);
        
        return view;
    }
    
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	     View v=getActivity().getActionBar().getCustomView();
	     TextView mhead=(TextView)v.findViewById(R.id.mytext);
	     mhead.setText("Edittext");
	}
    
    
}
