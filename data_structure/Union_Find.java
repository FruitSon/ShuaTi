package data_structure;

public class Union_Find {
	int[] arr;
	public Union_Find(int n){
		arr = new int[n];
	}
	
	public void initialize(){
		for(int i = 0; i < arr.length; i++) arr[i] = i;
	}
	
	public int find(int[] arr, int i){
		while(arr[i]!=i) i = arr[i];
		return i;
	}

	public void union(int[] arr, int parent, int child){
		if(find(arr,parent)==find(arr,child)) return;
		else{
			//optimization here: path compress
			arr[find(arr,arr[child])]= find(arr,arr[parent]);
		}
		return;
	}
	
	public boolean sameParent(int[] arr, int c1, int c2){
		return find(arr,c1)==find(arr,c2);
	}
}
