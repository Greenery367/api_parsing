package ch01.ToDos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		URL url=new URL("https://jsonplaceholder.typicode.com/todos/11");
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setDoInput(true);
		con.setUseCaches(false);
		con.connect();
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		
		
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
	}

}
