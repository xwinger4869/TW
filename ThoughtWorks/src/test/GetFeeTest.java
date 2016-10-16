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

	                {"������", 9 , 12 , 120},
	                {"������", 11 , 13 , 90},
	                {"������", 12 , 14 , 100},
	                {"������", 17 , 19 , 110},
	                {"������", 20 , 22 , 120},
	                {"����һ", 9 , 11 , 60},
	                {"���ڶ�", 11 , 13 , 80},
	                {"������", 14 , 17 , 150},
	                {"������", 17 , 19 , 130},
	                {"������", 19 , 20 , 80},
	                {"����һ", 19 , 21 , 140},
	                {"���ڶ�", 20 , 22 , 120},

	        });

	}

	//���캯�����Ա������г�ʼ��

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
