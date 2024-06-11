package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * {
  "userId": 1,
  "id": 1,
  "title": "quidem molestiae enim"
    }
 */
// DTO 클래스 -- Data Transfer Object
// key 값은 대소문자 일치해야 한다.
// private --> Gson lib --> 변수에 접근해서, json 값을 넣어준다.
// Setter가 필요하다.

@Setter
@Getter
@NoArgsConstructor // 기본 생성자(롬북)
@AllArgsConstructor 
@ToString 

public class Album {
	private int userId;
	private int id;
	private String title;
}
