package com.iagl.newvlille.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iagl.newvlille.R;
import com.iagl.newvlille.data.Station;

public class StationListAdapter extends BaseAdapter {

	private List<Station> data;
	private static LayoutInflater inflater = null;
	public Resources res;
	Station tempValues = null;
	int i = 0;

	/************* CustomAdapter Constructor *****************/
	public StationListAdapter(Activity activity, List<Station> list) {

		/********** Take passed values **********/
		data = list;
		/*********** Layout inflator to call external xml layout () ***********/
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	/******** What is the size of Passed Arraylist Size ************/
	public int getCount() {

		if (data.size() <= 0)
			return 1;
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView textPlaces;
		public TextView textVelos;
		public TextView textName;
	}

	/****** Depends upon data size called for each row , Create each ListView row *****/
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;
		ViewHolder holder;

		if (convertView == null) {

			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			view = inflater.inflate(R.layout.station_list_layout, null);

			/****** View Holder Object to contain tabitem.xml file elements ******/

			holder = new ViewHolder();
			holder.textPlaces = (TextView) view.findViewById(R.id.textPlaces);
			holder.textVelos = (TextView) view.findViewById(R.id.textVelos);
			holder.textName = (TextView) view.findViewById(R.id.textName);

			/************ Set holder with LayoutInflater ************/
			view.setTag(holder);
		} else
			holder = (ViewHolder) view.getTag();

		if (data.size() <= 0) {
			holder.textName.setText("No Data");

		} else {
			/***** Get each Model object from Arraylist ********/
			tempValues = null;
			tempValues = (Station) data.get(position);

			/************ Set Model values in Holder elements ***********/

			holder.textName.setText(tempValues.getName());
			holder.textPlaces.setText(tempValues.getPlaces()==-1?"???":String.valueOf(tempValues.getPlaces()));
			holder.textVelos.setText(tempValues.getVelos()==-1?"???":String.valueOf(tempValues.getVelos()));
			/******** Set Item Click Listner for LayoutInflater for each row *******/

		}
		return view;
	}

}
