package normal;

/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Returns: True

Example 2:
Input: 14
Returns: False
*/

// Method 1: Binary search
// Time: O(lgn)
public class LC367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num, m = 0;
        while(l <= r){
            m = l + (r-l)/2;
            if(m == num * 1.0/m) return true;
            else if(m > num * 1.0/m) r = m - 1;
            else l = m + 1;
         }
        return false;
    }
}
