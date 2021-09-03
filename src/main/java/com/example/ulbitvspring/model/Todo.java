package com.example.ulbitvspring.model;

import com.example.ulbitvspring.entity.ToDoEntity;

public class Todo {
	private Long id;
	private String title;
	private Boolean completed;

	public static Todo toModel(ToDoEntity entity) {
		Todo model = new Todo();
		model.setCompleted(entity.getCompleted());
		model.setId(entity.getId());
		model.setTitle(entity.getTitle());
		return model;
	}

	public Todo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
