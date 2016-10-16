package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import thoughtWorks.AutoSummary;


@RunWith(Parameterized.class)
public class GenerateSummaryTest {
	private AutoSummary as;
	private String input;
	private String output;
	
	
	@Before
	public void setUp() throws Exception {
		as = new AutoSummary();
	}
	
	@Parameters   

	public static Collection data(){

	        return Arrays.asList(new Object[][]{

	                {"2016-06-02 20:00~22:00 7", "2016-06-02 20:00~22:00 +210 -240 -30"},
	                {"2016-06-03 09:00~12:00 14", "2016-06-03 09:00~12:00 +420 -180 +240"},
	                {"2016-06-04 14:00~17:00 22", "2016-06-04 14:00~17:00 +660 -600 +60"},
	                {"2016-06-05 19:00~22:00 3", "2016-06-05 19:00~22:00 +0 -0 0"},
	                {"2016-06-06 12:00~15:00 15", "2016-06-06 12:00~15:00 +450 -300 +150"},
	                {"2016-06-07 15:00~17:00 12", "2016-06-07 15:00~17:00 +360 -200 +160"},
	                {"2016-06-08 10:00~13:00 19", "2016-06-08 10:00~13:00 +570 -330 +240"},
	                {"2016-06-09 16:00~18:00 16", "2016-06-09 16:00~18:00 +480 -300 +180"},
	                {"2016-06-10 20:00~22:00 5", "2016-06-10 20:00~22:00 +150 -120 +30"},
	                {"2016-06-11 13:00~15:00 11", "2016-06-11 13:00~15:00 +330 -200 +130"},

	        });

	}

	//构造函数，对变量进行初始化

	public GenerateSummaryTest(String input,String output){
	        this.input = input;
	        this.output = output;
	}

	
	@Test
	public void testGenerateSummary() {
		assertEquals(output,as.generateSummary(input));
	}

}
