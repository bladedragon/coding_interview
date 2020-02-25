package array.multipy;

public class Solution {

    /**
     * 暴力
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i =0;i<A.length;i++){
            int flag = A[i];
            B[i] = 1;
            for(int j =0;j<A.length;j++){
                if(j != i){
                    B[i]*= A[j];
                }
            }
        }
        return B;

    }

    public int[] multiply2(int[] A) {

        int[] B = new int[A.length];
        int res = 1;
        for(int i=0;i<A.length;i++){
            B[i] = res;
            res *= A[i];
        }
        res= 1;
        for(int i=A.length-1;i>=0;i--){
            B[i] *= res;
            res *= A[i];

        }
        return B;

    }

}