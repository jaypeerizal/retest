package com.accenture.fers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.fers.dao.VisitorDAO;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;

/**
 * JUNIT test class for VisitorDAO class
 *
 */

/** Adding @ContextConfiguration for it to pick up context mappings */
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
/** Adding @RunWith to indicate that the class should use Spring's JUnit facilities */
@RunWith(SpringJUnit4ClassRunner.class)
/** Adding @Transactional to use transaction capabilities without having to use begin, commit etc. */
@Transactional
/** Adding @Component to make TestEventDAO as a component and to initiate Spring Dependency Injection */
@Component
public class TestVisitorDAO {

	/** Adding @Autowired to inject VisitorDAO instance */
	@Autowired
	private VisitorDAO visitorDAO;

	@PersistenceContext
	EntityManager entityManager;

	private Visitor visitor;
	private ArrayList<Event> registeredEvents;

	/**
	 * Setting up initial objects
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		registeredEvents = new ArrayList<Event>();
	}

	/**
	 * Deallocating objects after execution of every method
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		visitor = null;
		registeredEvents = null;
	}

	public void insertData() {

		visitor.setUserName("TestVisitor");
		visitor.setFirstName("TestVFname");
		visitor.setLastName("TestVLname");
		visitor.setPassword("ttt");
		visitor.setPhoneNumber("2344");
		visitor.setAddress("TestPlace");
		assertTrue(visitorDAO.insertData(visitor));

	}

	public void registerVisitorToEvent() {
		try {
			insertData();
			visitor = visitorDAO.searchUser("TestVisitor", "ttt");
			visitorDAO.registerVisitorToEvent(visitor, 1002);

		} catch (Exception exception) {
			fail("Exception !!!");
		}
	}

	/**
	 * Positive Test case for method insertData
	 */
		//TODO 1 . Annotate the method with @Test annotation

	public void testInsertData_Positive() {
		//TODO 2 Set the attribute of visitor object attribute- UserName to TestVisitor.
		//TODO 3 Set the attribute of visitor object attribute- FirstName to TestVFname.
		//TODO 4 Set the attribute of visitor object attribute- LastName to TestVLname.
		//TODO 5 Set the attribute of visitor object attribute- Password to junk.
		//TODO 6 Set the attribute of visitor object attribute- PhoneNumber to 2344
		//TODO 7 Set the attribute of visitor object attribute- Address to TestPlace
		//TODO 8. Use assertTrue() method to assert if data has been inserted into database by invoking insertData() method of  visitorDAO and passing visitor object as an object.
		//Hint: insertData() method should insert unique visitor object in the database.
	}

	/**
	 * Negative Test case for method insertData
	 */

	//TODO 1 . Annotate the method with @Test annotation
	public void testInsertData_Negative() {
		//TODO 2. Invoke insertData() method of the TestVisitorDAO class to insert the test data in the database.
		//TODO 3 Set the attribute of visitor object attribute- UserName to TestVisitor.
		//TODO 4 Set the attribute of visitor object attribute- FirstName to TestVFname.
		//TODO 5 Set the attribute of visitor object attribute- LastName to TestVLname.
		//TODO 6 Set the attribute of visitor object attribute- Password to junk.
		//TODO 7 Set the attribute of visitor object attribute- PhoneNumber to 2344
		//TODO 8 Set the attribute of visitor object attribute- Address to TestPlace
		//TODO 9. Use assertFalse() method to assert if data has been inserted into database by invoking insertData() method of  visitorDAO and passing visitor object as an object.
		//Hint: insertData() method should not insert the same object twice in the database.
		}

	/**
	 * Positive Test case for method searchUser
	 */

	   //TODO 1 . Annotate the method with @Test annotation
	public void testSearchUser_Positive() {
		//TODO 2. Invoke insertData() method of the TestVisitorDAO class to insert the test data in the database.
		//TODO 3. Invoke searchUser() method of VisitorDAO class by passing the test user name "TestVisitor", password "ttt" and
		//use visitor object instance created in the setUp() method to save the return the value.
		//TODO 4. Use assertEquals() method to check if visitor object username is equals to "TestVisitor".
		//Hint : As we are testing for positive condition assertEquals should be true.
	}

	/**
	 * Negative Test case for method searchUser
	 */
		//TODO 1 . Annotate the method with @Test annotation
		public void testSearchUser_Negative() {
		//TODO 2. Create a Try-Catch block.Catch NoResultException in a catch block.
		//TODO 3. Under try block, invoke searchUser() method of VisitorDAO class by passing the test user name "TestVisitor", password "ttt" and
		//use visitor object instance created in the setUp() method to save the return the value.
		//TODO 4. Use assertEquals() method to check if the exception object returns "No rows found" message on invocation of getMessage() object.
		//Hint: As we are testing negative condition,  searchUser() should not return any results.

	}

