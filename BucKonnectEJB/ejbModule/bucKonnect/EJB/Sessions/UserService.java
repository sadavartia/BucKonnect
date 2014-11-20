package bucKonnect.EJB.Sessions;

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
				"Update Users Set First_Name = " + "'" + user.getFirst_Name()
						+ "'" + " ," + " Last_Name = " + "'"
						+ user.getLast_Name() + "'" + " ," + " Phone_Number = "
						+ user.getPhone_Number() + " ," + " Dob = "
						+ user.getDob() + " ," + " Department = " + "'"
						+ user.getDepartment() + "'" + " ," + " Major = " + "'"
						+ user.getMajor() + "'" + " ," + " About_Me = " + "'"
						+ user.getAbout_Me() + "'" + " ," + " Interests = "
						+ "'" + user.getInterests() + "'" + " ,"
						+ " Where OSU_Email_Id = " + "'"
						+ user.getOSU_Email_Id() + "'", UserEntity.class);

		try {
			query.executeUpdate();
			em.flush();
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "success";
	}

	public List<UserEntity> search_Users(UserEntity user) {

		List<UserEntity> users = new ArrayList<>();

		Query query = em.createNativeQuery(
				"Select * from Users where OSU_Email_Id = '"
						+ user.getOSU_Email_Id() + "'", UserEntity.class);

		users = query.getResultList();
		return users;
	}
}