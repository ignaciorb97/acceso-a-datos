package modelo;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		
		try {
			Profesores profesor = new Profesores("Ignacio","Rodriguez","Calle Frankfurt","696969","Málaga","Málaga","6969696969");
			// Obtener la sesión actual
			Session session = context.currentSession();
			session.beginTransaction();
			session.save(profesor);
			session.getTransaction().commit();

			
			session.beginTransaction();
			String hql = "FROM Profesores";
			Query<Profesores> query = session.createQuery(hql, Profesores.class);
			
			List<Profesores> profesores = query.list();

			System.out.println("Registros en la tabla fabricante:");
			for (Profesores p : profesores) {
				System.out.println(p.toString());
			}
			session.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			// Desligar la sesión del contexto
			ThreadLocalSessionContext.unbind(sessionFactory);
			// Cerrar la sesión de Hibernate
			sessionFactory.close();
			}
		

	}
}
