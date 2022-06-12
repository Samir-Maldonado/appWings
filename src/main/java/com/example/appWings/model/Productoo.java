/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Victor Rosales
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Productoo {
    private int idproducto;
    private String descripcion;
    private int preciocosto;
    private int precioventa;
    private int cantidad;
    private String proveedor;
}
