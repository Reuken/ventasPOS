package com.sw2.sistemaventa.CRUD.controller;

import com.sw2.sistemaventa.CRUD.dto.productoDTO;
import com.sw2.sistemaventa.CRUD.entity.producto;
import com.sw2.sistemaventa.CRUD.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")

public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<producto>> getAll() {
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<producto> getOne (@PathVariable("id") int id) {
        return ResponseEntity.ok(productoService.getOne(id));
    }


    @PostMapping
    public ResponseEntity<producto> save(@RequestBody productoDTO dto) {
        return ResponseEntity.ok(productoService.save(dto));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<producto> update (@PathVariable("id") int id, @RequestBody productoDTO dto) {
        return ResponseEntity.ok(productoService.update(id, dto));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<producto> delete (@PathVariable("id") int id) {
        return ResponseEntity.ok(productoService.delete(id));
    }

}
