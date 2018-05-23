package TRS.Entity;

import java.util.List;

public class Event {

	private int id;
	
	private User creator;

	private String name;

	private String location;

	private String note;

	private List<Comment> comments;
	
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
