package com.sw2.sistemaventa.CRUD.service;

import com.sw2.sistemaventa.CRUD.dto.productoDTO;
import com.sw2.sistemaventa.CRUD.entity.producto;
import com.sw2.sistemaventa.CRUD.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<producto> getAll(){
        return productoRepository.findAll();
    }

    public producto getOne (int id){
        return productoRepository.findById(id).get();
    }

    public producto save(productoDTO dto){
        int id = autoIncremento();
        producto product = new producto(id, dto.getNombre(), dto.getPrecio());
        return productoRepository.save(product);
    }

    public producto update(int id, productoDTO dto){
        producto product =productoRepository.findById(id).get();
        product.setNombre(dto.getNombre());
        product.setPrecio(dto.getPrecio());
        return productoRepository.save(product);
    }

    public producto delete (int id){
        producto product = productoRepository.findById(id).get();
        productoRepository.delete(product);
        return product;
    }

    //Metodos privados
    private int autoIncremento(){
        List<producto> productos = productoRepository.findAll();
        return productos.isEmpty() ? 1 :
                productos.stream().max(Comparator.comparing(producto::getId)).get().getId() +1;
    }

}
