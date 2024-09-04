package ch_informatik_306.todolistapp.service;
import ch_informatik_306.todolistapp.model.ToDo;
import ch_informatik_306.todolistapp.respository.ToDoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ToDoService {

    @Inject
    private ToDoRepository repository;

    public void add(ToDo todo) {
        repository.add(todo);
    }

    public void update(ToDo todo) {
        repository.update(todo);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public ToDo find(Long id) {
        return repository.find(id);
    }

    public List<ToDo> list() {
        return repository.list();
    }
}


