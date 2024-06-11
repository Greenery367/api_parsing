package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MyHttpUsersClient3 {
	
	public static void main(String[] args) {
		
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			int responseCode=conn.getResponseCode();
			System.out.println("response code : "+responseCode);
			
			BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer=new StringBuffer();
			while((inputLine=in.readLine())!=null){
				buffer.append(inputLine);
			}
			in.close();
			
			System.out.println(buffer.toString());
			System.out.println("-----------------------------");
			
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			
			Type userType=new TypeToken<List<User>>() {}.getType();
			List<User> userList=gson.fromJson(buffer.toString(),userType);
			
			System.out.println(userList.size());
			for(User u:userList) {
				System.out.println(u.toString());
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
