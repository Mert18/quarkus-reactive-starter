package dev.m2t;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class Fruit extends PanacheEntity {

   @Column(length = 40, unique = true)
   public String name;
}
