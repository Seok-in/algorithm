import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2580 {
    static int[][] map;
    static int code=0;
    static ArrayList<Pos> posList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        map = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            String str[] = br.readLine().split(" ");
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j]==0){
                    posList.add(new Pos(i,j));
                }
            }
        }
//        System.out.println(posList.size());
        sdoku(0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(map[i][j]);
                if(j!=8){
                    System.out.print(" ");
                }
            }
            if(i!=8)
                System.out.println();
        }

    }
    public static class Pos{
        int xPos;
        int yPos;
        public Pos(int xPos, int yPos){
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }
    public static boolean ok(Pos pos, int value){

        for(int i=0;i<9;i++){
            // 가로 세로 판단하기
            if(value == map[pos.xPos][i]){
                if(i!=pos.yPos){
                    return false;
                }

            }
            if(value == map[i][pos.yPos]){
                if(i!=pos.xPos){
                    return false;
                }
            }
        }
        // 3*3 안 판단하기
        int x = pos.xPos/3;
        int y = pos.yPos/3;
        for(int i=(x*3);i<(x*3+3);i++){
            for(int j=(y*3);j<(y*3+3);j++){
                if(map[i][j] == value){
                    if(i!=pos.xPos || j!=pos.yPos){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void sdoku(int num){
        if(code == 1){
//            System.out.println("??");
            return;
        }
        if(num== posList.size()){
//            System.out.println("??");
            code = 1;
            return;
        }
        Pos pos = posList.get(num);
        for(int i=1;i<=9;i++){
            if(ok(pos,i)){
                map[pos.xPos][pos.yPos] = i;
//                System.out.println("POS NUM  "+num);
//                System.out.println("Pos" +(pos.xPos+1) +" "+ (pos.yPos+1)+"value:"+i);
                sdoku(num+1);
                if(code!=1){
                    map[pos.xPos][pos.yPos] = 0;
                }

            }
        }
    }
}

