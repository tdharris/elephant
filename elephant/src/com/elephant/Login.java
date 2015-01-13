package com.elephant;

import java.util.HashMap;

import com.example.thenewboston.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class Login extends Activity {
	private static TextView connect;
	private static TextView test;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_point);
        
        final Button send = (Button) findViewById(R.id.sendButton);
        final EditText uname = (EditText) findViewById(R.id.username);
        final EditText passwd = (EditText) findViewById(R.id.password);
        connect = (TextView) findViewById(R.id.connect);
        test = (TextView) findViewById(R.id.test);
        
        send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try
				{	
					HashMap<String, String> credentials = new HashMap<String, String>();
					credentials.put(uname.getText().toString(), passwd.getText().toString());

					HashMap<String, Object> toBring = new HashMap<String, Object>();
					toBring.put("credentials", credentials);
					toBring.put("responseHandler", responseHandler);
					StartingPoint.handleRequest("login").handleIt(toBring);
					
//					Make handler runnable?
//					MyHandler returnedHandler = StartingPoint.handleRequest("login");
//					returnedHandler.bring(toBring);
//					final Thread handlerThread = new Thread(returnedHandler);
//					handlerThread.start();

				}
				catch (Exception noServer)
				{ 	noServer.printStackTrace();
					connect.setText("The Server is not available.");
				}
			}
		});
	}
	
	public static void setConnect(String r){
		connect.setText(r);
	}
	
	public static void setTest(String r){
		test.setText(test.getText().toString() + r + "\n");
	}
	
	final Handler responseHandler = new Handler(){
    	@Override
    	public void handleMessage(Message msg) {
    		test.setText(msg.obj.toString());
    	}
    };
	
}
