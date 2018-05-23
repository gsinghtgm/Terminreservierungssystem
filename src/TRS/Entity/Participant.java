package TRS.Entity;

public class Participant {

	private int id;
	
	private User participant;
	
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
