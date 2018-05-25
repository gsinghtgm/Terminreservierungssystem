package TRS;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import TRS.Entity.User;

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
		Query login = session.createQuery("from User where user_id=:name and password=:password");
		login.setParameter("name", username);
		login.setParameter("password", password);
		if (!login.getResultList().isEmpty())
			return true;
		return false;
	}
}
