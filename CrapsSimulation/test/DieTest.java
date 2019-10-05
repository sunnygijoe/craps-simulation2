import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;


public class DieTest
{
	private Die die;
	
	@Before
	public void setUp() throws Exception
	{
		int[] init_values = new int[]
		{3,2,1};
		die = new Die(init_values);
	}
	
	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_initialization_of_predictable_die()
	{
		
		die.roll();
		int value = die.getLastRoll();
		assertEquals("first value not 3", 3, value);
		
	}
	
	@Test
	public void test_roll_2_of_predictable_die()
	{
		
		die.roll();
		assertEquals("first value not 3", 3, die.getLastRoll());
		die.roll();
		assertEquals("second value not 2", 2, die.getLastRoll());
		
	}
	
	@Test
	public void test_roll_3_of_predictable_die()
	{
		
		die.roll();
		die.roll();
		die.roll();
		assertEquals("third value not 1", 1, die.getLastRoll());
		
	}
	
	@Test
	public void test_roll_4_of_predictable_die_with_3_rolls()
	{
		
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("fourth value not 3", 3, die.getLastRoll());
		
	}
	
	@Test
	public void test_roll_5_of_predictable_die_with_3_rolls()
	{
		
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("fourth value not 2", 2, die.getLastRoll());
		
	}
	
	@Test(expected = RuntimeException.class)
	public void test_null_initial_int_array()
	{
		Die die = new Die(null);
		die.roll();
	}
	
	@Test
	public void test_static()
	{
		Die die;
		CrookedDie1 cd1 = new CrookedDie1();
		die = cd1;
		
		
		assertEquals("subclass static instance test", die.testStatic(), "Die.testStatic()");
		
		
		
	}
	

}
