package normal;

public class LC231_Power_Of_Two {
	public boolean isPowerOfTwo(int n) {

//	//Method1: recusion
//  if(n==1) return true;
//  else if((n&1)==1 || n==0) return false;
//  return isPowerOfTwo(n>>1);
		
		//Method 2: 
//		return n>0 && (n & (n-1))==0;
		
		//Method 3: 类似BIT
		return n>0 && (n&(-n))==n;
	}
}
