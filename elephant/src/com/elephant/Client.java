package com.elephant;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Handler;

public class Client implements Runnable {
	@Override
	public void run() {
		HashMap<String, Object> handlers = new HashMap<String, Object>();
		//handlers.put("login", value);
	}
	
   public void handleRequest(HashMap<String, String> credentials, Handler responseHandler) {
	   try
	      {	 HashMap<String, Object> toServer = new HashMap();
	    	  LoginHandler logMeIn = new LoginHandler();
	    	  logMeIn.handleIt(toServer);
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      } 
   }
}