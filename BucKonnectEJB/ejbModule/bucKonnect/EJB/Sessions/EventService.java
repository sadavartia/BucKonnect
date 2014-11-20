package bucKonnect.EJB.Sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import bucKonnect.EJB.Entities.EventEntity;

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

	public List<EventEntity> searchEvent(EventEntity event) {

		List<EventEntity> event_list;
		Query query = em.createNativeQuery(
				"select * from Events where Event_Name like '"
						+ event.getEvent_Name() + "' OR Event_Location= '"
						+ event.getEvent_Location() + "';", EventEntity.class);
		event_list = query.getResultList();

		return event_list;
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

}