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

		Query query = em.createNativeQuery(
				"Select * from UserGroups where USER_NAME = '"
						+ user.getOSU_Email_Id() + "'", UserGroupEntity.class);
em.
		String group_Name;

		usergroups = query.getResultList();
		if (!usergroups.isEmpty()) {
			int size = usergroups.size();

			for (int i = 0; i < size; i++) {
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