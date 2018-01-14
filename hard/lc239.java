package hard;
import java.util.PriorityQueue;

public class lc239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
		maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},1);
		maxSlidingWindow(new int[]{1,3,-1},2);

	}

	static class Pair{
        int val, idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        
        @Override
        public boolean equals(Object o){
        	if(this==o) return true;
        	if(o==null || this.getClass()!= o.getClass()) return false;
        	Pair tmp = (Pair) o;
        	return tmp.val==this.val && tmp.idx==this.idx;
        }
    }
	
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (o1,o2)->-o1.val+o2.val);
        int[] res = new int[nums.length-k+1];
        System.out.println("\n!!!!!");

        for(int i = 0; i<k-1; i++){
            pq.add(new Pair(nums[i],i));
        }
        
        for(int i = k-1; i<nums.length; i++){
            pq.add(new Pair(nums[i],i));
            //size = k;
            if(pq.peek().val<nums[i]){
                res[i-k+1] = nums[i];
            }else{
                res[i-k+1] = pq.peek().val;
            }
            Pair tar = new Pair(nums[i-k+1],i-k+1);
            pq.remove(new Pair(nums[i-k+1],i-k+1)); 
        }
        for(int i:res) System.out.print(i+" ");
        return res;
    }
}
