package TRS.Entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Comment {
	private int id;

	private User creator;

	private Event eventID;

	private String message;
	
	//sample date:2018-05-21 17:48:00
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
