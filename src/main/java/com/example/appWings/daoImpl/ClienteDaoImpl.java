/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.daoImpl;

import com.example.appWings.dao.ClienteDao;
import com.example.appWings.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Cliente cli) {
        String SQL = "INSERT INTO cliente(nombre, dni, telefono) VALUES(?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{cli.getNombre(), cli.getDni(), cli.getTelefono()});
    }

    @Override
    public int update(Cliente cli) {
        String SQL = "UPDATE cliente SET nombre=?, dni=?, telefono=? WHERE idcliente=?";
        return jdbcTemplate.update(SQL, new Object[]{cli.getNombre(), cli.getDni(), cli.getTelefono(), cli.getIdcliente()});
    }

    @Override
    public int delete(int id) {
        
        String SQL = "DELETE FROM cliente WHERE idcliente=?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Cliente read(int id) {
         String SQL = "SELECT * FROM cliente WHERE idcliente=?";
        try {
            Cliente au = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Cliente.class), id);
            return au;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Cliente> readAll() {
       String SQL ="SELECT idcliente, nombre, dni, telefono  FROM cliente ORDER BY idcliente ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cliente.class)); 
    }

}
