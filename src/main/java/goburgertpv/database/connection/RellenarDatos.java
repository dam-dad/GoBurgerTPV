package goburgertpv.database.connection;

import java.util.ArrayList;
import java.util.List;

import org.decimal4j.util.DoubleRounder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import goburgertpv.database.tables.Bebidas;
import goburgertpv.database.tables.Complementos;
import goburgertpv.database.tables.Hamburguesas;
import goburgertpv.database.tables.Menus;
import goburgertpv.database.tables.Postres;

public class RellenarDatos {

	public static void rellenar(Session session) {
		
		List<Bebidas> bebidasList=new ArrayList<Bebidas>();
		List<Hamburguesas> hamburguesasList=new ArrayList<Hamburguesas>();
		List<Complementos> complementosList=new ArrayList<Complementos>();
		List<Menus> menusList=new ArrayList<Menus>();
		List<Postres> postresList=new ArrayList<Postres>();
		List<Object> listas=new ArrayList<Object>();
		listas.add(bebidasList);
		listas.add(hamburguesasList);
		listas.add(complementosList);
		listas.add(menusList);
		listas.add(postresList);

		for(int i=0;i<6;i++) {
			bebidasList.add(new Bebidas("bebida "+i, "descripción de prueba "+i, DoubleRounder.round(i+Math.random(), 2)));
			hamburguesasList.add(new Hamburguesas("hamburguesa "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*10,2) ));
			complementosList.add(new Complementos("complemento "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*10, 2)));
			menusList.add(new Menus("menu "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*1300/100, 2)));
			postresList.add(new Postres("postres "+i, "descripción de prueba "+i, DoubleRounder.round(Math.random()*8, 2)));
		}
		
		Transaction transaction=session.beginTransaction();
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<6;j++)
				session.save(((ArrayList)listas.get(i)).get(j));
		}
		transaction.commit();
	}

}
