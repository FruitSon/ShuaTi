package normal;

/*Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
*/

// Method 1: brute force
// Time: O(n)

// ✿ Method 2: binary search
// Time: O(lgn)

// ✿ Method 3: Newton's method. 
//	- for f(x) = 0, propose a guess value at first, then calculate the next guess value by Xn+1 = Xn - f(Xn)/f'(Xn)
//  - in this problem. f(res) = res^2 - X = 0  => RESn+1 = (RESn + X/RESn)/2.0;
// Time: O(lgn)

public class LC069_Sqrt_x {
	//brute force
    public int mySqrt1(int x) {
        //type long
        long res = 0;
        while(res*res<=x) {
            res++;
        }
        return (int)res - 1;
    }
    
    //binary search 
    public int mySqrt2(int x) {
        int l = 1, r = x;
        while(l<=r){
            int m = l + (r-l)/2;
            if(m  <= x / m) l = m+1;
            else r = m-1;
        }
        return r;
    }
    
    //Newton's method    
    public int mySqrt3(int x) {
        double res = x;
        double delta = 0.01;
        while(res * res - x > delta){
            res = (res + x/res)/2.0;
        }
        return (int)res;
    }
}
