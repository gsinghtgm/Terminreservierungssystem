package TRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TRS.Entity.Event;
import TRS.Entity.Participant;
import TRS.Entity.User;

/**
 * Fuegt einen User zu einem Event hinzu.
 * 
 * @author Gurparkash
 *
 */
public class JoinEvent {

	public boolean joinEvent(int userid, int eventid, Session session) {

		// start a transaction
		session.beginTransaction();
		// create a user object
		User user = session.get(User.class, userid);
		Event event = session.get(Event.class, eventid);
		Participant tempParticipant = new Participant();
		tempParticipant.setEvent(event);
		tempParticipant.setParticipant(user);
		session.save(tempParticipant);

		// commit transaction
		session.getTransaction().commit();
		return true;
	}

}
