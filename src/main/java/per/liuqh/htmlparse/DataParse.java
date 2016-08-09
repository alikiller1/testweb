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
		String url = "http://invest.ppdai.com/loan/list_safe_s1_p1?Rate=0&monthgroup=&didibid=&listingispay=1000";
		Document doc = Jsoup.connect(url).get();
		Elements root = doc.getElementsByAttributeValue("class", "clearfix");
		Iterator<Element> es = root.iterator();
		int count=0;
		List<LoanInfo> list=new ArrayList<LoanInfo>();
		while (es.hasNext()) {
			Element ele = es.next();
			String tagName = ele.tagName();
			if ("ol".equalsIgnoreCase(tagName)) {
				LoanInfo loanInfo=new LoanInfo();
				Elements e1 = ele.select(".ell");
				for (Element element : e1) {
					String purpose=element.attr("title");
					loanInfo.setPurpose(purpose);
					String loanUrl=element.attr("href");
					loanInfo.setUrl(loanUrl);
					break;
				}
				String userName = ele.select(".userInfo").get(0).getElementsByTag("a").get(0).text();
				loanInfo.setUserName(userName);
				
				String rete=ele.select(".brate").get(0).text().trim().replace("%", "");
				loanInfo.setRate(new BigDecimal(rete));
				
				String amont=ele.select(".sum").get(0).text();
				amont=amont.substring(1,amont.length());
				loanInfo.setAmount(new BigDecimal(amont.replaceAll(",", "")));
				
				String percent=ele.select(".process").get(0).getElementsByTag("p").get(0).text();
				percent=percent.replaceAll("\\s", ",");
				percent=percent.replaceAll("[^\\d,]", "");
				String[] ss=percent.trim().split(",");
				loanInfo.setBidNumber(new Integer(ss[0]));
				loanInfo.setPercent(new BigDecimal(ss[1]));
				
				String month=ele.select(".limitTime").get(0).text();
				month=month.trim().replaceAll("[^\\d,]", "");
				loanInfo.setMonth(new Integer(month));
				count++;
				list.add(loanInfo);
			}
		}
		for(LoanInfo loanInfo:list){
			System.out.println(loanInfo);
		}
		System.out.println("count="+count);
	}
}
