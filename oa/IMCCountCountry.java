package oa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//再看union find
public class IMCCountCountry {

	public static void main(String[] args) {
		List<int[][]> input = new LinkedList<>();
		input.add(new int[][]{{5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}});
		input.add(new int[][]{{1,1,1}});
		input.add(new int[][]{{1}});
		input.add(new int[][]{{1,2}});
		input.add(new int[][]{{1,1,1},{1,2,1}});
		input.add(new int[][]{{1,2,1},{1,1,1}}); //wrong with initial solution
		for(int[][] in : input){
			System.out.format("there are %d countries. \n", helper(in));
		}
	}
	

	public static int helper(int[][] A) {
	        int h = A.length, w = A[0].length, cnt = 0;
	        int[] rec = new int[h*w];
	        for(int i = 0; i<h; i++){
	            for(int j = 0; j<w; j++){
	                cnt = checkConnect(rec,A,h,w,i,j,cnt);
	            }
	        }
	        int res = -1;
	        for(int i = 0; i<w*h; i++) res = Math.max(res,rec[i]);
	        return res;
	    }
	    
	    private static int checkConnect(int[] rec, int[][]A, int h, int w, int i, int j, int cnt){
	        int idx = i*w+j;
	        int idx_left = i*w+j-1, idx_right = i*w+j+1, idx_up = (i-1)*w+j, idx_down = (i+1)*w+j;
	        boolean a1=false,a2=false,a3=false,a4=false,b1=false,b2=false,b3=false,b4=false;
	        if(i-1>=0 && A[i][j] == A[i-1][j]){
	            a1 = true;
	            if(rec[idx]!=0){b4=true; rec[idx_up]= rec[idx];}
	            else if(rec[idx_up]!=0){b1 = true;rec[idx] = rec[idx_up];}
	        }
	        if(i+1<h && A[i][j] == A[i+1][j]){
	            a2 = true;
	            if(rec[idx]!=0){b4=true; rec[idx_down]= rec[idx];}
	            else if(rec[idx_down]!=0){b2=true; rec[idx] = rec[idx_down];}
	        }
	        if(j-1>=0 && A[i][j] == A[i][j-1]){
	            a3 = true;
	            if(rec[idx]!=0){b4=true; rec[idx_left]= rec[idx];}
	            else if(rec[idx_left]!=0){b3=true; rec[idx] = rec[idx_left];}
	        }
	        if(j+1<w && A[i][j] == A[i][j+1]){
	            a4 = true;
	            if(rec[idx]!=0){b4=true; rec[idx_right]= rec[idx];}
	            else if(rec[idx_right]!=0){b4=true; rec[idx] = rec[idx_right];}
	        }
	        if(!(b1||b2||b3||b4)){
	            cnt++;
	            rec[idx] = cnt;
	        }
	        if(a1) rec[idx_up] = rec[idx];
	        if(a2) rec[idx_down] = rec[idx];
	        if(a3) rec[idx_left] = rec[idx];
	        if(a4) rec[idx_right] = rec[idx];
	        return cnt;
	    }
	    
	}
	
//	public static int helper(int[][] in){
//		int cnt = 0;
//		int h = in.length, w = in[0].length;
//		int[] rec = new int[h*w];
//		Arrays.fill(rec, -1);
//		for(int i = 0; i<h; i++){
//			for(int j=0; j<w; j++){
//				cnt = connect(rec,in,i,j,cnt);
//				
//			}
//		}
//		//for(int i:rec) System.out.print(i+" ");
//		return cnt;
//	}
//	
//	private static int connect(int[] rec, int[][] in, int i, int j, int cnt){
//		boolean b1 = false,b2 = false,b3 = false,b4 = false;
//		boolean a1 = false,a2 = false,a3 = false,a4 = false;
//
//		int row = in[0].length;
//		if(i-1>=0 && in[i][j]==in[i-1][j]){
//			a1 = true;
//			if(rec[(i-1)*row+j]!=-1){
//				rec[i*row+j] = rec[(i-1)*row+j];
//				b1 = true;
//			}
//		}
//		if(i+1<in.length && in[i][j]==in[i+1][j]){
//			a2 = true;
//			if(rec[(i+1)*row+j]!=-1){
//				rec[i*row+j] = rec[(i+1)*row+j];
//				b2 = true;
//			}
//		}
//		if(j-1>=0 && in[i][j]==in[i][j-1]){
//			a3 = true;
//			if(rec[i*row+j-1]!=-1){
//				rec[i*row+j] = rec[i*row+j-1];
//				b3 = true;
//			}
//		}
//		if(j+1<in[0].length && in[i][j]==in[i][j+1]){
//			a4 = true;
//			if(rec[i*row+j+1]!=-1){
//				rec[i*row+j] = rec[i*row+j+1];
//				b4 = true;
//			}
//		}
//		if(!(b1||b2||b3||b4)){
//			rec[i*row+j] = cnt;
//			cnt++;
//		}
//		if(a1) rec[(i-1)*row+j]=rec[i*row+j];
//		if(a2) rec[(i+1)*row+j]=rec[i*row+j];
//		if(a3) rec[i*row+j-1]=rec[i*row+j];
//		if(a4) rec[i*row+j+1]=rec[i*row+j];
//		//System.out.println(cnt);
//		return cnt;
//	}

