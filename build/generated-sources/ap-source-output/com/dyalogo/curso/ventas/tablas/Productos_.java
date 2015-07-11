package com.dyalogo.curso.ventas.tablas;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Productos.class)
public abstract class Productos_ {

	public static volatile SingularAttribute<Productos, String> descripcion;
	public static volatile ListAttribute<Productos, DetalladoOrdenes> detalladoOrdenesList;
	public static volatile SingularAttribute<Productos, Double> valor;
	public static volatile SingularAttribute<Productos, Integer> id;
	public static volatile SingularAttribute<Productos, String> nombre;

}

