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
public class GetGroundNumTest {

	private AutoSummary as;
	private int num;
	private int g_num;

	@Before
	public void setUp() throws Exception {
		as = new AutoSummary();
	}
	
	@Parameters   

	public static Collection data(){

	        return Arrays.asList(new Object[][]{

	                {0, 3},{1, 4},{2, 6},{2, 11},

	                {3, 16},{4, 23},{4, 24},{5, 30}

	        });

	}

	//构造函数，对变量进行初始化

	public GetGroundNumTest(int g_num,int num){
	        this.num = num;
	        this.g_num = g_num;
	}

	
	@Test
	public void test() {
		assertEquals(g_num,as.getGroundNum(num));
	}

}
