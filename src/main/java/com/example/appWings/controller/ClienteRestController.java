/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.controller;

import com.example.appWings.model.Cliente;
import com.example.appWings.service.ClienteService;
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
@RequestMapping("/clie")
public class ClienteRestController {
    @Autowired
    private ClienteService auService;
    
    @GetMapping("/all")
    public List<Cliente> getPosts() {
        return auService.readAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getPost(@PathVariable int id) {
        Cliente au = auService.read(id);
        return ResponseEntity.ok(au);
    }
    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {        
        return auService.delete(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody Cliente au) {  
        System.out.println(au.getNombre());
        return auService.create(au);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Cliente au) {  
        Cliente pos = new Cliente(au.getIdcliente(),au.getNombre(),au.getDni(),au.getTelefono());
        System.out.println(au.getIdcliente()+" , "+au.getNombre()+" , "+au.getDni()+" , "+au.getTelefono());
        return auService.update(au);
    }
}
