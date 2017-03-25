package com.breeze.bmwdemo.httpService;

import android.util.Log;

import com.breeze.bmwdemo.model.LocationModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lesley on 2017/3/25.
 */
public class HttpService
{
	private static HttpService INSTANCE;

	private  OkHttpClient client;

	private final static String TAG="HttpService";

	private HttpService()
	{
		client = new OkHttpClient();
	}



	public static HttpService getInstance()
	{
		if (INSTANCE == null)
			INSTANCE = new HttpService();
		return INSTANCE;
	}



	public List<LocationModel> getLocationList(String url)
	{
		List<LocationModel> locationList = new ArrayList<LocationModel>();
		try
		{
			String jsonData = get(url);

			Gson json = new Gson();
			locationList = json.fromJson(jsonData,new TypeToken<List<LocationModel>>(){}.getType());

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return locationList;
	}



    private  String get(String url) throws IOException
	{

		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful())
		{
			return response.body().string();
		}
		else
		{
			Log.e(TAG,"Unexpected code " + response);
		}
		return null;
	}
}
