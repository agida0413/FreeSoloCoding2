package com.sist.무신사크롤링_기능구현.VO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class clothVO implements Serializable{
	private int ranking;
	private String state;
	private String sex;
	private String brand;
	private String item_name;
	private String real_price;
	private String now_price;
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getReal_price() {
		return real_price;
	}
	public void setReal_price(String real_price) {
		this.real_price = real_price;
	}
	public String getNow_price() {
		return now_price;
	}
	public void setNow_price(String now_price) {
		this.now_price = now_price;
	}
	

}
