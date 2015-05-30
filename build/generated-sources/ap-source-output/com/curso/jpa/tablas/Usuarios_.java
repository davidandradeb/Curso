package com.curso.jpa.tablas;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuarios.class)
public abstract class Usuarios_ {

	public static volatile SingularAttribute<Usuarios, String> contrasena;
	public static volatile ListAttribute<Usuarios, Mascotas> mascotasList;
	public static volatile SingularAttribute<Usuarios, Integer> id;
	public static volatile SingularAttribute<Usuarios, String> email;

}

