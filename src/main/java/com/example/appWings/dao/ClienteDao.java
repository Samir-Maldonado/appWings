/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.appWings.dao;

import com.example.appWings.model.Cliente;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface ClienteDao {
    int create(Cliente cli);
    int update(Cliente cli);
    int delete(int id);
    Cliente read(int id);
    List<Cliente> readAll();
}
