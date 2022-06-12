/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.daoImpl;

import com.example.appWings.dao.ProductoDao;
import com.example.appWings.model.Producto;
import com.example.appWings.model.Productoo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDaoImpl implements ProductoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Producto cli) {
        String SQL = "INSERT INTO producto(descripcion, preciocosto, precioventa, cantidad,idproveedor) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{cli.getDescripcion(), cli.getPreciocosto(), cli.getPrecioventa(), cli.getCantidad(),cli.getIdproveedor()});
    }

    @Override
    public int update(Producto cli) {
        String SQL = "UPDATE producto SET descripcion=?, preciocosto=?, precioventa=?, cantidad=?, idproveedor=? WHERE idproducto=?";
        return jdbcTemplate.update(SQL, new Object[]{cli.getDescripcion(), cli.getPreciocosto(), cli.getPrecioventa(),cli.getCantidad(), cli.getIdproveedor(), cli.getIdproducto()});

    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM producto WHERE idproducto=?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Producto read(int id) {
        String SQL = "SELECT * FROM producto WHERE idproducto=?";
        try {
            Producto au = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Producto.class), id);
            return au;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Productoo> readAll() {
        String SQL = "select p.idproducto, p.descripcion, p.preciocosto ,p.precioventa ,p.cantidad , c.proveedor  from producto as p inner join proveedor as c on p.idproveedor=c.idproveedor ORDER BY idproducto ASC";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Productoo.class));
    }
}
