package bucKonnect.EJB.Sessions;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import bucKonnect.EJB.Entities.UserEntity;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService {

	@PersistenceContext(unitName = "BucKonnect-EJB")
	EntityManager em;

	public String register_User(UserEntity user) {

		try {
			em.persist(user);
			em.flush();
		} catch (EntityExistsException ex) {
			return ex.getMessage();
		} catch (ConstraintViolationException ex) {
			return ex.getMessage();
		} catch (Exception ex) {
			return ex.getMessage();
		}

		return "Success";
	}

	public String login_User(UserEntity user) {
		List<UserEntity> users;
		try {
			Query query = em.createNativeQuery(
					"select * from Users where OSU_Email_Id = '"
							+ user.getOSU_Email_Id() + "'"
							+ " AND PASSWORD = '" + user.getPassword() + "'",
					UserEntity.class);

			users = query.getResultList();
			if (!users.isEmpty() && users.size() == 1) {
				return "success";
			}
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "failure";
	}

	public String update_User(UserEntity user) {

		Query query = em.createNativeQuery(
				"Update Users Set First_Name = '" + user.getFirst_Name()
						+ "', Last_Name = '" + user.getLast_Name()
						+ "', Phone_Number = '" + user.getPhone_Number()
						+ "', Dob = '" + user.getDob() + "', Is_Faculty = '"
						+ user.getIs_Faculty() + "', Department = '"
						+ user.getDepartment() + "', Major = '"
						+ user.getMajor() + "', About_Me = '"
						+ user.getAbout_Me() + "', Interests = '"
						+ user.getInterests() + "' Where OSU_Email_Id = '"
						+ user.getOSU_Email_Id() + "'", UserEntity.class);
		try {
			query.executeUpdate();
			em.flush();
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "success";
	}

	public List<List<String>> search_Users(UserEntity user) {

		List<UserEntity> users = new ArrayList<>();

		List<List<String>> lsUsers = new ArrayList<List<String>>();

		Query query = em.createNativeQuery(
				"Select * from Users where OSU_Email_Id = '"
						+ user.getOSU_Email_Id() + "'", UserEntity.class);

		String OSU_Email_Id = "";
		String FName = "";
		String LName = "";
		String PNo = "";
		String DOB = "";
		String IsFaculty = "";
		String AboutMe = "";
		String Major = "";
		String Dept = "";
		String Interests = "";
		users = query.getResultList();
		if (!users.isEmpty()) {
			int size = users.size();

			for (int i = 0; i < size; i++) {
				UserEntity temp = new UserEntity();
				temp = users.get(i);

				OSU_Email_Id = temp.getOSU_Email_Id();
				if (temp.getFirst_Name() != null)
					FName = temp.getFirst_Name();
				if (temp.getLast_Name() != null)
					LName = temp.getLast_Name();
				// PNo = Long.toString(temp.getPhone_Number());
				if (temp.getPhone_Number() != null)
					PNo = temp.getPhone_Number();
				if (temp.getDob() != null)
					DOB = temp.getDob();
				// IsFaculty = Boolean.toString(temp.isIs_Faculty());
				if (temp.getIs_Faculty() != null)
					IsFaculty = temp.getIs_Faculty();
				if (temp.getAbout_Me() != null)
					AboutMe = temp.getAbout_Me();
				if (temp.getMajor() != null)
					Major = temp.getMajor();
				if (temp.getDepartment() != null)
					Dept = temp.getDepartment();
				if (temp.getInterests() != null)
					Interests = temp.getInterests();
				List<String> u = new ArrayList<String>();

				u.add(OSU_Email_Id);
				u.add(FName);
				u.add(LName);
				u.add(PNo);
				u.add(DOB);
				u.add(IsFaculty);
				u.add(AboutMe);
				u.add(Major);
				u.add(Dept);
				u.add(Interests);
				lsUsers.add(u);
			}
		}
		return lsUsers;
	}
}