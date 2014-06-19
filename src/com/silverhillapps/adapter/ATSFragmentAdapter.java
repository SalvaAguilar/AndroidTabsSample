package com.silverhillapps.adapter;

import java.util.HashMap;

import com.silverhillapps.fragments.ATSListFragmentTimeline;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * This is the section adapter that rules the tab management in the application.
 * @author SalvaAguilar
 *
 */
public class ATSFragmentAdapter extends FragmentPagerAdapter {

	private HashMap<Integer, Fragment> mElements;
	private HashMap<Integer, String> mTitles;

	public ATSFragmentAdapter(FragmentManager fm) {
		super(fm);
		
		mElements = new HashMap<Integer,Fragment>();
		mTitles = new HashMap<Integer, String>();
	}

	public Fragment getFragment(int pos){
		Fragment f = null;
		if(mElements != null){
			if(mElements.containsKey(pos)){
				f = mElements.get(pos);
			}
		}
		return f;
	}

	@Override
	public Fragment getItem(int position) {

		if(!mElements.containsKey(position)){
			addNewElement(position, "new " + getCount());
		}
		 return mElements.get(position);
	}


	@Override
	public int getCount() {
		
		return mElements.size();
		
	}

	@Override
	public CharSequence getPageTitle(int position) {
		
		return mTitles.get(position);  
	}

	
	// Methods for creation and deletion
	
	private void addNewElement(int position, String text){
		Fragment fragment = ATSListFragmentTimeline.newInstance(position, text);
		mElements.put(position, fragment);
	}
	
	private void addNewElementTitle(int position, String text){
		mTitles.put(position, text);
	}
	
	public void addNewTab(String text){
		int pos = getCount();
		addNewElement(pos, text);
		addNewElementTitle(pos, text);
	}
	
	public void delLastTab(){
		int pos = getCount()-1;
		if(pos>0){
			delElement(pos);
			delElementTitle(pos);
		}
	}
	
	private void delElement(int position){
		mElements.remove(position);
	}
	
	private void delElementTitle(int position){
		mTitles.remove(position);
	}

}
