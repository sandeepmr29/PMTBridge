package com.example.slidingciby;

import java.util.ArrayList;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



public class ColorMenuFragment1 extends ListFragment {
    private ArrayList<SlidingmenuItem> navDrawerItems;
    private SlidingmenuAdapter adapter;
    private TypedArray navMenuIcons;
    private String[] lvMenuItems;
    private ListView lvMenu;;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
	
		
		View v=inflater.inflate(R.layout.list, null);
		
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	     lvMenuItems = getResources().getStringArray(R.array.menu_items);
		
	        navMenuIcons = getResources()
	                .obtainTypedArray(R.array.nav_drawer_icons);
		
		
		
	        navDrawerItems = new ArrayList<SlidingmenuItem>();
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[0], navMenuIcons.getResourceId(0, -1)));
	        // Find People
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[1], navMenuIcons.getResourceId(1, -1)));
	        // Photos
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[2], navMenuIcons.getResourceId(2, -1)));
	        // Find People
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[3], navMenuIcons.getResourceId(3, -1)));
	        
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[4], navMenuIcons.getResourceId(4, -1)));
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[5], navMenuIcons.getResourceId(5, -1)));
	        navDrawerItems.add(new SlidingmenuItem(lvMenuItems[6], navMenuIcons.getResourceId(6, -1)));
	        
	        navMenuIcons.recycle();
	        adapter=new SlidingmenuAdapter(getActivity(), navDrawerItems);
	        setListAdapter(adapter);
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
		
		
		
		
		/*
		
		String[] colors = getResources().getStringArray(R.array.color_names);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		setListAdapter(colorAdapter);
		*/
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new FragmentMyBuzzoek();
			break;
		case 1:
			newContent = new FragmentListView();
			break;
		case 2:
			newContent = new FragmentMyProfile();
			break;
		case 3:
			newContent = new FragmentNews();
			break;
		case 4:
			newContent = new FragmentTour();
			break;
		
	case 5:
		newContent = new FragmentSettings();
		break;
	case 6:
		newContent = new FragmentFeedback();
		break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		} 
		
		/*
		else if (getActivity() instanceof ResponsiveUIActivity) {
			ResponsiveUIActivity ra = (ResponsiveUIActivity) getActivity();
			ra.switchContent(fragment);
		}
		*/
	}


}
