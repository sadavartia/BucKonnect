package bucKonnect.EJB.Client;

import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnit44Runner;

import bucKonnect.EJB.Entities.UserEntity;
import bucKonnect.EJB.Sessions.UserService;

@SuppressWarnings("deprecation")
@Stateless(name = "JobListingTest")
@RunWith(MockitoJUnit44Runner.class)
public class TestClient {	
	@EJB private UserService uService=new UserService();
	
//    private JobListing joblisting;

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//	
//	@Before
//	  public void bootContainer() throws Exception{
//        Properties props = new Properties();
//        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
//        Context context = new InitialContext(props);
//        joblisting = (JobListing) context.lookup("JobListing");
//
//    }

	@Test
	public void testFindJob() throws NamingException {
		UserEntity user=new UserEntity();
		user.setFirst_Name("Aaa");
		user.setLast_Name("BBB");
		uService.register_User(user);
	    //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        //EJBContainer container = EJBContainer.createEJBContainer();
			//JobListing joblisting = (JobListing)container.getContext().lookup("java:global/classes/JobListing");
	    	//JobListing joblisting = new JobListing();
		
		 /*EJBContainer ejbC = EJBContainer.createEJBContainer();

		    Context ctx = ejbC.getContext();

		    JobListing joblisting = (JobListing) ctx.lookup("java:global/classes/JobListing");

		    assertNotNull(joblisting);*/
		
			//JobListing joblisting = mock(JobListing.class);
			//String[] ret = joblisting.findJob("Developer II", "CT");
			//int len = ret.length;

		
	  

	}

}