		/**
		 * Positive Test case for method registerVisitorToEvent
		 */
		@Test
		public void testRegisterVisitorToEvent_Positive() {
			try {
				visitor = visitorDAO.searchUser("bsmith", "password");
				visitorDAO.registerVisitorToEvent(visitor, 1003);

			} catch (Exception exception) {
				fail("Exception !!!");
			}
		}

		/**
		 * Negative Test case for method registerVisitorToEvent
		 */

		@Test
		public void testRegisterVisitorToEvent_Negative() {
			try {
				registerVisitorToEvent();
				visitor = visitorDAO.searchUser("TestVisitor", "ttt");
				visitorDAO.registerVisitorToEvent(visitor, 1002);

			} catch (Exception exception) {

				assertTrue(true);
			}
		}

		/**
		 * Positive Test case for method registeredEvents
		 */

		//@Test
		public void testRegisteredEvents_Positive() {

			List<Object[]> registeredEvents = new ArrayList<Object[]>();

			visitor = visitorDAO.searchUser("bsmith", "password");

			registeredEvents = visitorDAO.registeredEvents(visitor);

			assertTrue(registeredEvents.size() >= 1);
		}

		/**
		 * Negative Test case for method registeredEvents
		 */

	//	@Test
		public void testRegisteredEvents_Negative() {

			Visitor visitor = new Visitor();
			List<Object[]> registeredEvents = visitorDAO.registeredEvents(visitor);

			assertTrue(registeredEvents.size() == 0);
		}

		/**
		 * Positive Test case for method updateVisitor
		 */

	//	@Test
		public void testUpdateVisitor_Positive() {
			int updateStatus = 0;

			insertData();
			visitor = visitorDAO.searchUser("TestVisitor", "ttt");
			visitor.setFirstName("NewTestName");
			updateStatus = visitorDAO.updateVisitor(visitor);
			assertEquals(1, updateStatus);
		}

		/**
		 * Negative Test case for method updateVisitor
		 */

		@Test
		public void testUpdateVisitor_Negative() {
			int updateStatus = 0;

			Visitor v = new Visitor();
			try {
				updateStatus = visitorDAO.updateVisitor(visitor);
			} catch (PersistenceException e) {
				assertEquals("Update visitor failed", e.getMessage());
			}
			assertEquals(0, updateStatus);
		}

		/**
		 * Positive Test case for method UnregisterEvent
		 */

		@Test
		public void testUnregisterEvent_Positive() {

			visitor = visitorDAO.searchUser("bsmith", "password");
			visitorDAO.registerVisitorToEvent(visitor, 1001);

			try {

				visitorDAO.unregisterEvent(visitor, 1002);
			} catch (Exception exception) {
				fail("Exception");
			}
		}

		/**
		 * Negative Test case for method UnregisterEvent
		 */

		@Test
		public void testUnregisterEvent_Negative() {

			visitor = visitorDAO.searchUser("bsmith", "password");


			try {

				visitorDAO.unregisterEvent(visitor, 0000);
			} catch (NoResultException exception) {
				assertTrue(true);
			}

		}

		/**
		 * Positive Test case for method changePassword
		 */

		//@Test
		public void testChangePassword_Positive() {
			Visitor v = new Visitor();
			v.setVisitorId(1001);
			v.setUserName("bsmith");
			v.setPassword("NewPassword");

			int flag = visitorDAO.changePassword(v);
			assertTrue(flag == 1);

		}

		/**
		 * Negative Test case for method changePassword
		 */

		@Test
		public void testChangePassword_Negative() {
			Visitor v = new Visitor();
			v.setVisitorId(1001);
			v.setUserName("bsmith");
			v.setPassword("Password");

			int flag = visitorDAO.changePassword(v);
			assertTrue(flag == 0);

		}

		/**
		 * Positive Test case for method searchVisitor
		 */

		@Test
		public void testSearchVisitor_Positive() {
			boolean flag = visitorDAO.searchVisitor("bsmith");
			assertTrue(flag);

		}

		/**
		 * Positive Test case for method searchVisitor
		 */

	//	@Test
		public void testSearchVisitor_Negative() {
			boolean flag = visitorDAO.searchVisitor("NonExistingUser");
			assertFalse(flag);

		}
}
