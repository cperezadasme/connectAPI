package connectAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test{
	public static void main(String[] args) throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		
		//HttpHost host = new HttpHost("localhost:3000", 80, "http");
		
		String host = "http://localhost:3000"; //server API
		String req = "/tshirt/598a5a335efc875e36000003"; //link del GET
		HttpGet request = new HttpGet(host+req);
		//HttpGet request = new HttpGet("/598a5a335efc875e36000003");
		HttpResponse response = client.execute(request);
	    //HttpResponse httpResponse = client.execute(host, request);
	    /*
	    HttpEntity entity = httpResponse.getEntity();
	    System.out.println("----------------------------------------");
	      System.out.println(httpResponse.getStatusLine());
	      Header[] headers = httpResponse.getAllHeaders();
	      for (int i = 0; i < headers.length; i++) {
	        System.out.println(headers[i]);
	      }
	      System.out.println("----------------------------------------");

	      if (entity != null) {
	        System.out.println(EntityUtils.toString(entity));
	      }
*/
		//imprimir
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null){
			System.out.println(line);
		}
	}
}

