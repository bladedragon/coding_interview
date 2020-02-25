package string.isNumberic;

public class Solution {

    boolean hasDot = false;
    public boolean  isNumbeeric(char[] str){
        if(str[0] == '+' || str[0] == '-'){
            return Numberic_r(str,1,0);
        }
        return Numberic_r(str,0,0);

    }

    public boolean Numberic_r(char[] str,int index,int state){

        if(index == str.length){
            return true;
        }
        if(state == 1){
            if(numberCheck(str[index])){
                return Numberic_r(str,index+1,state);
            }
        }else{
            if(numberCheck(str[index])){
                return Numberic_r(str,index+1,state);
            }else if(str[index] == '.' && !hasDot){
                hasDot = true;
                return Numberic_r(str,index+1,state);
            }else if((str[index] == 'E' || str[index] == 'e') && !hasDot){
                if(str[index+1] == '+' || str[index+1] =='-'){
                    return Numberic_r(str,index+2,1);
                }else{
                    return Numberic_r(str,index+1,1);
                }
            }
        }
        return false;
    }

    public boolean numberCheck(char s){
        int num = s - '0';
        if(num >= 0 && num <= 9){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println('9'-'0');
    }
}
