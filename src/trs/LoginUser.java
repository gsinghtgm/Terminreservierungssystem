package trs;

import javax.persistence.Query;

import org.hibernate.Session;

/**
 * Prueft ob ein User in der Datenbank gespeichert ist.
 * 
 * @author Gurparkash
 *
 */
public class LoginUser {
	public boolean loginUser(String username, String password, Session session) {
		// start a transaction
		session.beginTransaction();
		Query login = session.createQuery("from User where email=:name and password=:password");
		login.setParameter("name", username);
		login.setParameter("password", password);
		if (!login.getResultList().isEmpty())
			return true;
		return false;
	}
}
