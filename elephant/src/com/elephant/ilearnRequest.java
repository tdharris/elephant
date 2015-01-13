package com.elephant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Handler;
import android.os.Message;

public class ilearnRequest{
	private final Handler guiMsg;
	
	public ilearnRequest(Handler guiMsg) {
		this.guiMsg = guiMsg;
	}
	public String getInternetData() throws Exception{

        //new TrustAllManager();
        //new TrustAllSSLSocketFactory();

        BufferedReader in = null;
        String data = null;

        try
        {
            HttpClient client = new DefaultHttpClient();
            // iLearn - http://byui.brainhoney.com/TzH93h60ZMQAVREJA3o.rA!!/BrainHoney.ics
            URI website = new URI("http://www.google.com");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            response.getStatusLine().getStatusCode();

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");
            while ((l = in.readLine()) !=null){
                sb.append(l + nl);
            }
            in.close();
            data = sb.toString();
            return data;        
        } finally{
            if (in != null){
                try{
                    in.close();
                    return data;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
			
		}
}
