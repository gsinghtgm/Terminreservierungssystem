package trs.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	private int id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany(targetEntity = Event.class, mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Event> events;

	@OneToMany(targetEntity = Comment.class, mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;

	@OneToMany(targetEntity = Participant.class, mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Participant> participating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public List<Participant> getParticipating() {
		return participating;
	}

	public void setParticipating(List<Participant> participating) {
		this.participating = participating;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + "]";
	}

}
