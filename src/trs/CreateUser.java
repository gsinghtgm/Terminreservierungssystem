package trs;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import trs.Entity.*;

/**
 * Erstellt einen User in der DB mittels einer Hibernate Session
 * 
 * @author Gurparkash
 *
 */
public class CreateUser {

	public boolean createUser(String firstname, String lastname, String email, String password, Session session) {

		// start a transaction
		session.beginTransaction();
		Query checkUser = session.createQuery("from User where email=:email");
		checkUser.setParameter("email", email);
		if (checkUser.getResultList().isEmpty()) {
			// create a user object
			User tempUser = new User();
			tempUser.setFirstname(firstname);
			tempUser.setLastname(lastname);
			tempUser.setEmail(email);
			tempUser.setPassword(password);
			// save the user object
			session.save(tempUser);
		} else {
			System.err.println("User existiert schon!");
			return false;
		}
		// commit transaction
		session.getTransaction().commit();

		return true;

	}

	public static void main(String[] args) {
		CreateUser x = new CreateUser();
		FactoryBuilder fb = new FactoryBuilder();
		boolean is = x.createUser("2", "3", "54555", "4", fb.session);
		if (is)
			System.out.println("GG");
		fb.factory.close();
	}

}
