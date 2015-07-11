/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.jpa.dao;

import com.curso.jpa.conexion.Conexion;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author DYALOGOSAS.davidandrade
 * @param <tabla>
 */
public abstract class ImpDAO<tabla extends ImpTabla> implements IDAO<tabla> {

    private Class<tabla> objRepresentacionTabla_t;

    public ImpDAO(Class<tabla> objRepresentacionTabla_t) {
        this.objRepresentacionTabla_t = objRepresentacionTabla_t;
    }

    @Override
    public tabla obtenerByID(Integer id) {
        EntityManager em = Conexion.getConexionBD().createEntityManager();

        try {
            return em.find(objRepresentacionTabla_t, id);
        } finally {
            em.close();
            em = null;
        }

    }

    @Override
    public tabla obtenerByCondicion(String strCondicion_t) {
        EntityManager em = Conexion.getConexionBD().createEntityManager();

        try {
            return (tabla) em.createQuery("SELECT t FROM  " + nombreTabla() + " t WHERE " + strCondicion_t).getSingleResult();
        } finally {
            em.close();
            em = null;
        }

    }

    @Override
    public tabla crearInstancia() {

        try {
            return objRepresentacionTabla_t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<tabla> lista() {
        EntityManager em = Conexion.getConexionBD().createEntityManager();
        try {
            return em.createNamedQuery(nombreTabla() + ".findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //(em.close();
            //em = null;

        }
    }

    private String nombreTabla() {
        return objRepresentacionTabla_t.getName().substring(objRepresentacionTabla_t.getName().lastIndexOf(".") + 1, objRepresentacionTabla_t.getName().length());
    }

    @Override
    public List<tabla> lista(String condicion) {
        EntityManager em = Conexion.getConexionBD().createEntityManager();

        try {
            return em.createNamedQuery("SELECT t FROM " + objRepresentacionTabla_t.getName() + " t WHERE " + condicion).getResultList();
        } finally {
            //em.close();
            //em = null;
        }
    }

    @Override
    public void insertar(tabla registro) throws Exception {
        EntityManager em = Conexion.getConexionBD().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(registro);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception(e);
        } finally {
            em.close();
            em = null;
        }
    }

    @Override
    public void actualizar(tabla registro) {
        EntityManager em = Conexion.getConexionBD().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(registro);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            em = null;
        }
    }

    @Override
    public void eliminar(tabla registro) {
        EntityManager em = Conexion.getConexionBD().createEntityManager();

        try {

            em.getTransaction().begin();
            em.remove(em.getReference(objRepresentacionTabla_t, registro.getId()));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            em = null;
        }
    }

}
