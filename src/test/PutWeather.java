package test;

import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class PutWeather {
	private String url = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";// �ṩ�ӿڵĵ�ַ
	private String soapaction = "http://WebXml.com.cn/"; // ������������server�����

	public PutWeather() {
		String City = "����";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(url);
			call.setOperationName(new QName(soapaction, "getWeatherbyCityName")); // ����Ҫ�����ĸ�����
			call.addParameter(
					new QName(soapaction, "theCityName"), // ����Ҫ���ݵĲ���
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(new QName(soapaction, "getWeatherbyCityName"),
					Vector.class); // Ҫ���ص��������ͣ��Զ������ͣ�

			// call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//����׼�����ͣ�

			call.setUseSOAPAction(true);
			call.setSOAPActionURI(soapaction + "getWeatherbyCityName");

			Vector v = (Vector) call.invoke(new Object[] { City });// ���÷��������ݲ���
			for (int i = 0; i < v.size(); i++) {
				System.out.println(v.get(i));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) {
		PutWeather pw = new PutWeather();
	}
}
