package goburgertpv.database.connection;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import goburgertpv.database.tables.Productos;
import goburgertpv.database.tables.Users;
/**
 * 
 * @author Michael,Ignacio,Tamara
 *
 */
public class Funciones {
	//TODO cambiar la incialización de session por la del modelo
	private static Session session= HibernateUtil.getSessionFactory().openSession();
	//TODO crear modelo con las listas de productos en local

	@SuppressWarnings("unchecked")
	public static List<Productos> getProductos() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Productos");

		List<Productos> bebidas = null;
		bebidas = query.getResultList();

		transaction.commit();

		return bebidas;
	}

	@SuppressWarnings("unchecked")
	public static List<Users> getUsers() {

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Users");

		List<Users> users= null;
		users= query.getResultList();

		transaction.commit();

		return users;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		Funciones.session = session;
	}

}