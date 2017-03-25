package com.breeze.bmwdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.TextView;

import com.breeze.bmwdemo.R;
import com.breeze.bmwdemo.model.LocationModel;

import java.io.Serializable;

/**
 *
 *
 *
 */
public class LocationDetailFragment extends Fragment
{

	private static final String ARG_PARAM1 = "param1";


	public static LocationDetailFragment newInstance(Serializable param1) {
		LocationDetailFragment fragment = new LocationDetailFragment();
		Bundle args = new Bundle();
		args.putSerializable(ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		LocationModel locationInfo = (LocationModel)getArguments().getSerializable(ARG_PARAM1);

		View locationDetailFragment = inflater.inflate(R.layout.fragment_location_detail,container,false);
		TextView nameTextView = (TextView)locationDetailFragment.findViewById(R.id.text_name);
		nameTextView.setText(locationInfo.getName());
		TextView addressTextView = (TextView)locationDetailFragment.findViewById(R.id.text_address);
		addressTextView.setText(locationInfo.getAddress());
		TextView arrivaltimeTextView = (TextView)locationDetailFragment.findViewById(R.id.text_arrivaltime);
		arrivaltimeTextView.setText(locationInfo.getArrivalTime());
		TextView latitudeTextView = (TextView)locationDetailFragment.findViewById(R.id.text_latitude);
		latitudeTextView.setText(locationInfo.getLatitude());
		TextView longitudeTextView = (TextView)locationDetailFragment.findViewById(R.id.text_longitude);
		longitudeTextView.setText(locationInfo.getLongitude());
		return locationDetailFragment;
	}
}
