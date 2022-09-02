import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14891 {
    static int arr1[] = new int[8];
    static int arr2[] = new int[8];
    static int arr3[] = new int[8];
    static int arr4[] = new int[8];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1[] = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }
        String str2[] = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }
        String str3[] = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            arr3[i] = Integer.parseInt(str3[i]);
        }
        String str4[] = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            arr4[i] = Integer.parseInt(str4[i]);
        }
        int K = Integer.parseInt(br.readLine());
        for (int j = 0; j < K; j++) {
            String str[] = br.readLine().split(" ");
            move(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        int result = 0;
        if (arr1[0] != 0) {
            result += 1;
        }
        if (arr2[0] != 0) {
            result += 2;
        }
        if (arr3[0] != 0) {
            result += 4;
        }
        if (arr4[0] != 0) {
            result += 8;
        }
        System.out.println(result);
    }

    // 움직이는 함수
    public static void move(int n, int d) {
        if (n == 1) {
            // 시계방향 회전시
            if (d == 1) {
                // 극이 다르다면
                if (arr1[2] != arr2[6]) {
                    // 극이 다르다면
                    if (arr2[2] != arr3[6]) {
                        if (arr3[2] != arr4[6]) {
                            reverseRotate(arr4);
                        }
                        rotate(arr3);
                    }
                    reverseRotate(arr2);
                }
                rotate(arr1);
            } else if (d == -1) {
                // 극이 다르다면
                if (arr1[2] != arr2[6]) {
                    // 극이 다르다면
                    if (arr2[2] != arr3[6]) {
                        if (arr3[2] != arr4[6]) {
                            rotate(arr4);
                        }
                        reverseRotate(arr3);
                    }
                    rotate(arr2);
                }
                reverseRotate(arr1);
            }
        } else if (n == 2) {
            // 시계방향회전시
            if (d == 1) {
                if (arr1[2] != arr2[6]) {
                    reverseRotate(arr1);
                }
                if (arr2[2] != arr3[6]) {
                    if (arr3[2] != arr4[6]) {
                        rotate(arr4);
                    }
                    reverseRotate(arr3);
                }
                rotate(arr2);
            } else if (d == -1) {
                if (arr1[2] != arr2[6]) {
                    rotate(arr1);
                }
                if (arr2[2] != arr3[6]) {
                    if (arr3[2] != arr4[6]) {
                        reverseRotate(arr4);
                    }
                    rotate(arr3);
                }
                reverseRotate(arr2);

            }
        } else if (n == 3) {
            // 시계방향회전시
            if (d == 1) {
                if (arr2[2] != arr3[6]) {
                    if (arr2[6] != arr1[2]) {
                        rotate(arr1);
                    }
                    reverseRotate(arr2);
                }
                if (arr3[2] != arr4[6]) {
                    reverseRotate(arr4);
                }
                rotate(arr3);
            } else if (d == -1) {
                if (arr2[2] != arr3[6]) {
                    if (arr2[6] != arr1[2]) {
                        reverseRotate(arr1);
                    }
                    rotate(arr2);
                }
                if (arr3[2] != arr4[6]) {
                    rotate(arr4);
                }
                reverseRotate(arr3);
            }
        } else if (n == 4) {
            if (d == 1) {
                if (arr4[6] != arr3[2]) {
                    if (arr3[6] != arr2[2]) {
                        if (arr2[6] != arr1[2]) {
                            reverseRotate(arr1);
                        }
                        rotate(arr2);
                    }
                    reverseRotate(arr3);
                }
                rotate(arr4);
            } else if (d == -1) {
                if (arr4[6] != arr3[2]) {
                    if (arr3[6] != arr2[2]) {
                        if (arr2[6] != arr1[2]) {
                            rotate(arr1);
                        }
                        reverseRotate(arr2);
                    }
                    rotate(arr3);
                }
                reverseRotate(arr4);
            }
        }
    }

    // 시계방향 회전 함수
    public static void rotate(int arr[]) {
        int temp1 = arr[0];
        int temp2;
        for (int i = 0; i < 8; i++) {
            if (i == 7) {
                arr[0] = temp1;
                break;
            }
            temp2 = arr[i + 1];
            arr[i + 1] = temp1;
            temp1 = temp2;
        }
    }

    // 시계 반대방향 회전함수
    public static void reverseRotate(int arr[]) {
        int temp1 = arr[7];
        int temp2;
        for (int i = 7; i >= 0; i--) {
            if (i == 0) {
                arr[7] = temp1;
                break;
            }
            temp2 = arr[i - 1];
            arr[i - 1] = temp1;
            temp1 = temp2;
        }
    }
}
