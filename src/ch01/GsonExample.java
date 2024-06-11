package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {
	
	public static void main(String[] args) {
		
		Student student1 = new Student("고길동",40,"애완학과");
		Student student2 = new Student("둘리",5,"문제학과");
		Student[] studentArr= {student1,student2};
		
		// 특정 형식(구조화) 있는 문자열로 변환하고 싶다...
		// -> JSON 형태
		
		// Gson gson=new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// 객체를 json 형식의 문자열로 변환 시켜!
		// --> 메서드 toJson()
		String student1String=gson.toJson(student1);
		System.out.println(student1String);
		
		// setPrettyPrinting
		Gson gson2=new Gson();
		String student2String=gson.toJson(student2);
		System.out.println(student2String);
		
		// 객체 -> 문자열 형태로 가능. 그러면 반대로는 어떻게 하지?
		// 문자열-> 클래스 형태로 어떻게 변경할까?
		
		Student studentObjectStudent=gson.fromJson(student1String, Student.class);
		System.out.println(studentObjectStudent.getName());
	}

}
