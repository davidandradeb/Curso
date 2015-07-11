package com.dyalogo.curso.ventas.tablas;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetalladoOrdenes.class)
public abstract class DetalladoOrdenes_ {

	public static volatile SingularAttribute<DetalladoOrdenes, Double> valorTotalItem;
	public static volatile SingularAttribute<DetalladoOrdenes, Integer> id;
	public static volatile SingularAttribute<DetalladoOrdenes, Integer> cantidad;
	public static volatile SingularAttribute<DetalladoOrdenes, Productos> idProducto;
	public static volatile SingularAttribute<DetalladoOrdenes, Ordenes> idOrden;

}

