package ch_informatik_306.todolistapp.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ToDoBean {

    private List<ToDo> todoList = new ArrayList<>();
    private String newTitle;


    public List<ToDo> getTodoList() {
        return todoList;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public void add() {
        if (newTitle != null && !newTitle.trim().isEmpty()) {
            todoList.add(new ToDo(newTitle));
            newTitle = null; // clear the input field after adding
        }
    }

    public void delete(ToDo todo) {
        todoList.remove(todo);
    }
}

class ToDo {
    private String title;

    public ToDo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
