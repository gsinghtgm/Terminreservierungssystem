package TRS.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class Participant {

	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User participant;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Participant [participant=" + participant + ", event=" + event + "]";
	}

}
