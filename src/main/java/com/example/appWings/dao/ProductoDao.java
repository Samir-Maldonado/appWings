/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.appWings.dao;

import com.example.appWings.model.Producto;
import com.example.appWings.model.Productoo;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface ProductoDao {
    int create(Producto cli);
    int update(Producto  cli);
    int delete(int id);
    Producto read(int id);
    List<Productoo > readAll();
}
