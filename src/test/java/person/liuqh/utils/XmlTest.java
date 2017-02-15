package person.liuqh.utils;

import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlTest {
	public static void main(String[] args) {
		Document doc = DocumentHelper.createDocument();
		Element root1 = doc.addElement("MasMessage", "http://www.99bill.com/mas_cnp_merchant_interface");
		Element ver = root1.addElement("version");
		ver.setText("1.0");
		Element root = root1.addElement("GetDynNumContent");
		root.addElement("merchantId").setText("abc");
		root.addElement("customerId").setText("abc");
		root.addElement("externalRefNumber").setText("abc");
		root.addElement("storablePan").setText("abc");
		root.addElement("phoneNO").setText("abc");
		root.addElement("amount").setText("abc");
		
		//OutputFormat format = OutputFormat.createPrettyPrint();// 层次格式化
		OutputFormat format = OutputFormat.createCompactFormat();
																	
		StringWriter writer = new StringWriter();
		XMLWriter output = new XMLWriter(writer, format);
		try {
			output.write(doc);
			writer.close();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sendXML=	 writer.toString();
		System.out.println(sendXML);
	}
}
