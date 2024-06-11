package ch01.ToDos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Practice {
	
	public static void main(String[] args) throws IOException {
		String urlString="https://jsonplaceholder.typicode.com/todos";
		
		URL url=new URL(urlString);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("GET");
		int responseCode=conn.getResponseCode();
		System.out.println("HTTP CODE:"+responseCode);
		
		BufferedReader brln=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String inputLine;
		StringBuffer responseBuffer=new StringBuffer();
		while((inputLine=brln.readLine())!=null) {
			responseBuffer.append(inputLine);
		}
		brln.close();
		System.out.println(responseBuffer);
		Gson gson1=new GsonBuilder().setPrettyPrinting().create();
		Todo todoObjec=gson1.fromJson(responseBuffer.toString(), Todo.class);
		System.out.println(todoObjec.getId());
	}

}
