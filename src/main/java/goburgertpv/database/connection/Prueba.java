package goburgertpv.database.connection;

import org.hibernate.Session;

public class Prueba {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	}
}
