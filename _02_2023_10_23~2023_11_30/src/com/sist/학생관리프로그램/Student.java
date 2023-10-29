package com.sist.학생관리프로그램;

import lombok.Getter;
import lombok.Setter;



public class Student {
	
	Student(int hakbun, String name , String major, String grade){
		this.hakbun=hakbun;
		this.name=name;
		this.major=major;
		this.grade =grade;
	}
	
	

	
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getHakbun() {
	return hakbun;
}
public void setHakbun(int hakbun) {
	this.hakbun = hakbun;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
private int hakbun;
private String grade;
private String major;

}
