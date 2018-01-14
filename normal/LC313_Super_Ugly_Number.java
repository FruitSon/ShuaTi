package normal;

import java.util.PriorityQueue;

public class LC313_Super_Ugly_Number {
		public static void main(String[] args) {
	    	long start,end;
	    	int[] testcase = {1,2,3,4,5,6,7,8,9,10};
	    	int[] primes = {2,3,5};
	    	for(int i : testcase){
	    		start = System.currentTimeMillis();
	    		int res = nthSuperUglyNumber1(i, primes);
	    		end = System.currentTimeMillis();
	    		System.out.format("time:%dms,k:%d, res:%d\n",(end-start),i,res);
	    	}
		}
		
//		(1) 1x2,  2x2, 2x2, 3x2, 3x2, 4x2, 5x2...
//		(2) 1x3,  1x3, 2x3, 2x3, 2x3, 3x3, 3x3...
//		(3) 1x5,  1x5, 1x5, 1x5, 2x5, 2x5, 2x5...
		
		//额外class记录base,prime和目前所指的idx + pq
		//O(NlgK)
		public static class Num {
			int base, factor, idx;
			Num(int a, int b, int c){
				base = a;
				factor = b;
				idx = c;
			}
			
    		public int compareTo(Num e2) {
    			return this.base - e2.base;
    		}
		}
		
	    public static int nthSuperUglyNumber1(int n, int[] primes) {
	    	int[] res = new int[n+1];
	    	PriorityQueue<Num> candidates = new PriorityQueue<>((e1, e2) -> { return e1.compareTo(e2);});

	    	if(n==1) return 1;
	    	res[0] = 1;
	    	for(int prime : primes)
	    		candidates.add(new Num(prime,prime,0));

	    	for(int i = 1; i<n ; i++){
	    		Num tmp = candidates.poll();
	    		
	    		res[i] = tmp.base;
	    		tmp.idx = tmp.idx++;

	    		tmp.base = res[tmp.idx] * tmp.factor;
	    		candidates.add(tmp);
	    		
	    		while(candidates.peek().base==res[i]){
	    			Num t = candidates.poll();
	    			t.base = res[t.idx] * t.factor;
		    		t.idx ++;
		    		candidates.add(t);
	    		}
	    	}

	    	return res[n-1];
	    }
	    
	    //array 实现
	    //O(kN)
	    public static int nthSuperUglyNumber2(int n, int[] primes) {
	        int[] res = new int[n+1];
	        int[] idx = new int[primes.length];
	        
	        if(n==1) return 1;
	        res[0] = 1;
	        
	        for(int i = 1; i<n ; i++){
	            int tmp = Integer.MAX_VALUE;
	            //在当前的list里找最小的num
	            //res[idx[k]]*primes[k] 就是现在正在考察的数
	            for(int k = 0; k < primes.length; k++)
	                tmp = Math.min(tmp,res[idx[k]]*primes[k]);
	            res[i] = tmp;
	            
	            //skip duplicated num
	            for(int k = 0; k < primes.length; k++){
	                if(res[i]==res[idx[k]]*primes[k]){
	                    idx[k]++;
	                }
	            }
	        }
	        return res[n-1];
	    }
	}


