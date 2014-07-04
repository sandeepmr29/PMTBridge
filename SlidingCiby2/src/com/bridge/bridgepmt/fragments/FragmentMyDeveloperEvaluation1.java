package com.bridge.bridgepmt.fragments;



import com.bridge.bridgepmt.activities.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;



public class FragmentMyDeveloperEvaluation1 extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    TextView mTitletxtview;
    public FragmentMyDeveloperEvaluation1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developerevaluation, null);
        
        return view;
    }



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}
	
	
}
