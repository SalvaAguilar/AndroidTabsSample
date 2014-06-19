package com.silverhillapps.fragments;

import java.util.ArrayList;
import com.silverhillapps.adapter.PerformanceAdapterText;
import com.silverhillapps.androidtabssample.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Sample fragment which contains a list that identifies the tab where we are.
 * @author SalvaAguilar
 *
 */
public class ATSListFragmentTimeline extends Fragment implements OnItemClickListener{


	private ArrayList<String> mListItems;
	private ListView mListView;
	private PerformanceAdapterText mAdapter;
	
	private String text;
	private int position;

	public static ATSListFragmentTimeline newInstance(int pos, String text) {

		ATSListFragmentTimeline fragment = new ATSListFragmentTimeline();
		
		fragment.text = text;
		fragment.position = pos;
		
		return fragment;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.list_layout,null);

		mListView = (ListView) v.findViewById(R.id.list);
		
		// Create some dummy data
		if(mListItems == null){
			mListItems = new ArrayList<String>();
			for(int i = 0; i<10;i++){
				mListItems.add(text + ": " + i);
			}
		}
		
		mAdapter = new PerformanceAdapterText(vg.getContext(), mListItems, inflater);

		mListView.setAdapter(mAdapter);

		mListView.setOnItemClickListener(this);
		
		return v;

	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this.getActivity(), "Clicked " + position, Toast.LENGTH_LONG).show();
		
	}

}