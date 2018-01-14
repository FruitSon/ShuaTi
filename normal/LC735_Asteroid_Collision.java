package normal;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, 
and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. 
If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.

Example 1:
Input: 
asteroids = [5, 10, -5]
Output: [5, 10]
Explanation: 
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:
Input: 
asteroids = [8, -8]
Output: []
Explanation: 
The 8 and -8 collide exploding each other.
Example 3:
Input: 
asteroids = [10, 2, -5]
Output: [10]
Explanation: 
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
Example 4:
Input: 
asteroids = [-2, -1, 1, 2]
Output: [-2, -1, 1, 2]
Explanation: 
The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.
Note:

The length of asteroids will be at most 10000.
Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class LC735_Asteroid_Collision {
	public int[] asteroidCollision(int[] asteroids) {
	    if(asteroids == null || asteroids.length <= 1) return asteroids;
	    Deque<Integer> stack = new ArrayDeque<Integer>();
	
	    for(int i = 0; i < asteroids.length; i++){
	        if(stack.size()==0 || !collisionHappen(stack.peek(), asteroids[i])){
	            stack.push(asteroids[i]);
	            continue;
	        }
	        collision(stack,asteroids[i]);            
	    }

	    return generateRes(stack);
	}
    
    private boolean collisionHappen(int i, int j){
        return !(i*j>0 || i<0 && j>0);
    }
    
    private int collisionJudge(int i, int j){
        return Math.abs(i)-Math.abs(j);
    }
    
    private void collision(Deque<Integer> stack, int cur){
        while( stack.size() >0 && collisionHappen(stack.peek(),cur)){
            int judge = collisionJudge(stack.peek(), cur);
            if(judge > 0) return;
            else if(judge<0) stack.pop();
            else{
                stack.pop();
                return;
            }
        }
        stack.push(cur);
        return;
    }
    
    private int[] generateRes(Deque<Integer> stack){
        if(stack.size()==0) return new int[0];
        int[] res = new int[stack.size()];
        int idx = stack.size()-1;
        while(idx>=0) res[idx--] = stack.pop();
        return res;
    }
}
