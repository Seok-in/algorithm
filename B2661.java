import java.util.Scanner;

public class B2661 {
    static int N;
    static int code=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        String str = "1";
        getStr(str);
    }

    // 좋은 수열인지 판단해야함.
    public static boolean func1(String str){
        //1의자리부터 절반의 부분수열 비교
        for(int i=1;i<=str.length()/2;i++){
            if(str.substring(str.length()-i).equals(str.substring(str.length()-2*i,str.length()-i))){
                return false;
            }
        }
        return true;
    }
    public static void getStr(String str){
        if(code==1){
            return;
        }
        if(!func1(str)){
            return;
        }
        if(str.length()==N){
            System.out.println(str);
            code=1;
            return;
        }

        getStr(str+"1");
        getStr(str+"2");
        getStr(str+"3");
    }
}