package normal;
/*Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/

//Method 1: 逐位check
//Method 2: use built-in function and String.equals() (slow)
//Method 3: count the number of Capital characters
public class LC520_Detect_Capital {
    //Method 1: 逐位check
    public boolean detectCapitalUse1(String word) {
        if(word.length()==1) return true;
        return isCapital(word.charAt(0))?(allUpperCase(word)||firstCapital(word)):allLowerCase(word);
    }
    
    private boolean allLowerCase(String str){
        for(char ch : str.toCharArray()){
            if(isCapital(ch)) return false;
        }
        return true;
    }
    
    private boolean allUpperCase(String str){
         for(char ch : str.toCharArray()){
            if(!isCapital(ch)) return false;
        }
        return true;
    }
    
    private boolean firstCapital(String str){
        for(char ch : str.substring(1).toCharArray()){
            if(isCapital(ch)) return false;
        }
        return true;
    }
    
    private boolean isCapital(char ch){
        return ch >= 'A' && ch <= 'Z';
    }
    
    //Method 2: use built-in function and String.equals()
    //slow
     public boolean detectCapitalUse2(String A) {
       if(A.equals(A.toUpperCase())){
         return true;
       }else if(A.toLowerCase().equals(A)){
         return true;
       }else if(A.substring(1).toLowerCase().equals(A.substring(1))){
         return true;
       }else 
         return false;
     }
    
    //Method 3: count the number of Capital characters
     public boolean detectCapitalUse3(String word) {
         int cnt = 0;
         for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
         return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
     }
}
