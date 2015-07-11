package com.dyalogo.curso.ventas.tablas;

import com.curso.jpa.tablas.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ordenes.class)
public abstract class Ordenes_ {

	public static volatile SingularAttribute<Ordenes, Date> fecha;
	public static volatile ListAttribute<Ordenes, DetalladoOrdenes> detalladoOrdenesList;
	public static volatile SingularAttribute<Ordenes, Clientes> idCliente;
	public static volatile SingularAttribute<Ordenes, Double> totalVenta;
	public static volatile SingularAttribute<Ordenes, Usuarios> idUsuario;
	public static volatile SingularAttribute<Ordenes, Integer> id;

}

