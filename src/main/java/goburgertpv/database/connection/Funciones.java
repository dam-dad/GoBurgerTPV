package goburgertpv.database.connection;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import goburgertpv.database.tables.Bebidas;
import goburgertpv.database.tables.Complementos;
import goburgertpv.database.tables.Hamburguesas;
import goburgertpv.database.tables.Menus;
import goburgertpv.database.tables.Postres;
import goburgertpv.database.tables.Users;

public class Funciones {
	//TODO cambiar la incialización de session por la del modelo
	private static Session session= HibernateUtil.getSessionFactory().openSession();
	//TODO crear modelo con las listas de productos en local
	
	
	public static List<Bebidas> getBebidas() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Bebidas");

		List<Bebidas> bebidas = null;
		bebidas = query.getResultList();

		transaction.commit();

		return bebidas;
	}
	public static Session getSession() {
		return session;
	}
	public static void setSession(Session session) {
		Funciones.session = session;
	}
	public static List<Complementos> getComplementos() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Complementos");

		List<Complementos> complementos = null;
		complementos= query.getResultList();

		transaction.commit();

		return complementos;
	}
	public static List<Hamburguesas> getHamburguesas() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Hamburguesas");

		List<Hamburguesas> hamburguesas= null;
		hamburguesas= query.getResultList();

		transaction.commit();

		return hamburguesas;
	}
	public static List<Menus> getMenus() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Menus");

		List<Menus> menus= null;
		menus= query.getResultList();

		transaction.commit();

		return menus;
	}
	public static List<Postres> getPostres() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Postres");

		List<Postres> postres= null;
		postres= query.getResultList();

		transaction.commit();

		return postres;
	}
	public static List<Users> getUsers() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Users");

		List<Users> users= null;
		users= query.getResultList();

		transaction.commit();

		return users;
	}

}
