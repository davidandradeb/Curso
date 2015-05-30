package com.curso.jpa.tablas;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mascotas.class)
public abstract class Mascotas_ {

	public static volatile SingularAttribute<Mascotas, String> tipo;
	public static volatile SingularAttribute<Mascotas, String> color;
	public static volatile SingularAttribute<Mascotas, Usuarios> idUsuario;
	public static volatile SingularAttribute<Mascotas, Integer> id;
	public static volatile SingularAttribute<Mascotas, String> nombre;
	public static volatile SingularAttribute<Mascotas, Integer> edad;

}

