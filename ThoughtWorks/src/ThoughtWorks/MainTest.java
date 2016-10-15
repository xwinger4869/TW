package ThoughtWorks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	private static Main main;
	@Before
	public void setUp() throws Exception {
		main = new Main();
	}

	@Test
	public void testGenerateSummary() {
		String input = "2016-06-02 20:00~22:00 7";
		String output = main.generateSummary(input);
		String expected = "2016-06-02 20:00~22:00 +210 -240 -30";
		assertEquals(expected,output);
	}

	@Test
	public void testGetWeek() {
		String date = "2016-06-02";
		String week = main.GetWeek(date);
		String expected = "星期四";
		assertEquals(expected,week);
	}

	@Test
	public void testGetFee() {
		String week = "星期日";
		int begin = 9;
		int end = 10;
		int fee = main.GetFee(week, begin, end);
		int expected = 40;
		assertEquals(expected,fee);
	}

	@Test
	public void testGetGroundNum() {
		int num = 10;
		int g_num = main.GetGroundNum(num);
		int expected = 2;
		assertEquals(expected,g_num);
	}

}
