package net.kzn.onlineShopping.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DemoExample {

	public static void main(String args[]){
		
		
		Scanner sc=new Scanner(System.in);		
		String words=sc.next();
		char[] characters=words.toCharArray();
		HashMap<Character,Integer> charMap=new HashMap<Character,Integer>();
		for(Character ch:characters)
		{
			if(charMap.containsKey(ch))
			{
				charMap.put(ch,charMap.get(ch)+1);
			}
			else
			{
				charMap.put(ch,1);
			}
		}
		
		Set<Map.Entry<Character,Integer>> entrySet= charMap.entrySet();
		for(Map.Entry<Character,Integer> entry:entrySet)
		{
			if(entry.getValue()>1)
			{
			System.out.println("Key :"+entry.getKey()+"---"+"Value :"+entry.getValue());
			}
		}
		
		
		
		

		/*int count,a=0,b=0,c=1;
		Scanner sc=new Scanner(System.in);		
		 count=sc.nextInt();
		for(int i=1;i<=count;i++){
			a=b;
			b=c;
			c=a+b;
			System.out.print(a+"   ");
		}
*/
	}

	}