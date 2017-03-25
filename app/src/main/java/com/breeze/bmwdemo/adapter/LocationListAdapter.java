package com.breeze.bmwdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.breeze.bmwdemo.R;
import com.breeze.bmwdemo.model.LocationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lesley on 2017/3/25.
 */
public class LocationListAdapter extends ArrayAdapter<LocationModel>
{
	private  LayoutInflater inflater;

	private List<LocationModel> loactionList = new ArrayList<LocationModel>();



	public LocationListAdapter(Context context, List<LocationModel> objects)
	{
		super(context, 0, objects);
		inflater = LayoutInflater.from(context);
	}



	@Override
	public int getCount()
	{
		if(loactionList == null)
		{
			return 0;
		}
		else
		{
			return loactionList.size();
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{

		if(convertView == null )
		{
			convertView = inflater.inflate(R.layout.location_item,null);
		}

		LocationModel locationItem = getItem(position);
		TextView name = (TextView) convertView.findViewById(R.id.loaction_name);
		name.setText(locationItem.getName());
		TextView date = (TextView) convertView.findViewById(R.id.address);
		date.setText(locationItem.getAddress());
		return convertView;
	}

	@Override
	public LocationModel getItem(int position)
	{
		if(loactionList.isEmpty())
		{
			return null;
		}
		else
			return loactionList.get(position);
	}

	public List<LocationModel> getLoactionList()
	{
		return loactionList;
	}

	public void setLoactionList(List<LocationModel> loactionList)
	{
		this.loactionList = loactionList;
	}
}
