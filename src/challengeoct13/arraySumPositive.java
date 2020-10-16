package challengeoct13;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minStart' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

	public static long minStart(List<Integer> arr) {
	    // Write your code here
	    int sum =0;
	    long numberToadd = 0;
	    for (int num : arr) {
	        if (num<=0) {
	            if (sum + num <= 0) {
	                long prevNumtoAdd = numberToadd;
	               numberToadd = Math.abs(num + sum) +1 ;
	               numberToadd = prevNumtoAdd + numberToadd;
	               sum = 1;
	            } else {
	              sum = sum + num;  
	            }
	        } else {
	           sum = sum + num;  
	        }
	        
	    }
	    
	return numberToadd;
	    }

}

public class arraySumPositive {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList();
//		list.add(10);
		list.add(-5);
		list.add(4);
		list.add(-2);
		list.add(-3);
//		list.add(1);
//		list.add(-1);
//		list.add(-6);
//		list.add(-1);
//		list.add(0);
//		list.add(5);
		System.out.println(Result.minStart(list));
	}
}
