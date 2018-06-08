package trs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import trs.Entity.Event;
import trs.Entity.User;

/**
 * Erstellt ein Event in der DB mittels einer Hibernate Session
 * 
 * @author Gurparkash
 *
 */
public class CreateEvent {

	public boolean createEvent(int userid, String name, String location, String note, Session session) {

		// start a transaction
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
		return true;
	}

}
