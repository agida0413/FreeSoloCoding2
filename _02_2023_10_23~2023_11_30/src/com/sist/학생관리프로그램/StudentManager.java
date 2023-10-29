package com.sist.학생관리프로그램;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {

	
	private static ArrayList<Student>list = new ArrayList<Student>();
	static {
		FileReader fr= null;
		try {
			fr =new FileReader("C:\\JavaDev\\Student.txt");
			int i = 0; 
			String data ="";
			while((i=fr.read())!=-1) {
				data+=(char)i;
				
			}
			String []msg = data.split("\n");
			
			for(int k =0;k<msg.length;k++) {
				StringTokenizer st = new StringTokenizer(msg[k],"|");
				st.nextToken();
				list.add(new Student( Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public ArrayList<Student> allData()
	{
		return list;
		
	}
	
	
	public void showAllData() {
		
		for(int i=0;i<list.size();i++) {
			System.out.println("--------------------");
			System.out.println("고유번호:"+i+1);
			System.out.println("학번:"+list.get(i).getHakbun());
			System.out.println("이름:"+list.get(i).getName());
			System.out.println("전공:"+list.get(i).getMajor());
			
		}
		
	}
	
	public Student showDetail(int hakbun) {
		Student st =null;
		for (Student student : list) {
			if (hakbun==student.getHakbun()) {
				st=student;
				break;
			}
		}
		
		return st;
	}
	
	public void reviseStudent(int hakbun) {
		int count =0;
		Scanner scan =new  Scanner(System.in);
		
		for(int i = 0; i<list.size();i++) {
			
				if (hakbun==list.get(i).getHakbun()) {
				
				
				System.out.print("수정할 이름:");
				String name =scan.next();
				System.out.print("수정할 학번:");
				int hak = scan.nextInt();
				System.out.print("수정할 전공:");
				String major =scan.next();
				System.out.print("수정할 학점:");
				String grade =scan.next();
				count++;
				list.set(i, new Student( hak, name, major, grade));
				
			}
			
		}
		
		if (count==0) {
			System.out.println("수정할 정보가 없습니다.");
		}
	}
	
	public void delete(int hakbun) {
		for(int i =0; i<list.size();i++) {
			
			if (list.get(i).getHakbun()==hakbun) {
				list.remove(i);
				System.out.println("삭제완료");
			}
		}
	}
	
	public void saveFile() {
		FileWriter fr =null;
		
		try {
			fr=new FileWriter("C:\\JavaDev\\Student.txt");
			
			
			for(int i=0;i<list.size();i++) {
				int hakbun=list.get(i).getHakbun();
				String name =list.get(i).getName();
				String major =list.get(i).getMajor();
				String grade =list.get(i).getGrade();
				
				String msg = (i+1)+"|"+hakbun+"|"+name+"|"+major+"|"+grade+"\n";
				fr.write(msg);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<Student> findData(String name){
		ArrayList<Student>ls=new ArrayList<Student>();
		for (Student student : list) {
			if (student.getName().contains(name)) {
				ls.add(student);
			}
		}
		
		return ls;
	}
	
	public void addStudent(Student st) {
		
		
		list.add(st);
	}
}
