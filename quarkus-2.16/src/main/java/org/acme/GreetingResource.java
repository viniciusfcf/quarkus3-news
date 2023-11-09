package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyEntity> hello() {
        return em.createQuery("from MyEntity", MyEntity.class).getResultList();
    }

    @POST
    @Transactional
    public void save() {
        MyEntity entity1 = new MyEntity();
        entity1.field = "field-1";
        em.persist(entity1);
    }

}