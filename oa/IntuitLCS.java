package oa;

import java.util.LinkedList;
import java.util.List;

public class IntuitLCS {
    public static void main(String[] args) {
        String[] u1 = {"3234.html", "xys.html", "7hsaa.html"};
        String[] u2 = {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
        LCS(u1,u2);
    }
        
    public static void LCS(String[] u1, String[] u2){
        int n = u1.length, m = u2.length; 
        List<String> temp = new LinkedList<>();
        List<String> res = new LinkedList<>();
        for(int i = 1; i<n;i++){
            for(int j = 1; j<m; j++){
                if(u1[i].equals(u2[j])){
                 temp.add(u1[i]);
                 if(res.size()<temp.size()) res = temp;
                }
                
            }
        }
        
        for(String str:res){
            System.out.println(str);
        }
        return ;
        
    }
       
}
