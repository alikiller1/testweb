package per.liuqh.htmlparse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataParse {
	public static void main(String[] args) throws IOException {
		String url = "https://www.baidu.com";
		Document doc = Jsoup.connect(url).userAgent("User-Agent:Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0").get();
		System.out.println(doc);
	}
}
