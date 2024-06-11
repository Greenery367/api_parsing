package ch01;

import com.google.gson.Gson;

public class MainTest1 {
	
	public static void main(String[] args) {
		
		// Gson <- 현재 사용 불가
		// lib 폴더에 Gson 라이브러리 추가
		// 우리 소스 코드 상에서 사용하기 위해 설정이 필요하다.
		
		// 프로젝트 속성에서 빌드패스 들어가서 클래스 패스에 add jars 등록
		Gson gson = new Gson();
		gson.fieldNamingStrategy();
		
		Student student1=new Student();
		Student student2=new Student("홍",20,"컴공");
	} // end of main

 } // end of class
