package com.breeze.bmwdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.breeze.bmwdemo.R;
import com.breeze.bmwdemo.adapter.LocationListAdapter;
import com.breeze.bmwdemo.httpService.HttpService;
import com.breeze.bmwdemo.model.LocationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.*;

public class LocationListActivity extends AppCompatActivity
{

	private LocationListAdapter locationListAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_list);


		List<LocationModel> locationList = new ArrayList<LocationModel>();
		locationListAdapter = new LocationListAdapter(this,locationList);
		final ListView locationListView = (ListView)findViewById(R.id.locationlist_view);
		locationListView.setAdapter(locationListAdapter);
		new Thread(new QueryLocationInfoRunnable(handler)).start();
		locationListView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				LocationModel locationModel =locationListAdapter.getLoactionList().get(position);

				Intent intent = new Intent(LocationListActivity.this,LocationDetailActivity.class);
				intent.putExtra("location",locationModel);
				startActivity(intent);
			}
		});



	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.filter, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()){
			case R.id.menu_address:
				return true;
			case R.id.menu_name:
				return true;
			case R.id.menu_time:
				return true;
			default:
				return false;
		}
	}






	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle data = msg.getData();
			List <LocationModel> locationList = (List<LocationModel>) data.getSerializable("locationInfoList");
			locationListAdapter.setLoactionList(locationList);
			locationListAdapter.notifyDataSetChanged();
		}
	};







	private class QueryLocationInfoRunnable implements Runnable
	{
		private Handler innerHandler = null;

		public QueryLocationInfoRunnable(Handler handler)
		{
			innerHandler = handler;
		}

		@Override
		public void run() {

			Message msg = new Message();
			Bundle data = new Bundle();
			List<LocationModel> locationList = HttpService.getInstance().getLocationList("http://localsearch.azurewebsites.net/api/Locations");

			data.putSerializable("locationInfoList", (Serializable)locationList);
			msg.setData(data);
			handler.sendMessage(msg);
		}
	}
}
