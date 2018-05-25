package TRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TRS.Entity.Comment;
import TRS.Entity.Event;
import TRS.Entity.User;

/**
 * Erstellt ein Kommentar in der DB mittels einer Hibernate Session
 * 
 * @author Gurparkash
 *
 */
public class CreateComment {

	public boolean createComment(int userid, int eventid, String message, Session session) {
		// start a transaction
		session.beginTransaction();

		// create a comment object
		User user = session.get(User.class, userid);
		Event event = session.get(Event.class, eventid);
		Comment tempComment = new Comment();
		tempComment.setMessage(message);
		tempComment.setCreator(user);
		tempComment.setEventID(event);

		// save the comment object
		session.save(tempComment);
		// commit transaction
		session.getTransaction().commit();
		return true;
	}

}
