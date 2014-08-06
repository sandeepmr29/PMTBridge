package com.bridge.bridgepmt.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.bridge.bridgepmt.activities.BaseActivity;
import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class FragmentChangeActivity extends BaseActivity {
	
	private Fragment mContent;
	
	
	public FragmentChangeActivity() {
		super(R.string.changing_fragments);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		
		if(Bridgepmt.getCurrentlogin()==1)
		{
			if (savedInstanceState != null)
				mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
			if (mContent == null)
				mContent = new FragmentMyProfile() ;
			
			
		}
		else
		{
			if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new FragmentMyDeveloperEvaluation();
		}


		


		
		
		
		
		
		
		
		
		
		
		// set the Above View
		setContentView(R.layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, mContent)
		.commit();
		
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new ColorMenuFragment1())
		.commit();
		
		// customize the SlidingMenu
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
	
	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		getSlidingMenu().showContent();
		
	}

}
