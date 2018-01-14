package normal;

import java.util.HashSet;
import java.util.Set;

/*
Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Note:

L, R will be integers L <= R in the range [1, 10^6].
R - L will be at most 10000.
*/
public class LC767Prime_Number_of_Set_Bits {
	//Method 1: 暴力解 数每一个数的set of bits 看是不是素数
    public int countPrimeSetBits(int L, int R) {
        if(L>R) return 0;
        int res = 0;
        int maxBit = getMaxBit(R);
        
        Set<Integer> primes = findAllPrimes(maxBit);
        //其实对int来说 小于32的素数只有 2，3，5，7，11，13，17，19，23，29，31
        //Set<Integer> prime =  new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));

         for(int num = L; num <= R; num++){
             int tmp = getSetBitCount(num);
             if(primes.contains(tmp))  res++;
         }
        return res;
    }
    private Set<Integer> findAllPrimes(int n){
    	boolean[] checker = new boolean[n+1];
         for(int i = 2 ;i <= n; i++){
             if(checker[i]==false){
                 int m = 2;
                 while(m*i<=n){
                	 checker[i*(m++)] = true;
                 }
             }
         }

         Set<Integer> res = new HashSet<>();
         for(int i  = 2; i <= n ; i++){
             if(!checker[i]) res.add(i);
         }

         return res;
     }
	private int getMaxBit(int n){
        return n==0?0:(getMaxBit(n>>1)+1);
    }   
    private int getSetBitCount(int n){
        int cnt = 0;
        while(n!=0){
            cnt += n & 1;
            n = n>>1;
        }
        return cnt;
    } 
}
