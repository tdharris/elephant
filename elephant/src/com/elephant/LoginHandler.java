package com.elephant;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import android.os.Handler;

public class LoginHandler extends MyHandler {
	private HashMap<String, Object> toServer;
	
	@Override
	void handleIt(HashMap<String, Object> toServer) {
		try {
			
			// Get tasks
			ArrayList tasks = new ArrayList();
			toServer.put("tasks", tasks);
			Handler guiMsg = (Handler) toServer.get("responseHandler");
			toServer.remove("responseHandler");
			Socket clientSocket = new Socket("10.0.2.2", 6677);
			Login.setConnect("Connected to Server");
			
			JSONOutputStream jsonOut = new JSONOutputStream(clientSocket.getOutputStream());
	        jsonOut.writeObject(toServer);
	        JSONInputStream jsonIn = new JSONInputStream(clientSocket.getInputStream());
			String serverResponse = jsonIn.readObject().toString();
			
//			Update UI with passed Handlers
			//	Message msg = Message.obtain();
			//	msg.obj = serverResponse;
			//	msg.what = 1;
			//	guiMsg.sendMessage(msg);
			
//			Update UI with setter
			Login.setTest(serverResponse);
	        
	        ilearnRequest gethttp = new ilearnRequest(guiMsg);
	        Login.setTest(gethttp.getInternetData());
	        
//	        msg.obj = response.getInternetData();
//	        msg.what = 1;
//	        guiMsg.sendMessage(msg);
		}
		catch (Exception e)
	      {
	         e.printStackTrace();
	      } 
		
	}
}
