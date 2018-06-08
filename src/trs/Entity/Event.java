package trs.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@Column(name = "event_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "creator")
	private User creator;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "note")
	private String note;

	@OneToMany(targetEntity = Comment.class, mappedBy = "eventID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(targetEntity = Participant.class, mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Participant> participating;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
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
		return "Event [id=" + id + ", creator=" + creator + ", name=" + name + ", location=" + location + ", note="
				+ note + "]";
	}

}
