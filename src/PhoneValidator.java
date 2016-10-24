import java.util.*;

public class PhoneValidator
{
	public static void main(String[] args)
	{
		boolean eflag;
		String phone;
		int tempCrc=0;
		int crc=-1;
		char[] phonemas=new char[0];
		do{
			eflag = false;
			System.out.println("Enter your phone:");

			Scanner inphone=new Scanner(System.in);
			phone = inphone.next();
			for (int i=0;i < phone.length();i++)
			{
				if (phone.charAt(i) == '+' && i == 0)
				{
					continue;
				}
				if (phone.charAt(i) - 48 > 9 || phone.charAt(i) - 48 < 0)
				{
					System.out.println("please use only digits");
					eflag = true;
					break;
				}
			}
			if (phone.startsWith("+380") && phone.length() == 13 && !eflag)
			{
				phonemas = new char[13];
				phonemas = phone.toCharArray();
				break;
			}
			else if (phone.startsWith("380") && phone.length() == 12 && !eflag)
			{
				phonemas = new char[12];
				phonemas = phone.toCharArray();
				break;
			}
			else if (phone.startsWith("80") && phone.length() == 11 && !eflag)
			{
				phonemas = new char[11];
				phonemas = phone.toCharArray();
				break;
			}
			else if (phone.startsWith("0") && phone.length() == 10 && !eflag)
			{
				phonemas = new char[10];
				phonemas = phone.toCharArray();
				break;
			}
			else
			{System.out.println("Wrong number, pls write again:");
				eflag = true;
			}
		}while(eflag);
		
		for (int i=0;i < phonemas.length;i++)
		{
			if (phone.charAt(i) == '+')
			{
				continue;
			}
			tempCrc = tempCrc + phonemas[i] - 48;
		}
		
		
		while (crc == -1)
		{

			if (tempCrc < 10)
			{
				crc = tempCrc;
			}
			else
			{
				char[] tempchar=new char[2];
				tempchar = String.valueOf(tempCrc).toCharArray();
				tempCrc = tempchar[0] - 48 + tempchar[1] - 48;
				
			}
		}
		switch (crc)
		{
			case 0:
				System.out.println("Validation number of phone is: " + "zero");
				break;
			case 1:
				System.out.println("Validation number of phone is: " + "one");
				break;
			case 3:
				System.out.println("Validation number of phone is: " + "three");
				break;
			case 4:
				System.out.println("Validation number of phone is: " + "four");
				break;
			default:
				System.out.println("Validation number of phone is: " + crc);

		}




	}
}
