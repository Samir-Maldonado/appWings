/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.controller;





import com.example.appWings.model.Proveedor;
import com.example.appWings.service.ProveedorService;
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
@RequestMapping("/prov")
public class ProveedorRestController {
    @Autowired
    private ProveedorService auService;
    
    @GetMapping("/all")
    public List<Proveedor> getPosts() {
        return auService.readAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getPost(@PathVariable int id) {
        Proveedor au = auService.read(id);
        return ResponseEntity.ok(au);
    }
    
    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {        
        return auService.delete(id);
    }
    
    @PostMapping("/add")
    public int addPost(@RequestBody Proveedor au) {  
        System.out.println(au.getProveedor());
        return auService.create(au);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Proveedor au) {  
        Proveedor pos = new Proveedor(au.getIdproveedor(),au.getProveedor(),au.getTelefono(),au.getDireccion());
        System.out.println(au.getIdproveedor()+" , "+au.getProveedor()+" , "+au.getTelefono()+" , "+au.getDireccion());
        return auService.update(au);
    }
    
}
