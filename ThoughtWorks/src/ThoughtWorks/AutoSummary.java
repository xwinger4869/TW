package thoughtWorks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoSummary {
	private int f_income = 0;
	private int f_payment = 0;
	private int f_profit = 0;
	private int sizeofInput = 0;
	
	/**

	*����������ַ�������
	

	*@return input
	*�����ַ���
	
	*@exception  IOException

	
	**/
	
	public String[] getInput(){
		BufferedReader bufr = 
                new BufferedReader(new InputStreamReader(System.in));

		String line = "";
		String[] input = new String[20];	
		try {
			while((line=bufr.readLine())!=null)
			{
				if("".equals(line))
					break;
				input[sizeofInput] = line;
				sizeofInput++;
			}
			bufr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return input;
	}
	
	/**

	*�����֧��¼
	
	*@param input
	*��ʽ�����¼
	
	**/
	public void outPut(String[] input){
		System.out.println("[Summary]");
		System.out.println("");
		for(int j=0;j<sizeofInput;j++){
			System.out.println(generateSummary(input[j]));
		}
		System.out.println("");
		System.out.println("Total Income: "+f_income);
		System.out.println("Total Payment: "+f_payment);
		System.out.println("Total Profit: "+f_profit);
	}
		
	
	/**

	* ������¼  ������֧��¼

	*@param input
	*��ʽ�����¼
	         
	*@return output
	*��ʽ����֧��¼

	
	**/
	
	public String generateSummary(String input){
		//�����ַ������õ����ڡ���ʼʱ�䡢����ʱ�䡢����
		String date = input.substring(0, input.indexOf(" "));
		input = input.substring(input.indexOf(" ")+1, input.length());
		int begin = Integer.parseInt(input.substring(0, input.indexOf(":")));
		input = input.substring(input.indexOf("~")+1, input.length());
		int end = Integer.parseInt(input.substring(0, input.indexOf(":")));
		input = input.substring(input.indexOf(" ")+1, input.length());
		int num = Integer.parseInt(input);		
		String week = getWeek(date);  
		int fee = getFee(week,begin,end);
		int gnum = getGroundNum(num);
		int income = 0;
		if(gnum>0){income = num*30;}		
		f_income += income;
		int payment = fee*gnum;
		f_payment += payment;
		int profit = income-payment;
		f_profit += profit;
		String final_profit = profit>0?("+"+profit):(""+profit);
		String final_begin = begin<10?("0"+begin):(""+begin);
		String output = date+" "+final_begin+":00~"+end+":00 +"+income+" -"+payment+" "+final_profit;
		/*if(begin<10){
			output = date+" 0"+begin+":00~"+end+":00 +"+income+" -"+payment+" "+profit;
		}*/
		return output; 
	}
	

	/**

	* ����"yyyy-MM-dd" �����ܼ�

	*@param date
	*��ʽ������
	         
	*@return week
	*�ܼ�

	*@exception  ParseException
	
	**/
	public String getWeek(String date){
		String week = null;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat wt = new SimpleDateFormat ("EEEE");
	    Date t;
	    try {
	         t = ft.parse(date);
	         week = wt.format(t);
	    } catch (ParseException e) {
	         System.out.println("Unparseable using " + ft);
	     }
		return week; 
	}
	
	
	/**

	* �����ܼ�����ʼʱ�䡢����ʱ�䣬 ���ط���

	*@param week begin end
	*�ܼ�����ʼʱ�䡢����ʱ��
	         
	*@return fee
	*����
	
	**/
	public int getFee(String week,int begin,int end){
		int fee = 0;
		if(week == "������" || week == "������"){
			if(begin>=9&&begin<12){
				if(end<=12){
					fee = (end-begin)*40;
				}
				else if(end>12){
					fee = (end-12)*50 + (12-begin)*40;
				}
				else{
					System.out.println("end time wrong");
				}
			}
			else if(begin>=12&&begin<18){
				if(end<=18){
					fee = (end-begin)*50;
				}
				else if(end>18){
					fee = (end-18)*60 + (18-begin)*50;
				}
				else{
					System.out.println("end time wrong");
				}
			}
			else if(begin>=18){
				if(end<=22){
					fee = (end-begin)*60;
				}				
				else{
					System.out.println("end time wrong");
				}
			}
			else{
				System.out.println("begin time wrong");
			}
		}
		else{
			if(begin>=9&&begin<12){
				if(end<=12){
					fee = (end-begin)*30;
				}
				else if(end>12){
					fee = (end-12)*50 + (12-begin)*30;
				}
				else{
					System.out.println("end time wrong");
				}
			}
			else if(begin>=12&&begin<18){
				if(end<=18){
					fee = (end-begin)*50;
				}
				else if(end>18&&end<=20){
					fee = (end-18)*80 + (18-begin)*50;
				}
				else{
					System.out.println("end time wrong");
				}
			}
			else if(begin>=18&&begin<=20){
				if(end<=20){
					fee = (end-begin)*80;
				}
				else if(end>20&&end<=22){
					fee = (end-20)*60 + (20-begin)*80;
				}
				else{
					System.out.println("end time wrong");
				}
			}
			else{
				System.out.println("begin time wrong");
			}
		}
		return fee;
	}
	
	/**

	* ���������� ���س�����

	*@param num
	*�ܼ�����ʼʱ�䡢����ʱ��
	         
	*@return g_num
	*����
	
	**/
	public int getGroundNum(int num){
		int g_num = 0;
		int t = num/6;
		int x = num%6;
		if(t == 0){
			if(x>=4){
				g_num = 1;
			}
		}
		else if(t == 1){
			g_num = 2;
		}
		else if(t<=3){
			if(x>=4){
				g_num = t+1;
			}
			else{
				g_num = t;
			}
		}
		else{
			g_num = t;
		}
		return g_num;
	}

}