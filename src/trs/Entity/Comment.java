package trs.Entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@Column(name = "comment_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "creator")
	private User creator;

	@ManyToOne
	@JoinColumn(name = "event")
	private Event eventID;

	@Column(name = "message")
	private String message;
	
	//sample date:2018-05-21 17:48:00
	@Column(name = "date")
	private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Event getEventID() {
		return eventID;
	}

	public void setEventID(Event event) {
		this.eventID = event;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", creator=" + creator + ", eventID=" + eventID + ", message=" + message
				+ ", date=" + date + "]";
	}

}
