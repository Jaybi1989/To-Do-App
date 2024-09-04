package ch_informatik_306.todolistapp.respository;

import ch_informatik_306.todolistapp.model.ToDo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ToDoRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void add(ToDo todo) {
        em.persist(todo);
    }

    @Transactional
    public void update(ToDo todo) {
        em.merge(todo);
    }

    @Transactional
    public void delete(Long id) {
        ToDo todo = em.find(ToDo.class, id);
        if (todo != null) {
            em.remove(todo);
        }
    }

    public ToDo find(Long id) {
        return em.find(ToDo.class, id);
    }

    public List<ToDo> list() {
        return em.createQuery("SELECT t FROM ToDo t", ToDo.class).getResultList();
    }
}
