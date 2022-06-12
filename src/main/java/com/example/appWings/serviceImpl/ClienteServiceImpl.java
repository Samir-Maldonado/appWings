/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.serviceImpl;

import com.example.appWings.dao.ClienteDao;
import com.example.appWings.model.Cliente;
import com.example.appWings.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteDao autorDao;
    @Override
    public int create(Cliente cli) {
      return autorDao.create(cli);
    }

    @Override
    public int update(Cliente cli) {
       return autorDao.update(cli);
    }

    @Override
    public int delete(int id) {
          return autorDao.delete(id); 
    }

    @Override
    public Cliente read(int id) {
         return autorDao.read(id);
    }

    @Override
    public List<Cliente> readAll() {
      return autorDao.readAll();
    }
    
}
