package com.zhandev.bigNumber;

import java.math.BigDecimal;
import java.util.*;

class JavaBigDecimal {

	
/*

sample input:
  
9
-100
50
0
56.6
90
0.12
.12
02.34
000.000
 	
output:

90
56.6
50
02.34
0.12
.12
0
000.000
-100
 	
*/

	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();

		// Write your code here
		Arrays.sort(s, 0, n, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				BigDecimal a1 = new BigDecimal(o1);
				BigDecimal a2 = new BigDecimal(o2);
				return a2.compareTo(a1);
			}

		});

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}
}