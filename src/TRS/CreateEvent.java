package TRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import TRS.Entity.Event;
import TRS.Entity.User;
/**
 * Erstellt ein Event in der DB mittels einer Hibernate Session
 * 
 * @author Gurparkash
 *
 */
public class CreateEvent {

	public CreateEvent(int userid, String name, String location, String note) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Event.class)
				.addAnnotatedClass(User.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {// start a transaction
			session.beginTransaction();

			// create a event object
			User user = session.get(User.class, userid);
			Event tempEvent = new Event();
			tempEvent.setCreator(user);
			tempEvent.setName(name);
			tempEvent.setLocation(location);
			tempEvent.setNote(note);

			// save the event object
			session.save(tempEvent);
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	public static void main(String[] args) {
		new CreateEvent(1, "testevent", "Wien", "");
	}

}
