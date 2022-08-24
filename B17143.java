import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B17143 {
    static int dx[]={0,-1,1,0,0};
    static int dy[]={0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int R = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        int M = Integer.parseInt(str[2]);

        int arr[][] = new int[R+1][C+1];
        ArrayList<Shark> list = new ArrayList<>();
        ArrayList<Shark> newList = new ArrayList<>();
        int result =0;
        for(int i=0;i<M;i++){
            String str2[] = br.readLine().split(" ");
            // 상어가 있는 곳은 1
            int r = Integer.parseInt(str2[0]);
            int c = Integer.parseInt(str2[1]);
            int s = Integer.parseInt(str2[2]);
            int d = Integer.parseInt(str2[3]);
            int z = Integer.parseInt(str2[4]);
            int time = 0;
            arr[r][c] = i+1;

            list.add(new Shark(r, c, s, d, z, time));
        }

        // 1. 낚시꾼 이동 후 상어 찾아서 잡음
        for(int k=1;k<=C;k++){
            for(int i=1;i<=R;i++){
                if(arr[i][k]!=0){
                    result += list.get(arr[i][k]-1).z;
                    list.remove(arr[i][k]-1);
                    arr[i][k] = 0;
                    break;
                }
            }
            if(k==C){
                break;
            }
            // 2. 상어 이동하기 전 기존 위치들은 다 0으로 만들기
            for(int j=0;j<list.size();j++){
                int r = list.get(j).r;
                int c = list.get(j).c;
                arr[r][c] = 0;
            }
            // 모든 상어의 이동
            for(int t=0;t<list.size();t++){
                // 상어 기존 위치
                int r = list.get(t).r;
                int c = list.get(t).c;
                int s = list.get(t).s;
                int d = list.get(t).d;
                int z = list.get(t).z;
                int time = list.get(t).time;
                // 상어 자신의 속력만큼 이동
                for(int m = 1;m<=s;m++){
                    int nr = r + dx[d];
                    int nc = c + dy[d];
                    // 이동할 다음 위치가 범위를 넘어가면 방향 전환
                    if(nr < 1 || nr > R || nc < 1 || nc > C){
                        if(d%2==0){
                            d-=1;
                        }
                        else{
                            d+=1;
                        }
                        nr = r + dx[d];
                        nc = c + dy[d];
                    }
                    r = nr;
                    c = nc;
                }
                // 현재있는 자리에 상어가 있으면
                if(arr[r][c]!=0){
                    // 지금 상어가 더 크면
                    if(list.get(arr[r][c]-1).z < z){
                        newList.add(arr[r][c]-1,new Shark(r, c, s, d, z, time +1));
                    }
                }
                // 자리에 없으면 상어추가
                else{
                    newList.add(new Shark(r, c, s, d, z, time +1));
                    arr[r][c]= newList.size();
                }
            }
            //다음 상어로 움직이기
            list.clear();
            list.addAll(newList);
            newList.clear();
        }
        System.out.println(result);
    }
    //

    public static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;
        int time;
        public Shark(int r, int c, int s, int d, int z,int time){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.time = time;
        }
    }
}
