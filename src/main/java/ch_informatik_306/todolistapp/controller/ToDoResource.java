package ch_informatik_306.todolistapp.controller;

import ch_informatik_306.todolistapp.model.ToDo;
import ch_informatik_306.todolistapp.service.ToDoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ToDoResource {

    @Inject
    private ToDoService service;

    @GET
    public List<ToDo> list() {
        return service.list();
    }

    @GET
    @Path("/{id}")
    public ToDo find(@PathParam("id") Long id) {
        return service.find(id);
    }

    @POST
    public Response add(ToDo todo) {
        service.add(todo);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ToDo todo) {
        todo.setId(id);
        service.update(todo);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}

