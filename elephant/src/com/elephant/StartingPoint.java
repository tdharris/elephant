package com.elephant;

import java.util.HashMap;

import com.example.thenewboston.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class StartingPoint extends Activity {
	
	private static HashMap<String, Object> handlers = new HashMap<String, Object>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// Create handlers
		LoginHandler loginHandler = new LoginHandler();
		
		// Put handlers in HashMap - handlers.put("login", value);
		handlers.put("login", loginHandler);
        Intent login = new Intent("com.example.thenewboston.LOGIN");
        startActivity(login);

//      final Client aClient = new Client();
//		final Thread clientThread = new Thread(aClient);
//		clientThread.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.starting_point, menu);
        return true;
    }
    
    public static MyHandler handleRequest(String handleMe) {
    	return (MyHandler) handlers.get(handleMe);
    }
	
}
