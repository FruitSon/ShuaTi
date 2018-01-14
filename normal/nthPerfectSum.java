package normal;

import java.util.PriorityQueue;

public class nthPerfectSum {
    public static void main(String[] args) {
    	long start=System.currentTimeMillis();   //获取开始时间  
    	int time = 500;
    	
        for(int i = 1; i< time; i++)
          helper(i);
        long end=System.currentTimeMillis(); //获取结束时间  
    	System.out.println("程序运行时间： "+(end-start)+"ms");   
    	
    	start=System.currentTimeMillis();   //获取开始时间  
        for(int i = 1; i< time; i++)
        	helper2(i);
        end=System.currentTimeMillis(); //获取结束时间  
    	System.out.println("程序运行时间： "+(end-start)+"ms");   
        
    	for(int i = 1; i< time; i++)
           helper3(i);
        end=System.currentTimeMillis(); //获取结束时间  
       	System.out.println("程序运行时间： "+(end-start)+"ms");   
    }

    public static int helper2(int n) {
            final PriorityQueue<TwoValueMinPQItem> pq = new PriorityQueue<>();
            for (int i = 0; i < n/2+1; i++) {
                pq.add(new TwoValueMinPQItem((i + 1) * (i + 1) + 1, 1));
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                final TwoValueMinPQItem item = pq.poll();
                ans = item.getValue();
                int index = item.getIndex();
                int base = ans - index * index;
                item.setValue(ans + 2 * index + 1);
                item.setIndex(index + 1);
                if (item.getValue() <= base * 2) {
                    pq.add(item);
                }
            }
            return ans;
        }
        public static class TwoValueMinPQItem implements Comparable<TwoValueMinPQItem>{
        	private int value,index;
        	TwoValueMinPQItem(int val, int idx){
        		value =val;
        		index = idx;
        	}
        	public int getValue(){
        		return value;
        	}
        	public void setValue(int val){
        		 value = val;
        	}
         	public int getIndex(){
        		return index;
        	}
        	public void setIndex(int idx){
        		 index = idx;
        	}
        	
        	@Override
        	public int compareTo(TwoValueMinPQItem o){
        		return this.getValue()-o.getValue();
        	}
        }

        public static class Num{
        	int val, cur;
        	Num(int a, int b){
        		val = a;
        		cur = b;
        	}
    		public int compareTo(Num e2) {
    			return this.getRes() - e2.getRes();
    		}
    		public int getRes(){
    			return map[this.val]+ map[this.cur];
//    			return this.val * this.val + this.cur * this.cur;
    		}
        }
        static int[] map;
        public static int helper(int k){
        	map = new int[k/2+2];
        	PriorityQueue<Num> pq = new PriorityQueue<>(1, (e1, e2) -> { return e1.compareTo(e2);});
        	for(int i = 1; i <= k/2+1; i++){
        		map[i] = i*i;
         		pq.add(new Num(i,1));
        	}

        	int cnt = 0;
        	while(cnt < k){
        		Num tmp = pq.peek();
        		cnt++;
        		if(cnt == k) return tmp.getRes();
        		tmp.cur = tmp.cur+1;
        		if(tmp.cur>tmp.val)
        			pq.poll();
        	}
        	
            return -1;
        }

        public static int helper3(int n) { 
        		long[] squres = new long[n + 1]; 
        	    squres[0] = 0; 
        	    for (int i = 1; i < squres.length; i++) { 
        	        squres[i] = squres[i - 1] + 2 * i - 1; 
        	    } 
        	 
        	    long res = 2; 
        	    int index = 1; 
        	    int[] idx = new int[n]; 
        	 
        	    idx[0] = 1; 
        	    while(index < n) { 
        	        int temp = Integer.MAX_VALUE; 
        	        int tempIndex = 0; 
        	        for (int i = 0; i < n; i++) { 
        	            if(idx[i] > i) continue; 
        	            int tempsum = (int) (squres[i+1] + squres[idx[i] + 1]); 
        	            if( tempsum == temp) { 
        	                idx[i]++; 
        	            }else if(tempsum < temp) { 
        	                tempIndex = i; 
        	                temp = tempsum; 
        	            } 
        	        } 
        	 
        	        res = (long) temp; 
        	        idx[tempIndex]++; 
        	        index++; 
        	    } 
        	 
        	    return (int) res; 
        	}
}
