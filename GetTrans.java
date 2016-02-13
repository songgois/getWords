package com.winzxin.androiddoc;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GetTrans {

	public static void main(String[] args) {
		youdaoTrans("android");
	}
	
	public static void youdaoTrans(String word){
		String url = 
			"http://dict.youdao.com/search?q="
				+ word;
		try {
			Document document =
					Jsoup.connect
					(url).userAgent("")
					.timeout(3000).get();
			Element element =
					document.select(".trans-container")
					.first();
			System.out.println(element.text());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
