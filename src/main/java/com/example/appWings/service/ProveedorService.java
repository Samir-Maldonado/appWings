/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.appWings.service;

import com.example.appWings.model.Proveedor;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface ProveedorService {
    int create(Proveedor cli);
    int update(Proveedor cli);
    int delete(int id);
    Proveedor read(int id);
    List<Proveedor> readAll();
}
