package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLPermission;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpAlbumClient {
	
	public static void main(String[] args) {
		// 순수 자바 코드에서 HTTP 통신
		// 1. 서버 주소 경로 (URL)
		// 2. URL 클래스
		// 3. url.openConnection() : 객체를 받아내서, 스트림 I/O
		
		try {
			URL url=new URL("https://jsonplaceholder.typicode.com/albums/1");
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode=conn.getResponseCode();
			System.out.println("Response code : "+responseCode);
			
			// HTTP 응답 메세지에 데이터를 추출 [] --- Stream --- []
			// inputStreamReader는 한 바이트가 아닌, 한 문자 씩 읽어주는 스트림이다.
			// 일반적은 I/O 기반 스트림은 속도가 느리기 때문에, 보조 스트림을 사용한다.
			// BufferedReader= 한 줄 씩 읽어내는 보조 스트림
			BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer=new StringBuffer();
			// 한 번 생성되면 수정 x => 이뮤터블 (String)
			// 한 번 생성된 뒤로도 수정 ok => 뮤터블 (StringBuffer+append)
			while((inputLine=in.readLine())!=null) {
				buffer.append(inputLine);
			}
			in.close();
			
			System.out.println(buffer.toString());
			
			System.out.println("-----------");
			// gson library 활용
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			// toJson(): 객체를 Json 문자열로 변환한다.
			// fromJson(): Json 문자열을 객체(object)로 변환한다.
			Album albumDTO=gson.fromJson(buffer.toString(), Album.class);
			// 첫번째는 파싱할 대상, 두번째는 '어떻게 파싱할지'를 정한다.
			// 즉, Album 클래스 형태로 Json 문자를 파싱한다는 뜻!
			
			System.out.println(albumDTO.getId());
			System.out.println(albumDTO.getUserId());
			System.out.println(albumDTO.getTitle());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main

} // end of class
