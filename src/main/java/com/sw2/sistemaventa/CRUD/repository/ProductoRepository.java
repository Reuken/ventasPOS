package com.sw2.sistemaventa.CRUD.repository;

import com.sw2.sistemaventa.CRUD.entity.producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository <producto, Integer> {


}
