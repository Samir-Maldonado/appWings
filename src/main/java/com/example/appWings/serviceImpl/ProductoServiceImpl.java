/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.serviceImpl;

import com.example.appWings.dao.ProductoDao;
import com.example.appWings.model.Producto;
import com.example.appWings.model.Productoo;
import com.example.appWings.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao autorDao;

    @Override
    public int create(Producto cli) {
        return autorDao.create(cli);
    }

    @Override
    public int update(Producto cli) {
        return autorDao.update(cli);
    }

    @Override
    public int delete(int id) {
        return autorDao.delete(id);
    }

    @Override
    public Producto read(int id) {
        return autorDao.read(id);
    }

    @Override
    public List<Productoo> readAll() {
        return autorDao.readAll();
    }

}
