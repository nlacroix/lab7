import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class ArrayListAddressBookTest {

    private AddressBook dir;
    private ArrayListAddressBook deptDir;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println(System.getProperty("user.dir"));
		 dir = new ArrayListAddressBook();
		 deptDir = new ArrayListAddressBook();
		 deptDir.load("/home/user/deptdir.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	 public void anEmptyDirectoryHasNoFred() 
	 {
	     assertNull(dir.get("Fred", "Phone"));
	 }
	 
	 @Test
	 public void anEntryIsRemoved()
	 {
		 dir.put("Horstmann2", "Phone", "(408) 123-4567");
		 dir.remove("Horstmann2", "Phone");
		 assertEquals("Entry Removed.", "Entry Removed.");
	 }

	@Test (expected = NoSuchElementException.class)
	 public void removingNonExistantEntry()
	 {
		 dir.remove("Trey Songz", "Phone");
		 assertEquals("Entry Not Found.", "Entry Not Found.");
	 }
	
	@Test
	public void deptDirContainsHorstmann() 
	{
	   assertNotNull(deptDir.get("Horstmann", "Phone"));
	}
}
