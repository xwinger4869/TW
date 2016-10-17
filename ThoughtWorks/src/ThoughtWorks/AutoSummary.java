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
		String date = foreSubString(input," ");
		input = backSubString(input," ");
		int begin = Integer.parseInt(foreSubString(input,":"));
		input = backSubString(input,"~");
		int end = Integer.parseInt(foreSubString(input,":"));
		input = backSubString(input," ");
		int num = Integer.parseInt(input);	
		
		//���ú����������
		String week = getWeek(date);  
		int fee = getFee(week,begin,end);
		int gnum = getGroundNum(num);
		int income = gnum>0?num*30:0;	
		f_income += income;
		int payment = fee*gnum;
		f_payment += payment;
		int profit = income-payment;
		f_profit += profit;
		
		//��������ַ���
		String final_profit = profit>0?("+"+profit):(""+profit);
		String final_begin = begin<10?("0"+begin):(""+begin);
		String output = date+" "+final_begin+":00~"+end+":00 +"+income+" -"+payment+" "+final_profit;
		
		return output; 
	}
	
	/**

	* ����ָ���֮ǰ���ִ�

	*@param input
	*�����ַ���
	*@param str
	*�ָ���
	         
	*@return output
	*����ַ���

	
	**/
	
	public String foreSubString(String input,String str){
		return input.substring(0, input.indexOf(str));		
	}
	
	/**

	* ����ָ���֮����ִ�

	*@param input
	*�����ַ���
	*@param str
	*�ָ���
	         
	*@return output
	*����ַ���

	
	**/
	
	public String backSubString(String input,String str){
		return input.substring(input.indexOf(str)+1,input.length());		
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

	* �����ܼ���ʱ�䣬 ���ص�λʱ�����

	*@param week
	*�ܼ�
	*@param time
	*ʱ��
	         
	*@return singele_fee
	*��λʱ�����
	
	**/
	public int singleFee(String week,int time){
		int single_fee = 0;
		int week_change = 10;
		if(week == "������" || week == "������"){
			week_change = 0;
		}
		if(time>=9&&time<12){
			single_fee = 40 - week_change;
		}
		else if(time>=12&&time<18){
			single_fee = 50;
		}
		else if(time>=18&&time<20){
			single_fee = 60 + week_change*2;
		}
		else if(time>=20&&time<=22){
			single_fee = 60;
		}
		else{
			System.out.println("time wrong");
		}
		return single_fee;
	}
	
	/**

	* �����ܼ�������ʱ�䣬 ���ؽ���ʱ��֮ǰ��һ���ֽ��

	*@param week
	*�ܼ�
	*@param time
	*ʱ��
	         
	*@return inter
	*����ʱ��֮ǰ��һ���ֽ��
	
	**/
	
	public int getInter(String week,int time){
		int inter = 12;
		if(week == "������" || week == "������"){
			if(time>=18){
				inter = 18;
			}
		}
		else{
			if(time>=20){
				inter = 20;
			}
			else if(time>=18){
				inter = 18;
			}
		}
		return inter;
	}
	
	/**

	* �����ܼ�����ʼʱ�䡢����ʱ�䣬 ���ط���

	*@param week
	*�ܼ�
	*@param begin
	*��ʼʱ��
	*@param end
	*����ʱ��
	         
	*@return fee
	*����
	
	**/
	
	public int getFee(String week,int begin,int end){
		int fee = 0;
		int begin_fee = singleFee(week,begin);
		int end_fee = singleFee(week,end);
		if(end_fee == begin_fee){
			fee = (end-begin)*begin_fee;
		}
		else{
			int inter = getInter(week,end);
			fee = (end-inter)*end_fee + (inter-begin)*begin_fee;
			
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
