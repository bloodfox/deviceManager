package test;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start invoking....");
		try {
			String endPoint = "http://localhost/WebSite/Service/CheckPasswordService.asmx";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endPoint));
			call.setOperation("CheckUser");
			call.setUseSOAPAction(true);
			call.setSOAPActionURI("");
			call.setOperationName(new QName("www.webxml.com.cn",
					"getVersionTime"));
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
			String str = (String) call.invoke(new Object[] {});
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
