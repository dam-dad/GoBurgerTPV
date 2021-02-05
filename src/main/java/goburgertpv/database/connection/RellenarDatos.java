package goburgertpv.database.connection;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.decimal4j.util.DoubleRounder;
import org.hibernate.Session;
import org.hibernate.Transaction;


import goburgertpv.database.tables.Product;
import goburgertpv.database.tables.Productos;
import goburgertpv.database.tables.Users;

public class RellenarDatos {

	public static void rellenar() {
		
		ArrayList<Productos> bebidasList=new ArrayList<Productos>();
		ArrayList<Productos> hamburguesasList=new ArrayList<Productos>();
		ArrayList<Productos> complementosList=new ArrayList<Productos>();
		ArrayList<Productos> menusList=new ArrayList<Productos>();
		ArrayList<Productos> postresList=new ArrayList<Productos>();
		List<ArrayList<Productos>> listas=new ArrayList<ArrayList<Productos>>();
		listas.add(bebidasList);
		listas.add(hamburguesasList);
		listas.add(complementosList);
		listas.add(menusList);
		listas.add(postresList);

		for(int i=0;i<32;i++) {
			bebidasList.add(new Productos("bebida "+i, "descripción de prueba "+i, DoubleRounder.round(1+Math.random(), 2), Product.bebida));
			hamburguesasList.add(new Productos("hamburguesa "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*10,2), Product.hamburguesa ));
			complementosList.add(new Productos("complemento "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*10, 2), Product.complemento));
			menusList.add(new Productos("menu "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*1300/100, 2), Product.menu));
			postresList.add(new Productos("postres "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*8, 2), Product.postre));
		}
		
		
		Transaction transaction=Funciones.getSession().beginTransaction();
	
		for(int i=0;i<5;i++) {
			for(int j=0;j<32;j++)
				Funciones.getSession().save((listas.get(i)).get(j));
		}
		transaction.commit();
		Users user=new Users();
		user.setUsuario("admin");
		user.setPassword(DigestUtils.md2Hex("admin"));
		user.setAdministrador(true);
		transaction=Funciones.getSession().beginTransaction();
		Funciones.getSession().save(user);
		transaction.commit();
	}

}
