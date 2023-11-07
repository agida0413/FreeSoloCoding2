package com.sist.무신사크롤링_기능구현.manager;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.무신사크롤링_기능구현.VO.clothDetailVO;
public class clothDetailManager {
	
	private static	ArrayList<clothDetailVO>dlist =new ArrayList<clothDetailVO>();

	
	static {
		for(int k=1;k<=10;k++) {
		try {
			Document doc =Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=true&exclusive=false&discount=false&soldOut=false&page="+k+"&viewType=small&priceMin=&priceMax=#pol3434621").get();
			
				Elements id =doc.select("li.li_box");
					
					
						
				for(int i=0;i<id.size();i++) {
					
					Document sublink =Jsoup.connect("https://www.musinsa.com/app/goods/"+id.get(i).attr("data-goods-no")+"?loc=goods_rank").get();
					Element click =sublink.selectFirst("id#li_pageview_1m P.product_article_contents");
					System.out.println(click.text());
						
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		}
	}
	public static void main(String[] args) {
		
	}
	
	
	
	
}
