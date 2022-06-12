/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.daoImpl;

import com.example.appWings.dao.ProveedorDao;
import com.example.appWings.model.Proveedor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor Rosales
 */
@Repository
public class ProveedorDaoImpl implements ProveedorDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Proveedor cli) {
        String SQL = "INSERT INTO proveedor(proveedor, telefono, direccion) VALUES(?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{cli.getProveedor(), cli.getTelefono(), cli.getDireccion()});
    }

    @Override
    public int update(Proveedor cli) {
       String SQL = "UPDATE proveedor SET proveedor=?, telefono=?, direccion=? WHERE idproveedor=?";
        return jdbcTemplate.update(SQL, new Object[]{cli.getProveedor(), cli.getTelefono(), cli.getDireccion(), cli.getIdproveedor()});

    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM proveedor WHERE idproveedor=?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Proveedor read(int id) {
        String SQL = "SELECT * FROM proveedor WHERE idproveedor=?";
        try {
            Proveedor au = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Proveedor.class), id);
            return au;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Proveedor> readAll() {
         String SQL ="SELECT idproveedor, proveedor, telefono, direccion  FROM proveedor ORDER BY idproveedor ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Proveedor.class)); 
    }
    
    
}
