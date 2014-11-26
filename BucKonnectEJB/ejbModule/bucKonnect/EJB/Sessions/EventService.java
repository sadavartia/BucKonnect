package bucKonnect.EJB.Sessions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import bucKonnect.EJB.Entities.EventEntity;
import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Entities.UserEventEntity;
import bucKonnect.EJB.Entities.UserGroupEntity;

/**
 * Session Bean implementation class EventService
 */
@Stateless
public class EventService {
	@PersistenceContext(unitName = "BucKonnect-EJB")
	EntityManager em;

	public String createEvent(EventEntity event) {

		try {
			em.persist(event);
			em.flush();

			UserEventEntity userevent = new UserEventEntity();
			userevent.setUser_Name(event.getPrimary_Event_Coordinator());
			userevent.setEvent_Name(event.getEvent_Name());
			em.persist(userevent);
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		} catch (ConstraintViolationException e) {
			return "Constraint Violation for Event";
		}

		catch (Exception e) {
			return "Event Exception";
		}
		return "Success";
	}

	public String updateEvent(EventEntity event) {

		List<EventEntity> event_list;
		Query query = em.createNativeQuery(
				"update Events set Event_Name = " + "'" + event.getEvent_Name()
						+ "'" + " ," + " Event_Details = " + "'"
						+ event.getEvent_Details() + "'" + " ,"
						+ " Primary_Event_Coordinator = " + "'"
						+ event.getPrimary_Event_Coordinator() + "'" + " ,"
						+ " Event_Location = " + "'"
						+ event.getEvent_Location() + "'" + " Event_Info = "
						+ "'" + event.getEvent_Info() + "'" + " ,"
						+ " Event_Date_Time = " + "'"
						+ event.getEvent_Date_Time() + "'" + " ,"
						+ " Event_Duration = " + "'"
						+ event.getEvent_Duration() + "'"
						+ " where Event_ID = " + event.getEvent_Id() + ";",
				EventEntity.class);

		try {
			query.executeUpdate();
			em.flush();

		} catch (Exception e) {
			return "Entity_Update_fail";
		}

		return "Entity_Update_Success";

	}

	public List<List<String>> search_Events(EventEntity event) {

		List<EventEntity> events = new ArrayList<>();

		List<List<String>> lsEvents = new ArrayList<List<String>>();
		Query query = em.createNativeQuery(
				"select * from Events where Event_Name like '%"
						+ event.getEvent_Name() + "%' OR Event_Location LIKE '%"
						+ event.getEvent_Location() + "%';", EventEntity.class);

		String event_Name;
		String event_Details;
		String primary_Event_Coordinator;
		String event_Location;
		String event_Info;
		String event_Date_Time;
		String event_Duration;
		events = query.getResultList();
		if (!events.isEmpty()) {
			int size = events.size();

			for (int i = 0; i < size; i++) {
				EventEntity temp = new EventEntity();
				temp = events.get(i);

				event_Name = temp.getEvent_Name();
				event_Details = temp.getEvent_Details();
				event_Location = temp.getEvent_Location();
				primary_Event_Coordinator = temp.getPrimary_Event_Coordinator();
				event_Location = temp.getEvent_Location();
				event_Info = temp.getEvent_Info();
				event_Date_Time = temp.getEvent_Date_Time();
				event_Duration = temp.getEvent_Duration();

				List<String> e = new ArrayList<String>();

				e.add(event_Name);
				e.add(event_Details);
				e.add(primary_Event_Coordinator);
				e.add(event_Location);
				e.add(event_Info);
				e.add(event_Date_Time);
				e.add(event_Duration);

				lsEvents.add(e);
			}
		}
		return lsEvents;
	}
}