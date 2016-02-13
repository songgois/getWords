package com.winzxin.androiddoc;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StartGetWord {
	private static Set<String> words = new HashSet<>();
	public static void main(String[] args) {
		if (args[0] != null) {
			getFiles(new File(args[0]).listFiles());
			for (String string : words) {
				System.out.println(string);
			}				
		}else{
			System.out.println("«Î ‰»ÎandroidŒƒµµ¬∑æ∂");
		}
	}
	
	private static String getHtmlText(File file){
		try {
			Document document  = Jsoup.parse(file,"UTF-8","");
			return document.text();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static void getWords(String text){
		Pattern pattern = Pattern.compile("[a-zA-Z]+");	
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()){
			 words.add(matcher.group());
		}
	}

	private static void getFiles(File[] files){
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file.listFiles());
			} else{
				if (file.getName().endsWith(".html")){					
					getWords(getHtmlText(file));
				}
			}
		}
	}
}
