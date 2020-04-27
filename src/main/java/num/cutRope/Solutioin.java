package num.cutRope;

public class Solutioin {
    public int cutRope(int n){
        if(n<2){
            return 0;
        }
        if( n == 2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int x = n%3;
        int y = n/3;
        if(x ==1){
            return (int) (2*2*Math.pow(3,y-1));
        }else if(x == 0){
            return (int) Math.pow(3,y);
        }else{
            return (int) (2*Math.pow(3,y));
        }
    }
}
