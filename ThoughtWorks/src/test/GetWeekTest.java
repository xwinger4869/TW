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
public class GetWeekTest {
	private AutoSummary as;
	private String date;
	private String week;

	@Before
	public void setUp() throws Exception {
		as = new AutoSummary();
	}
	
	@Parameters   

	public static Collection data(){

	        return Arrays.asList(new Object[][]{
	        		
	        		{"2016-06-01", "星期三"},
	                {"2016-06-02", "星期四"},
	                {"2016-06-03", "星期五"},
	                {"2016-06-04", "星期六"},
	                {"2016-06-05", "星期日"},
	                {"2016-06-06", "星期一"},
	                {"2016-06-07", "星期二"},
	                {"2016-06-30", "星期四"},
	                {"2016-12-31", "星期六"},

	        });

	}

	//构造函数，对变量进行初始化

	public GetWeekTest(String date,String week){
	        this.date = date;
	        this.week = week;
	}

	
	@Test
	public void test() {
		assertEquals(week,as.getWeek(date));
	}

}
