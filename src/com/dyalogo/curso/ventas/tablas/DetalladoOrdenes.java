/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dyalogo.curso.ventas.tablas;

import com.curso.jpa.dao.ImpTabla;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
@Entity
@Table(name = "detallado_ordenes", catalog = "curso_ventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalladoOrdenes.findAll", query = "SELECT d FROM DetalladoOrdenes d"),
    @NamedQuery(name = "DetalladoOrdenes.findById", query = "SELECT d FROM DetalladoOrdenes d WHERE d.id = :id"),
    @NamedQuery(name = "DetalladoOrdenes.findByCantidad", query = "SELECT d FROM DetalladoOrdenes d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalladoOrdenes.findByValorTotalItem", query = "SELECT d FROM DetalladoOrdenes d WHERE d.valorTotalItem = :valorTotalItem")})
public class DetalladoOrdenes extends ImpTabla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total_item", precision = 22)
    private Double valorTotalItem;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Productos idProducto;
    @JoinColumn(name = "id_orden", referencedColumnName = "id")
    @ManyToOne
    private Ordenes idOrden;

    public DetalladoOrdenes() {
    }

    public DetalladoOrdenes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(Double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Ordenes getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Ordenes idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalladoOrdenes)) {
            return false;
        }
        DetalladoOrdenes other = (DetalladoOrdenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dyalogo.curso.ventas.tablas.DetalladoOrdenes[ id=" + id + " ]";
    }

}
