package com.prosoft.todolist;
public class TodoItem {
    private int id;
    private String task;
    private String time;
    private String date;
    private String todo;

    public TodoItem(String task, String time, int id, String date) {
        this.id=id;
        this.date=date;
        this.task = task;
        this.time = time;
    }

    // Getters and Setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
    public String getDate() {return date;}

    public void setDate(String date) {
        this.date = date;
    }
    public int getId() {return id;}
    public void setId(int Id) {this.id=id;}

    public void setUserId(long userId) {
    }
}