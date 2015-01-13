package server;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import org.quickconnectfamily.json.*;
import org.quickconnectfamily.json.tests.TestObject;

public class Client implements Runnable {

	private Socket socket;
	

	public Client(Socket s) {
		socket = s;
	}

	@Override
	public void run() {
		try {
			JSONInputStream jsonIn = new JSONInputStream(socket.getInputStream());
			JSONOutputStream jsonOut = new JSONOutputStream(socket.getOutputStream());
			//System.out.println(jsonIn.readObject().toString());
			HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
			System.out.println(parsedJSONMap.toString());
			System.out.println(parsedJSONMap.get("username"));
			//TestObject readObject = new TestObject(parsedJSONMap);
			UserBean aResponse = new UserBean("Done", "Congrats!!!");
			jsonOut.writeObject(aResponse);
			
			
			
			
			
//			Scanner in = new Scanner(socket.getInputStream());
//
//			while (true) {
//				if (in.hasNext()) {
//					String input = in.nextLine();
//					System.out.println("Client Said: " + input);
//					HashMap parsedJSONMap = (HashMap)JSONUtilities.parse(input);
//					System.out.println("Client Said: " + parsedJSONMap.toString());
//					TestObject readObject = new TestObject(parsedJSONMap);
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}