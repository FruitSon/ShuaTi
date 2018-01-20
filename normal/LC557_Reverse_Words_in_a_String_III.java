package normal;

//Method 1: 2 pointer
//-	skip space 
//- find the start idx and end idx of each word
//- swap char in the char[]
//Time: O(n)
//Space: O(n)

//Method 2: StringBuilder + reverse()
//- split by space
//- reverse() each word and attach to the StringBuilder
//Time: O(n)
//Space: O(n)
public class LC557_Reverse_Words_in_a_String_III {
	//Method 1
	public String reverseWords(String s) {
	    if(s == null || s=="") return "";
	    char[] chars = s.toCharArray();
	    int pt1 = 0, pt2 = 0;
	    
	    while(pt1 < chars.length){
	    	//skip space and find the start idx and end idx of each word
	        if(chars[pt1]==' '){
	            while(pt1+1<chars.length && chars[pt1+1]==' ') pt1++;
	            pt1 = pt1+1;
	        }
	        pt2 = pt1;
	        while(pt2+1 <chars.length && chars[pt2+1] !=' ') pt2++;
	        
	        swapChar(chars,pt1,pt2);
	        pt1 = pt2+1;
	    }
	    return new String(chars);
	}
	
	private void swapChar(char[] chars, int pt1, int pt2){
	    if(pt1==pt2) return;
	    while(pt1 < pt2){
	        char tmp = chars[pt1];
	        chars[pt1] = chars[pt2];
	        chars[pt2] = tmp;
	        pt1++;pt2--;
	    }
	    return;
	}
	
    //Method 2   
    public String reverseWords2(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}
