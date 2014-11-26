package bucKonnect.EJB.Sessions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import bucKonnect.EJB.Entities.GroupEntity;
import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Entities.UserGroupEntity;

@Stateless
public class UserGroupService {

	@PersistenceContext(unitName = "BucKonnect-EJB")
	EntityManager em;

	UserGroupEntity userGroup = new UserGroupEntity();

	public String createUserGroup(UserGroupEntity usergroup) {

		try {
			em.persist(usergroup);
			em.flush();
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		} catch (ConstraintViolationException e) {
			return "Constraint Violation for Group";
		} catch (Exception e) {
			return "Group Exception";
		}
		return "Success";
	}

	public String deleteUserGroup(UserGroupEntity usergroup) {

		try {
			em.remove(usergroup);
			em.flush();
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		} catch (ConstraintViolationException e) {
			return "Constraint Violation for Group";
		} catch (Exception e) {
			return "Group Exception";
		}
		return "Success";
	}

	public List<List<String>> searchUserGroups(UserEntity user) {

		List<UserGroupEntity> usergroups = new ArrayList<>();

		List<List<String>> lsUserGroups = new ArrayList<List<String>>();
		// Needs to be implemented properly
		// Query query = em
		// .createQuery("Select g from Groups g, UserGroups ug Where  g.Group_Name = ug.Group_Name ");
		// + "where UG.USER_NAME = '"
		// + user.getOSU_Email_Id() + "'");

		Query query = em.createNativeQuery(
				"Select * from User_Groups where USER_NAME = '"
						+ user.getOSU_Email_Id() + "'", UserGroupEntity.class);

		usergroups = query.getResultList();

		String group_Name;
		if (!usergroups.isEmpty()) {
			int size = usergroups.size();

			for (int i = 0; i < size; i++) {
				// System.out.println(lsUserGroups.get(i).get(0));
				// System.out.println(lsUserGroups.get(i).get(1));
				// System.out.println(lsUserGroups.get(i).get(2));
				// System.out.println(lsUserGroups.get(i).get(3));
				UserGroupEntity temp = new UserGroupEntity();
				temp = usergroups.get(i);

				group_Name = temp.getGroup_Name();

				List<String> ug = new ArrayList<String>();

				ug.add(group_Name);

				lsUserGroups.add(ug);
			}
		}
		return lsUserGroups;
	}
}