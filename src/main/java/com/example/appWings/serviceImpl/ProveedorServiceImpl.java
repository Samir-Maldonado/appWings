/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.serviceImpl;


import com.example.appWings.dao.ProveedorDao;
import com.example.appWings.model.Proveedor;
import com.example.appWings.service.ProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorDao autorDao;

    @Override
    public int create(Proveedor cli) {
        return autorDao.create(cli);
    }

    @Override
    public int update(Proveedor cli) {
        return autorDao.update(cli);
    }

    @Override
    public int delete(int id) {
    return autorDao.delete(id); 
    }

    @Override
    public Proveedor read(int id) {
        return autorDao.read(id);
    }

    @Override
    public List<Proveedor> readAll() {
       return autorDao.readAll();
    }

}
