package com.silverhillapps.adapter;

import java.util.LinkedList;
import java.util.List;

import com.silverhillapps.androidtabssample.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * This class manages the row creation for each list in each fragment of the application.
 * @author SalvaAguilar
 *
 */
public class PerformanceAdapterText extends BaseAdapter{

	private List<String> list;
	private final Context context;
	private LayoutInflater inflator;


	public PerformanceAdapterText(Context context, List<String> list, LayoutInflater inflater) {
		super();
		this.context = context;
		this.inflator = inflater;
		this.list = list;	
	}



	static class ViewHolder {
		protected TextView title;

	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		final ViewHolder viewHolder;

		if (convertView == null) {

			convertView = inflator.inflate(R.layout.row_layout, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.title = (TextView) convertView.findViewById(R.id.title_textView_rowList);

			convertView.setTag(viewHolder);

		} 
		else {
			viewHolder = (ViewHolder)convertView.getTag();

		}

		viewHolder.title.setText(list.get(position));

		return convertView;
	}



	public int getCount() {
		return list.size();
	}

	
	public void addTodo(LinkedList<String> e){
		delTodo();
		this.list.addAll(e);
	}

	public void delTodo(){
		this.list = new LinkedList<String>();
	}


	@Override
	public Object getItem(int position) {
		return list.get(position);
	}



	@Override
	public long getItemId(int position) {
		return position;
	}



}