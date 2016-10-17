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
	        		
	        		{"2012-07-30", "����һ"},
	        		{"2013-08-23", "������"},
	        		{"2014-07-11", "������"},
	        		{"2015-04-25", "������"},
	        		{"2016-01-01", "������"},
	                {"2016-02-29", "����һ"},
	                {"2016-03-11", "������"},
	                {"2016-04-16", "������"},
	                {"2016-05-22", "������"},
	                {"2016-06-06", "����һ"},
	                {"2016-07-05", "���ڶ�"},
	                {"2016-08-25", "������"},
	                {"2016-09-19", "����һ"},
	                {"2016-10-12", "������"},
	                {"2016-11-17", "������"},
	                {"2016-12-31", "������"},
	                {"2017-06-21", "������"},
	                {"2018-03-25", "������"},
	                {"2019-12-11", "������"},
	                {"2020-10-10", "������"},

	        });

	}

	//���캯�����Ա������г�ʼ��

	public GetWeekTest(String date,String week){
	        this.date = date;
	        this.week = week;
	}

	
	@Test
	public void test() {
		assertEquals(week,as.getWeek(date));
	}

}
