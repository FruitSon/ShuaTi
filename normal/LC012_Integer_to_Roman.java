package normal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

//Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）。
//右加左减：
//	- 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
//	- 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
//	- 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
//	- 左减时不可跨越一个位值。 比如99写成XCIX
//	- 左减数字最多一位。
//	- 右加数字最多三位。比如14写成XIV

//Method 1
//subtract unit value from number continuously and check whether the current value can be represent in subtraction way
//5(1),10(2) - 1(0)
//50(3),100(4) -10(2)
//500(5), 1000(6) - 100(4)
//for (1),5,(10),50,(100),500,1000, the index of value which can be used for subtraction representation is (idx-1)/2*2;

//Method 2
//construct the string for all possible addends
//Combine the right string together  
public class LC012_Integer_to_Roman { 
	 //Method 1
	 public String intToRoman1(int num) {
	        StringBuilder sb = new StringBuilder();
	        int[] val = new int[]{1,5,10,50,100,500,1000};
	        char[] ch = new char[]{'I','V','X','L','C','D','M'};

	        int bit = 6;
	        while(num > 0 && bit >= 0 ){
	        	while(num >= val[bit]){
	        		num -= val[bit];
		        	sb.append(ch[bit]);
		        }
	        	int bit_p = (bit-1)/2*2;
	        	if( num > 0 && num/val[bit_p]*val[bit_p] + val[bit_p] == val[bit]){
		        		sb.append(ch[bit_p]); sb.append(ch[bit]);
		        		num = num + val[bit_p]-val[bit];
	        	}
	        	bit -- ;
	        }
	        return sb.toString();
	 }
	 
	 public String intToRoman2(int num) {
	         String M[] = {"", "M", "MM", "MMM"};
	         String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	         String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	         String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	         return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10]; 
	     }
}
