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
	        		
	        		{"2012-07-30", "星期一"},
	        		{"2013-08-23", "星期五"},
	        		{"2014-07-11", "星期五"},
	        		{"2015-04-25", "星期六"},
	        		{"2016-01-01", "星期五"},
	                {"2016-02-29", "星期一"},
	                {"2016-03-11", "星期五"},
	                {"2016-04-16", "星期六"},
	                {"2016-05-22", "星期日"},
	                {"2016-06-06", "星期一"},
	                {"2016-07-05", "星期二"},
	                {"2016-08-25", "星期四"},
	                {"2016-09-19", "星期一"},
	                {"2016-10-12", "星期三"},
	                {"2016-11-17", "星期四"},
	                {"2016-12-31", "星期六"},
	                {"2017-06-21", "星期三"},
	                {"2018-03-25", "星期日"},
	                {"2019-12-11", "星期三"},
	                {"2020-10-10", "星期六"},

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
