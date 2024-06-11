package ch01.ToDos;

import javax.swing.border.TitledBorder;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Todo {
	
	private int userId;
	private int id;
	private String title;
	private Boolean completed;

}
