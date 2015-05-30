/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.jpa.dao;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public abstract class ImpTabla implements ITablas{
    
    Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
