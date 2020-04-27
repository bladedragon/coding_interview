package companys_questions.sanliuling;

import java.util.Scanner;

public class Solution {
    private static long distance = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna1 = scanner.nextLine();
        String dna2 = scanner.nextLine();
        if(dna1.length() <1 || dna1.length() != dna2.length()){
            System.out.println(0);
            return;
        }
        match(dna1,dna2,0,0,0,false);
        System.out.println(distance);
    }

    public static  void match(String s1,String s2,int i,int j,long dist,boolean isMatch){
        if(i == s1.length() || j == s2.length()){
            if(isMatch){
                dist++;
            }
            distance = Math.min(distance,dist);
            return;
        }
        if(s1.charAt(i) == s2.charAt(j)){
            match(s1,s2,i+1,j+1,dist,isMatch);
        }else{
            if(isMatch){
                match(s1,s2,i+1,j+1,dist+1,false);
            }else {
                match(s1, s2, i + 1, j + 1, dist, true);
                match(s1, s2, i + 1, j + 1, dist+1, false);
            }
        }
    }
}
