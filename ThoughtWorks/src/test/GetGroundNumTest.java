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

	                {0, 1},{0, 2},{0, 3},{1, 4},{1, 5},{2, 6},

	                {2, 6},{2, 7},{2, 8},{2, 9},{2, 10},{2, 11},

	                {3, 16},{3, 17},{4, 22},{4, 23},{4, 24},{4, 25},
	                
	                {4, 26},{4, 27},{4, 28},{4, 29},{5, 30},{5, 31},

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
