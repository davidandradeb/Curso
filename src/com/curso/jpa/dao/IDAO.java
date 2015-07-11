/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.jpa.dao;

import java.util.List;

/**
 *
 * @author davidandrade
 * @param <tabla>
 */
public interface IDAO<tabla extends ImpTabla> {
    
    
    tabla obtenerByID(Integer id);
    
    tabla crearInstancia();
    
    List<tabla> lista();
    List<tabla> lista(String condicion);
    
    tabla obtenerByCondicion(String condicion);
    /**
     * Elimina un registro de tipo tabla
     * @param registro 
     */
    void insertar(tabla registro) throws Exception;
    
    void actualizar(tabla registro);
    
    void eliminar(tabla registro);
    
}
