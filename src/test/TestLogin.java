package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String message = "ÄÚÈÝ";
			URL url = new URL(
					"http://10.10.50.61/WebSite/Service/CheckPasswordService.asmx/CheckUser?name=wangle&passd=wangle");
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);

			String str = "";
			while ((br.readLine()) != null) {
				str = str.trim() + br.readLine();
			}
			// System.out.println(str);
			str = new String(str.getBytes("gbk"), "utf-8");
			System.out.println(str);
			String sss = "<string xmlns=\"http://tempuri.org/\">µÇÂ½³É¹¦</string>";
			// message = str.substring(start, end) + "¡£";
			// System.out.println(message);
			br.close();
			isr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
