import java.io.*;

public class B14890 {
    static int arr[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int L = Integer.parseInt(str[1]);
        visited = new boolean[N][N];
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str2[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str2[j]);
            }
        }
        int result = 0;
        // 가로줄 부터 탐색
        for (int i = 0; i < N; i++) {
            result += 1;
            int start = arr[i][0];
            int count = 1;
            for (int j = 1; j < N; j++) {
                // 같으면 계속 진행
                if (arr[i][j] == start) {
                    count += 1;
                    continue;
                }

                // 차이가 1이면 경사로 놓을 수 있는지 판단
                else if (Math.abs(arr[i][j] - start) == 1) {
                    // 다음에 오는 게 더 큰 경우
                    if (arr[i][j] > start) {
                        // 경사로 길이를 감당할 수 있으면 설치
                        if (count >= L) {
                            start = arr[i][j];
                            count = 1;
                        } else {
//                            System.out.println("가로" + i);
                            result -= 1;
                            break;
                        }

                    }
                    // 다음에 오는게 더 작아지는 경우
                    else if (arr[i][j] < start) {
                        int possible = 0;
                        for (int t = 1; t < L; t++) {
                            if(j+t >= N){
                                possible = 1;
                                break;
                            }
                            else if (arr[i][j + t] != arr[i][j]) {
                                possible = 1;
                            }
                        }
                        start = arr[i][j];
                        count = 0;
                        j += (L - 1);
                        if (possible == 1) {
//                            System.out.println("가로" + i);
                            result -= 1;
                            break;
                        }
                    }
                } else {
//                    System.out.println("가로" + i);
                    result -= 1;
                    break;
                }
            }
        }
        // 세로줄 부터 탐색
        for (int i = 0; i < N; i++) {
            result += 1;
            int start = arr[0][i];
            int count = 1;
            for (int j = 1; j < N; j++) {
                // 같으면 계속 진행
                if (arr[j][i] == start) {
                    count += 1;
                    continue;
                }

                // 차이가 1이면 경사로 놓을 수 있는지 판단
                else if (Math.abs(arr[j][i] - start) == 1) {
                    // 다음에 오는 게 더 큰 경우
                    if (arr[j][i] > start) {
                        // 경사로 길이를 감당할 수 있으면 설치
                        if (count >= L) {
                            start = arr[j][i];
                            count = 1;
                        } else {
//                            System.out.println("세로" + i);
                            result -= 1;
                            break;
                        }

                    }
                    // 다음에 오는게 더 작아지는 경우
                    else if (arr[j][i] < start) {
                        int possible = 0;
                        for (int t = 1; t < L; t++) {
                            if(j+t >= N){
                                possible = 1;
                                break;
                            }

                            else if (arr[j + t][i] != arr[j][i]) {
                                possible = 1;
                            }
                        }
                        start = arr[j][i];
                        count = 0;
                        j += (L - 1);
                        if (possible == 1) {
//                            System.out.println("세로" + i);
                            result -= 1;
                            break;
                        }
                    }
                } else {
//                    System.out.println("세로" + i);
                    result -= 1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
