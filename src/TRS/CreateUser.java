package TRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import TRS.Entity.*;

/**
 * Erstellt einen User in der DB mittels einer Hibernate Session
 * 
 * @author Gurparkash
 *
 */
public class CreateUser {

	public CreateUser(String firstname, String lastname, String email, String password) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a user object
			User tempUser = new User();
			tempUser.setFirstname(firstname);
			tempUser.setLastname(lastname);
			tempUser.setEmail(email);
			tempUser.setPassword(password);
			// start a transaction
			session.beginTransaction();

			// save the user object
			session.save(tempUser);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	public static void main(String[] args) {
		new CreateUser("2", "3", "5", "4");
	}

}
