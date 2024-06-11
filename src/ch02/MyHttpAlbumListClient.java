package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * JSON Array 형태를 파싱 해보자. 
 */
public class MyHttpAlbumListClient {

	public static void main(String[] args) {
		
		// 순수 자바코드에서 HTTP 통신 
		// 1. 서버 주소 경로
		// 2. URL 클래스 
		// 3. url.openConnection()  <--- 스트림 I/O
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);
			
			// HTTP 응답 메세지에 데이터를 추출 [] -- Stream ---  []
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while( (inputLine = in.readLine()) != null ) {
				buffer.append(inputLine);
			}
			in.close();
			
			System.out.println(buffer.toString());
			System.err.println("-------------------------------");
			// gson lib 활용 
			//Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// 하나의 JSON Object 형태 파싱 
			// Album albumDTO =  gson.fromJson(buffer.toString(), Album.class);
			
			// [{...},{...},{...}]
			// Gson 제공하는 Type 이라는 데이터 타입을 활용할 수 있다.
			
			//Json 배열 형태를 쉽게 파싱하는 방법 -> TypeToken 안에 List<T> 을 활용 한다. 
			Type albumType = new TypeToken<List<Album>>(){}.getType();
			List<Album>  albumList = gson.fromJson(buffer.toString(), albumType);
			
			System.out.println(albumList.size());
			for(Album a : albumList ) {
				System.out.println(a.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main 
}
