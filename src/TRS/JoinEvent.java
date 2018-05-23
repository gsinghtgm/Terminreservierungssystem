package TRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TRS.Entity.Event;
import TRS.Entity.Participant;
import TRS.Entity.User;

public class JoinEvent {

	public JoinEvent(int userid, int eventid) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Event.class)
				.addAnnotatedClass(User.class).addAnnotatedClass(Participant.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {// start a transaction
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

		} finally {
			factory.close();
		}

	}

	public static void main(String[] args) {
		new JoinEvent(2, 1);
	}

}
