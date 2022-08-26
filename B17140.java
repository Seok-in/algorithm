import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class B17140 {
    static int arr[][];
    static int count[];
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int r = Integer.parseInt(str[0])-1;
        int c = Integer.parseInt(str[1])-1;
        int k = Integer.parseInt(str[2]);
        arr = new int[3][3];
        // 배열 입력받음
        for(int i=0;i<3;i++){
            String str2[] = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(str2[j]);
            }
        }

        int time = -1;
        while(true){
            time ++;
            if(time > 100){
                time = -1;
                break;
            }

            if(r<arr.length && c <arr[0].length){
                if(arr[r][c]==k)
                    break;
            }

            int row = arr.length;
            int col = arr[0].length;

            int temp[][] = new int[101][101];

            // R연산
            if(row >= col){
                int max = 0;

                for(int i=0;i<row;i++){
                    count = new int[101];

                    for(int j=0;j<col;j++){
                        if(arr[i][j]==0)
                            continue;
                        count[arr[i][j]]++;
                    }

                    list = new ArrayList<>();
                    for(int j = 1; j<count.length;j++){
                        if(count[j] !=0){
                            list.add(new Node(j, count[j]));
                        }
                    }

                    Collections.sort(list);

                    int z = 0;
                    for(int j=0;j<list.size();j++){
                        temp[i][z] = list.get(j).value;
                        temp[i][z+1] = list.get(j).num;
                        z+=2;
                    }

                    if(max < list.size()*2) max = list.size()*2;
                }
                if(max > 100) max = 100;
                arr = new int[row][max];

                for(int i=0;i<arr.length;i++){
                    for (int j=0;j<arr[i].length;j++){
                        arr[i][j] = temp[i][j];
                    }
                }
            }
            else {
                int max = 0;
                for (int i = 0; i < col; i++) {
                    count = new int[101];
                    for (int j = 0; j < row; j++) {
                        if (arr[j][i] == 0) continue;
                        int n = arr[j][i];
                        count[n]++;
                    }
                    list = new ArrayList<>();
                    for (int j = 1; j < count.length; j++) {
                        if (count[j] != 0) {
                            list.add(new Node(j, count[j]));
                        }
                    }

                    Collections.sort(list);

                    int z = 0;
                    for (int j = 0; j < list.size(); j++) {
                        temp[i][z] = list.get(j).value;
                        temp[i][z + 1] = list.get(j).num;
                        z += 2;
                    }

                    if (max < list.size() * 2) max = list.size() * 2;
                }
                if (max > 100) max = 100;
                arr = new int[max][col];

                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = temp[i][j];
                    }
                }
            }
        }
        System.out.println(time);


    }


    public static class Node implements Comparable<Node>{
        int value;
        int num;

        public Node(int value, int num){
            this.num = num;
            this.value=value;
        }

        @Override
        public int compareTo(Node o){
            if(this.num == o.num){
                return this.value < o.value ? -1 : 1;
            }
            return this.num < o.num ? -1:1;
        }
    }
}
