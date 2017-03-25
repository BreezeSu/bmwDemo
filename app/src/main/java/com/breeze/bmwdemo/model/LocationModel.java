package com.breeze.bmwdemo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Location info model
 * Created by Lesley on 2017/3/25.
 */
public class LocationModel implements Serializable
{
	/**
	 * ID
	 */
	@SerializedName("ID")
	private String id;

	/**
	 * location name
	 */
	@SerializedName("Name")
	private String name;

	/**
	 * location latitude
	 */
	@SerializedName("Latitude")
	private String latitude;

	/**
	 * location longitude
	 */
	@SerializedName("Longitude")
	private String longitude;

	/**
	 * location address
	 */
	@SerializedName("Address")
	private String address;

	/**
	 * arrival time
	 */
	@SerializedName("ArrivalTime")
	private String arrivalTime;


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getArrivalTime()
	{
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
}
