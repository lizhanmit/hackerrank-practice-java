package com.zhandev.strings;

import java.util.*;
import java.util.regex.*;

public class TagContentExtractor {
	
/*

sample input:

4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium

output:

Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush	
	
 */
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
			boolean matchFound = false;
			Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
			Matcher matcher = pattern.matcher(line);
			
			while (matcher.find()) {
				System.out.println(matcher.group(2));
				matchFound = true;
			}
			
			if (!matchFound) {
				System.out.println("None");
			}
			
			testCases--;
		}
	}
}
