package com.iagl.newvlille.data;

public class Station {

	
	private int id;
	private float lati;
	private float longi;
	private String name;
	private StationDetail detail;
	
	
	public Station(String id,String lati,String longi,String name) {
		this.id = Integer.valueOf(id);
		this.lati = Float.valueOf(lati);
		this.longi = Float.valueOf(longi);
		this.name = name;
	}
	
	


	public int getPlaces() {
		if (detail==null) return -1;
		else return detail.getAttachs();
	}




	public int getVelos() {
		if (detail==null) return -1;
		else return detail.getBikes();
	}






	public StationDetail getDetail() {
		return detail;
	}




	public void setDetail(StationDetail detail) {
		this.detail = detail;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getLati() {
		return lati;
	}


	public void setLati(float lati) {
		this.lati = lati;
	}


	public float getLongi() {
		return longi;
	}


	public void setLongi(float longi) {
		this.longi = longi;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
