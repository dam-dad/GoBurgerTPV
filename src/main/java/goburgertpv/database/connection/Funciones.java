package goburgertpv.database.connection;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import goburgertpv.database.tables.Bebidas;
import goburgertpv.database.tables.Complementos;
import goburgertpv.database.tables.Hamburguesas;
import goburgertpv.database.tables.Menus;
import goburgertpv.database.tables.Users;

public class Funciones {
	//TODO cambiar la incialización de session por la del modelo
	private static Session session= HibernateUtil.getSessionFactory().openSession();
	
	
	public static List<Bebidas> getBebidas() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Bebidas");

		List<Bebidas> bebidas = null;
		bebidas = query.getResultList();

		transaction.commit();
		session.close();

		return bebidas;
	}
	public static List<Complementos> getComplementos() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Complementos");

		List<Complementos> complementos = null;
		complementos= query.getResultList();

		transaction.commit();
		session.close();

		return complementos;
	}
	public static List<Hamburguesas> getHamburguesas() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Hamburguesas");

		List<Hamburguesas> hamburguesas= null;
		hamburguesas= query.getResultList();

		transaction.commit();
		session.close();

		return hamburguesas;
	}
	public static List<Menus> getMenus() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Menus");

		List<Menus> menus= null;
		menus= query.getResultList();

		transaction.commit();
		session.close();

		return menus;
	}
	public static List<Users> getUsers() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Users");

		List<Users> users= null;
		users= query.getResultList();

		transaction.commit();
		session.close();

		return users;
	}

}
