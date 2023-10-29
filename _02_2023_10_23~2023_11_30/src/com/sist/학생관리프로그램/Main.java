package com.sist.학생관리프로그램;


import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Source;

public class Main {
public static void main(String[] args) throws CloneNotSupportedException {
StudentManager sm =new StudentManager();




System.out.println("안녕하세요 학생관리 프로그램입니다.");

while(true) {
	ArrayList<Student> list = sm.allData();
	Scanner scan =new Scanner(System.in);
	System.out.println("1.전체학생목록 보기");
	System.out.println("2.상세보기");
	System.out.println("3.학생 정보수정");
	System.out.println("4.학생 삭제");
	System.out.println("5.학생 추가");
	System.out.println("6.학생 검색");
	System.out.println("7.프로그램종료");
	System.out.print("수행하실 항목을 입력하세요:");
	int answer =scan.nextInt();
	
	if (answer==7) {
		System.out.println("프로그램종료");
		System.exit(0);
	}
	else if (answer==1) {
		sm.showAllData();
	}
	else if (answer==2) {
		System.out.print("찾으실 학번을 입력하세요:");
		int answer2 =scan.nextInt(); 
		Student st = sm.showDetail(answer2);
		if (st==null) {
			System.out.println("찾으시는 정보가 없습니다.");
		}
		else {
			System.out.println("------------------");
			System.out.println("학번:"+st.getHakbun());
			System.out.println("이름:"+st.getName());
			System.out.println("전공:"+st.getMajor());
			System.out.println("성적:"+st.getGrade());
		}
	}
	else if (answer==3) {
		System.out.print("수정하실 학번을 입력하세요:");
		int answer3 =scan.nextInt();
		sm.reviseStudent(answer3);
	}
	else if (answer==4) {
		System.out.print("삭제하실 학번을 입력하세요:");
		
		int answer4=scan.nextInt();
		sm.delete(answer4);
	}
	
	else if (answer==5) {
		System.out.print("추가하실 학번:");
		int hakbun= scan.nextInt();
		System.out.print("추가하실 이름:");
		String name =scan.next();
		System.out.print("추가하실 전공:");
		String major = scan.next();
		System.out.print("추가하실 학점:");
		String grade=scan.next();
		Student std =new Student(hakbun, name, major, grade);
		sm.addStudent(std);
	}
	else if (answer==6) {
		System.out.print("이름입력:");
		String answer6 =scan.next();
		ArrayList<Student>findlist = sm.findData(answer6);
		
		for (Student student : findlist) {
			System.out.println("--------------------");
			System.out.println("학번:"+student.getHakbun());
			System.out.println("이름:"+student.getName());
			System.out.println("전공:"+student.getMajor());
		}
	}
	
	
	sm.saveFile();
}

}
}


