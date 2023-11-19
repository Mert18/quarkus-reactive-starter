package dev.m2t;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/fruits")
@ApplicationScoped
public class FruitResource {

   @GET
   public Uni<List<Fruit>> get() {
      return Fruit.listAll(Sort.by("name"));
   }

   @GET
   @Path("/{id}")
   public Uni<Fruit> getSingle(Long id) {
      return Fruit.findById(id);
   }

   @POST
   public Uni<RestResponse<Fruit>> create(Fruit fruit) {
      return Panache.withTransaction(fruit::persist).replaceWith(RestResponse.status(Status.CREATED, fruit));
   }
}
