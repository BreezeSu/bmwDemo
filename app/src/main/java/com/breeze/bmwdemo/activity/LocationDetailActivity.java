package com.breeze.bmwdemo.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.breeze.bmwdemo.R;
import com.breeze.bmwdemo.fragment.LocationDetailFragment;
import com.breeze.bmwdemo.model.LocationModel;

public class LocationDetailActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_detail);
		LocationModel selectedInfo = (LocationModel)getIntent().getExtras().getSerializable("location");
		setTitle(getString(R.string.detail_title_location)+selectedInfo.getName());
		FragmentManager fmgr = getFragmentManager();
		Fragment fragment = LocationDetailFragment.newInstance(selectedInfo);
		fmgr.beginTransaction().add(R.id.framelayout_loaction_info,fragment).commit();

	}

}
