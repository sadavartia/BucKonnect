package bucKonnect.EJB.Sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import bucKonnect.EJB.Entities.GroupEntity;

@Stateless
public class GroupService {
	
	@PersistenceContext(unitName = "BucKonnect-EJB")
	EntityManager em;

	public String createGroup(GroupEntity group) {

		try {
			em.persist(group);
			em.flush();
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		}

		catch (ConstraintViolationException e) {
			return "Constraint Violation for Group";
		}

		catch (Exception e) {
			return "Group Exception";
		}
		return "Success";
	}

	public List<GroupEntity> searchGroup(GroupEntity group) {

		List<GroupEntity> group_list;
		Query query = em.createNativeQuery(
				"select * from Groups where Group_Name like '"
						+ group.getGroup_Name() + "' OR Category= '"
						+ group.getCategory() + "';", GroupEntity.class);
		group_list = query.getResultList();

		return group_list;
	}

	public String updateGroup(GroupEntity group) {

		List<GroupEntity> group_list;
		Query query = em.createNativeQuery(
				"update Groups set Group_Name = " + "'" + group.getGroup_Name()
						+ "'" + " ," + " Group_Information = " + "'"
						+ group.getGroup_Info() + "'" + " ,"
						+ " Primary_Admin = " + "'"
						+ group.getPrimary_Admin() + "'" + " ,"
						+ " Category = " + "'"
						+ group.getCategory()  + ";"
						, GroupEntity.class);

		try {
			query.executeUpdate();
			em.flush();

		} catch (Exception e) {
			return "Entity_Update_fail";
		}

		return "Entity_Update_Success";

	}


}