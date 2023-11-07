package com.sist.무신사크롤링_기능구현.manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.무신사크롤링_기능구현.VO.clothVO;

public class clothManager {
	
	private static ArrayList<clothVO>clist =new ArrayList<clothVO>();

	static {
		
		for(int k = 1;k<=10;k++) {
			try {
				Document doc =Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+k+"&viewType=small&priceMin=&priceMax=").get();
				
			Elements rank =doc.select("ul.snap-article-list p.label-default");
			Elements sex =doc.select("div.icon_group");
			Elements brand =doc.select("div.article_info p.item_title a");
			Elements item_name = doc.select("div.article_info p.list_info a");
			Elements price =doc.select("div.article_info p.price");
			for(int i =0; i<rank.size();i++) {
				
				clothVO vo =new clothVO();
				vo.setRanking(Integer.parseInt(rank.get(i).text().substring(0,rank.get(i).text().indexOf("위")).replace("\ufeff","")));
				vo.setState(rank.get(i).text().substring(rank.get(i).text().indexOf("위")+1).trim());
				vo.setSex(sex.get(i).text());
				vo.setBrand(brand.get(i).text());
				vo.setItem_name(item_name.get(i).text());
				
				if (price.get(i).text().substring(0,price.get(i).text().indexOf("원")+1)==null) {
					vo.setReal_price("x");
				}
				else {
					vo.setReal_price(price.get(i).text().substring(0,price.get(i).text().indexOf("원")+1));	
				}
				
				
				vo.setNow_price(price.get(i).text().substring(price.get(i).text().indexOf(" ")+1));
				clist.add(vo);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos =null;
		ObjectOutputStream oos =null;
		try {
			fos=new FileOutputStream("c://Free_data//cloth.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(clist);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		FileInputStream fis= null;
		ObjectInputStream ois =null;
		try {
			fis=new FileInputStream("c:\\Free_data\\cloth.txt");
			ois=new ObjectInputStream(fis);
			
		clist=(ArrayList<clothVO>)ois.readObject();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally {
		try {
			fis.close();
			ois.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}	
		}
		
		
	}
		
//		public static void main(String[] args) {
//			clothManager cm =new clothManager();
//			
//			for (clothVO vo : clist) {
//				System.out.println("랭킹:"+vo.getRanking());
//				System.out.println("순위변동:"+vo.getState());
//				System.out.println("성별:"+vo.getSex());
//				System.out.println("브랜드:"+vo.getBrand());
//				System.out.println("이름:"+vo.getItem_name());
//				System.out.println("정가:"+vo.getReal_price());
//				System.out.println("현재판매가:"+vo.getNow_price());
//				System.out.println("----------------------------------------------");
//			}
//		}
	
	
	public int totalPage() {
		int totalPage =(int)Math.ceil(clist.size()/5.0);
		return totalPage;
	}
	
	public ArrayList<clothVO> showOnePage(int page){
		ArrayList<clothVO>list =new ArrayList<clothVO>();
		int j=0;
		int rowsize=5;
		int rowpage = (page*rowsize)-rowsize;
		
		for(int i=0;i<clist.size();i++) {
			if (j<5 && i>=rowpage) {
				ArrayList<clothVO>temp =new ArrayList<clothVO>();
				list.add(clist.get(i));
				
				j++;
				
			}
			
		}
		
		
		return list;
	}
	
	public ArrayList<clothVO> findData(){
		ArrayList<clothVO> list=new ArrayList<clothVO>();
		String name ="";
		int answer =0;
		Scanner scan=new Scanner(System.in);
		try {
			
			System.out.print("이름으로 검색(1)/브랜드명으로 검색(2):");
			 answer =scan.nextInt();
			 scan.nextLine();
			if (answer==1) {
				System.out.print("이름을 입력하세요:");
				name =scan.nextLine();
				
				for(int i=0;i<clist.size();i++) {
					clothVO vo=clist.get(i);
					if (vo.getItem_name().contains(name)) {
						list.add(vo);
						
					}
					
				}
				
			}
			else if (answer==2) {
				System.out.print("브랜드명을 입력하세요:");
				name=scan.nextLine(); 
				for(int i=0;i<clist.size();i++) {
					clothVO vo=clist.get(i);
					if (vo.getBrand().contains(name)) {
						list.add(vo);
						
					}
					
				}
				
				
			}
			else {
				System.out.println("잘못입력");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		return list;
	}
	
}
