package normal;
/*Given a positive integer, output its complement number. 
 * The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.

Example 1:
Input: 5
Output: 2
Explanation: 
The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: 1
Output: 0
Explanation: 
The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/

//Method 1: 逐位相加
//-	逐位 flip, sum all 2^i where num[i] == 0

//Method 2: bit manipulation
//	- num取反:~num
//	- (Integer.highestOneBit(num)<<1-1) 获取n位的 11...1   (假设num有n位)
//		- 这个函数的作用是取i 这个数的二进制形式最左边的最高一位且高位后面全部补零，最后返回int型 
//		- Integer.highestOneBit(5) = Integer.highestOneBit(101) = 4
//	- 相与& (把取反之后前置的1111....1都置0)
public class LC476_Number_Complement {
	//Method 1: 逐位相加
    public int findComplement1(int num) {
        int res = 0, p = 1;
        while(num!=0){
            res += (num&1)==0?p:0;
            p <<= 1;
            num >>= 1;
        }
        return res;
    }
    
	//Method 2: bit manipulation
	public int findComplement2(int num) {
	    return ~num & ((Integer.highestOneBit(num)<<1) -1   );
	}
}
