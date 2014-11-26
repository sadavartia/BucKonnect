package bucKonnect.EJB.Sessions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Entities.UserEventEntity;

@Stateless
public class UserEventService {

	@PersistenceContext(unitName = "BucKonnect-EJB")
	EntityManager em;

	UserEventEntity userEvent = new UserEventEntity();

	public String createUserEvent(UserEventEntity userevent) {

		try {
			em.persist(userevent);
			em.flush();
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		} catch (ConstraintViolationException e) {
			return "Constraint Violation for Event";
		} catch (Exception ex) {
			return ex.toString() + ex.getMessage() + ex.getStackTrace();
		}
		return "Success";
	}

	public String deleteUserEvent(UserEventEntity userevent) {

		try {
			em.remove(userevent);
			em.flush();
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		} catch (ConstraintViolationException e) {
			return "Constraint Violation for Event";
		} catch (Exception e) {
			return "Event Exception";
		}
		return "Success";
	}

	public List<List<String>> searchUserEvents(UserEntity user) {

		List<UserEventEntity> userevents = new ArrayList<>();

		List<List<String>> lsUserEvents = new ArrayList<List<String>>();

		Query query = em.createNativeQuery(
				"Select * from User_Events where USER_NAME = '"
						+ user.getOSU_Email_Id() + "'", UserEventEntity.class);

		userevents = query.getResultList();

		String event_Name;
		if (!userevents.isEmpty()) {
			int size = userevents.size();

			for (int i = 0; i < size; i++) {
				UserEventEntity temp = new UserEventEntity();
				temp = userevents.get(i);

				event_Name = temp.getEvent_Name();

				List<String> ug = new ArrayList<String>();

				ug.add(event_Name);

				lsUserEvents.add(ug);
			}
		}
		return lsUserEvents;
	}
}