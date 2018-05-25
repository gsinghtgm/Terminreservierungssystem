package TRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TRS.Entity.*;

public class FactoryBuilder {
	// create session factory
	public SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
			.addAnnotatedClass(Event.class).addAnnotatedClass(Comment.class).addAnnotatedClass(Participant.class)
			.buildSessionFactory();
	// create session
	public Session session = factory.getCurrentSession();

}
