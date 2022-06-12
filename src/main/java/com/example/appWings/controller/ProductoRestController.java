/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.controller;
import com.example.appWings.model.Producto;
import com.example.appWings.model.Productoo;
import com.example.appWings.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pr")
public class ProductoRestController {

    @Autowired
    private ProductoService auService;

    @GetMapping("/all")
    public List<Productoo> getPosts() {
        return auService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getPost(@PathVariable int id) {
        Producto au = auService.read(id);
        return ResponseEntity.ok(au);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {
        return auService.delete(id);
    }

    @PostMapping("/add")
    public int addPost(@RequestBody Producto au) {
        System.out.println(au.getDescripcion());
        return auService.create(au);
    }

    @PutMapping("/edit")
    public int editPost(@RequestBody Producto au) {
        Producto pos = new Producto(au.getIdproducto(), au.getDescripcion(), au.getPreciocosto(), au.getPrecioventa(), au.getCantidad(), au.getIdproveedor());
        System.out.println(au.getIdproducto() + " , " + au.getDescripcion() + " , " + au.getPreciocosto() + " , " + au.getPrecioventa()+ " , " +au.getCantidad()+ " , " +au.getIdproveedor());
        return auService.update(au);
    }

}
