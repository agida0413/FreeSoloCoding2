package com.sist.무신사크롤링_기능구현.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.sist.무신사크롤링_기능구현.VO.*;
import com.sist.무신사크롤링_기능구현.manager.*;
public class showCloth {
	
	
	ArrayList<clothVO>list =new ArrayList<clothVO>();
public static void main(String[] args) throws IOException {
	Scanner scan=new Scanner(System.in);
	
	clothManager cm =new clothManager();
	ArrayList<clothVO>list =new ArrayList<clothVO>();
	int page=1;
	while(true) {
		
		list =cm.showOnePage(page);
		showList(list);
		
		
		
		
	
	
		System.out.println("현재 페이지"+"["+page+"]" + "/"+"총페이지"+"["+cm.totalPage()+"]");
	System.out.print("처음으로(0) /  이전페이지(1) / 다음페이지(2) /마지막으로(3) / 상세보기(4) /검색(5) 입력:\n-----------------------------------------------------------------");
	
	
	int answer = scan.nextInt();
	
	if (answer==0) {
		page=1;
		continue;
	}
	else if (answer==1) {
		if (page==1) {
			continue;
		}
		else {
			page--;
			continue;
		}
	}
	else if (answer==2) {
		page++;
		continue;
	}
	else if (answer==3) {
		page=cm.totalPage();
		continue;
	}
	
	else if (answer==5) {
		list =cm.findData();
		showList(list);
	}
}



	
}

static public void showList(ArrayList<clothVO>list) {
	
	for (clothVO vo : list) {
		System.out.println("랭킹:"+vo.getRanking());
		System.out.println("순위변동:"+vo.getState());
		System.out.println("성별:"+vo.getSex());
		System.out.println("브랜드:"+vo.getBrand());
		System.out.println("이름:"+vo.getItem_name());
		System.out.println("정가:"+vo.getReal_price());
		System.out.println("현재판매가:"+vo.getNow_price());
		System.out.println("----------------------------------------------");
		
		
		
		
	
	}
}

}




