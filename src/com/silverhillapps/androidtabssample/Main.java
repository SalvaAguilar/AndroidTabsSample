package com.silverhillapps.androidtabssample;

import com.silverhillapps.adapter.ATSFragmentAdapter;
import com.silverhillapps.androidtabssample.R;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


/**
 * This project is an example of tab navigation in Android with dynamic capabilities to delete and create tabs.
 * @author SalvaAguilar
 *
 */

public class Main extends ActionBarActivity implements
ActionBar.TabListener{

	private ATSFragmentAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;
	private PagerTitleStrip mPagerTitleStrip;
	
	private int currentTab = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set up the action bar.
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		
		setContentView(R.layout.activity_main);

		// Create the section adapter
		mSectionsPagerAdapter = new ATSFragmentAdapter(
				getSupportFragmentManager());
		
		// Populate with some dummy data
		mSectionsPagerAdapter.addNewTab("one");
		mSectionsPagerAdapter.addNewTab("two");
		mSectionsPagerAdapter.addNewTab("three");

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		// Create the pagerTitleStrip
		mPagerTitleStrip = (PagerTitleStrip)findViewById(R.id.pts_main_actividadB);
		
		mPagerTitleStrip.setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		// Manage the touch over title strip for forcing to update view pager
		if(event.getAction() == MotionEvent.ACTION_DOWN){
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		
		if(event.getX()>(width*0.8) && event.getX()<width){
			if((currentTab+1)<mSectionsPagerAdapter.getCount()){

				currentTab +=1;
				mViewPager.setCurrentItem(currentTab, true);

			}
		}
		
		if(event.getX()<(width*0.2) && event.getX()>0){
			if((currentTab-1)>=0){
				currentTab-=1;
				mViewPager.setCurrentItem(currentTab, true);
			}	
		}
		
		return true;
		}
		return false;
	}
});
		// Create the on page change listener from view pager
		mViewPager
		.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				mViewPager.setCurrentItem(position);
				currentTab = position;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Menu actions
		int id = item.getItemId();
		switch(id){
		case R.id.action_add:
			mSectionsPagerAdapter.addNewTab("new: " + mSectionsPagerAdapter.getCount());
			mSectionsPagerAdapter.notifyDataSetChanged();
			return true;
			
		case R.id.action_del:
			mSectionsPagerAdapter.delLastTab();
			mSectionsPagerAdapter.notifyDataSetChanged();
			return true;
			
		}
		
		return super.onOptionsItemSelected(item);
	}

	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
