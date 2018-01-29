package normal;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class LC096_Unique_Binary_Search_Trees {

	//Method 1: dp
	//Time: O(n^2)
	//Space: O(n)
    public int numTrees(int n) {
        if(n<2) return n;
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        cnt[1] = 1;
        for(int i = 2; i <= n; i++){
            int tmp = 0;
            for(int j = 0; j < i; j++){
                tmp += cnt[j] * cnt[i-1-j];
            }
            cnt[i] = tmp;
        }
        return cnt[n];
    }
}
