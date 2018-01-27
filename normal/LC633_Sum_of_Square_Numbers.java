package normal;
/*Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: 3
Output: False
*/

// Method 1: use isPerfectSquare()
// - Time: O(nlgn)

// Method 2: 2 pointer
// - Time: O(n)
public class LC633_Sum_of_Square_Numbers {
	// Method 1
	public boolean judgeSquareSum1(int c) {  
        for(int i = 0; i <= Math.sqrt(c); i++){
            if(isPerfectSquare(c-i*i)) return true;
        }
        return false;
    }
    
    private boolean isPerfectSquare(int num) {
        if(num == 0) return true;
        int l = 0, r = num;
        while(l <= r){
            int m = l + (r-l)/2;
            if(m == num * 1.0/m) return true;
            else if(m > num * 1.0/m) r = m - 1;
            else l = m + 1;
         }
        return false;
    }
    
    // Method 2: 2 pt
    public boolean judgeSquareSum2(int c) {  
        int l = 0, r = (int)Math.floor(Math.sqrt(c));
        int sum = r*r;
        while(sum != c  && l <= r){
            if(sum < c) l ++;
            else r--;
            sum = l*l+ r*r;
        }
        return sum == c;
    }
}
