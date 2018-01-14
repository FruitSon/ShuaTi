package normal;
public class LC264_Ugly_Number_II {
//	(1) 1x2,  2x2, 2x2, 3x2, 3x2, 4x2, 5x2...
//	(2) 1x3,  1x3, 2x3, 2x3, 2x3, 3x3, 3x3...
//	(3) 1x5,  1x5, 1x5, 1x5, 2x5, 2x5, 2x5...
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int[] idx = {0,0,0};
        int[] factor = {2,3,5};
        int[] base = {2,3,5};
        for(int i = 1; i < n ; i++){
        	int min = Math.min(Math.min(base[0], base[1]),base[2]);
        	res[i]  = min;
        	for(int j = 0; j < 3; j++){
        		if(base[j]== min){
        			idx[j]=idx[j]+1;
        			base[j]  = factor[j]* (res[idx[j]]);
                }
        	}
        }
        
        return res[n-1];
    }
    
}


