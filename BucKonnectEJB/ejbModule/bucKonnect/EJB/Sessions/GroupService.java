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

	public String updateGroup(GroupEntity group) {

		List<GroupEntity> group_list;
		Query query = em.createNativeQuery(
				"update Groups set Group_Name = " + "'" + group.getGroup_Name()
						+ "'" + " ," + " Group_Information = " + "'"
						+ group.getGroup_Info() + "'" + " ,"
						+ " Primary_Admin = " + "'" + group.getPrimary_Admin()
						+ "'" + " ," + " Category = " + "'"
						+ group.getCategory() + ";", GroupEntity.class);

		try {
			query.executeUpdate();
			em.flush();

		} catch (Exception e) {
			return "Entity_Update_fail";
		}

		return "Entity_Update_Success";

	}

	public List<List<String>> search_Groups(GroupEntity group) {

		List<GroupEntity> groups = new ArrayList<>();

		List<List<String>> lsGroups = new ArrayList<List<String>>();

		Query query = em.createNativeQuery(
				"Select * from Groups where GROUP_NAME = '"
						+ group.getGroup_Name() + "'", GroupEntity.class);

		String group_Name;
		String group_Info;
		String primary_Admin;
		String category;

		groups = query.getResultList();
		if (!groups.isEmpty()) {
			int size = groups.size();

			for (int i = 0; i < size; i++) {
				GroupEntity temp = new GroupEntity();
				temp = groups.get(i);

				group_Name = temp.getGroup_Name();
				group_Info = temp.getGroup_Info();
				primary_Admin = temp.getPrimary_Admin();
				category = temp.getCategory();

				List<String> g = new ArrayList<String>();

				g.add(group_Name);
				g.add(group_Info);
				g.add(primary_Admin);
				g.add(category);
				lsGroups.add(g);
			}
		}
		return lsGroups;
	}

}