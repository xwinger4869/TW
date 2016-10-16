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
public class GetFeeTest {

	private AutoSummary as;
	private String week;
	private int begin;
	private int end;
	private int fee;

	@Before
	public void setUp() throws Exception {
		as = new AutoSummary();
	}
	
	@Parameters   

	public static Collection data(){

	        return Arrays.asList(new Object[][]{

	                {"星期日", 9 , 12 , 120},
	                {"星期六", 11 , 13 , 90},
	                {"星期日", 12 , 14 , 100},
	                {"星期六", 17 , 19 , 110},
	                {"星期日", 20 , 22 , 120},
	                {"星期一", 9 , 11 , 60},
	                {"星期二", 11 , 13 , 80},
	                {"星期三", 14 , 17 , 150},
	                {"星期四", 17 , 19 , 130},
	                {"星期五", 19 , 20 , 80},
	                {"星期一", 19 , 21 , 140},
	                {"星期二", 20 , 22 , 120},

	        });

	}

	//构造函数，对变量进行初始化

	public GetFeeTest(String week,int begin,int end,int result){
	        this.week = week;
	        this.begin = begin;
	        this.end = end;
	        this.fee = result;
	}

	
	@Test
	public void test() {
		assertEquals(fee,as.getFee(week,begin,end));
	}

}
