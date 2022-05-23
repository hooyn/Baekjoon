import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 3
 */
public class BJ_16935 {
    static int n;
    static int m;
    static int r;
    static int[][] arr;
    static int[][] temp;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());
        r = pi(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = pi(st.nextToken());
            }
        }

        /*--------------------입력 --------------------*/

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int command = pi(st.nextToken());

            switch (command){
                case 1:
                    num01();
                    break;
                case 2:
                    num02();
                    break;
                case 3:
                    num03();
                    break;
                case 4:
                    num04();
                    break;
                case 5:
                    num05();
                    break;
                case 6:
                    num06();
                    break;
            }
        }

        printArr(arr);
    }

    static void num01(){ //상하 반전
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                 temp[n-i-1][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void num02(){ //좌우 반전
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][m-j-1] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void num03(){ //우측 90도 회전
        temp = new int[m][n];

        int c = n-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][c] = arr[i][j];
            }
            c--;
        }

        int t = n;
        n = m;
        m = t;

        arr = temp;
    }

    static void num04(){ //좌측 90도 회전
        temp = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[m-j-1][i] = arr[i][j];
            }
        }

        int t = n;
        n = m;
        m = t;

        arr = temp;
    }

    static void num05(){ //4개 부분 나눠서 우측방향으로 회전
        temp = new int[n][m];

        int nn = n/2;
        int mm = m/2;

        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < mm; j++) {
                 temp[i][mm+j] = arr[i][j];
            }
        }

        for (int i = 0; i < nn; i++) {
            for (int j = mm; j < m; j++) {
                temp[nn][j] = arr[i][j];
            }
        }

        for (int i = nn; i < n; i++) {
            int c = 0;
            for (int j = mm; j < m; j++,c++) {
                temp[i][c] = arr[i][j];
            }
        }

        int row = 0;
        for (int i = nn; i < n; i++,row++) {
            for (int j = 0; j < mm; j++) {
                temp[row][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void num06(){ //4개 부분 나눠서 좌측방향으로 회전
        temp = new int[n][m];

        int nn = n/2;
        int mm = m/2;

        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < mm; j++) {
                temp[nn+i][j] = arr[i][j];
            }
        }

        for (int i = nn; i < n; i++) {
            for (int j = 0; j < mm; j++) {
                temp[i][mm+j] = arr[i][j];
            }
        }

        int row = 0;
        for (int i = nn; i < n; i++,row++) {
            for (int j = mm; j < m; j++) {
                temp[row][j] = arr[i][j];
            }
        }

        for (int i = 0; i < nn; i++) {
            int c = 0;
            for (int j = mm; j < m; j++,c++) {
                temp[i][c] = arr[i][j];
            }
        }

        arr = temp;
    }

    private static void printArr(int[][] temp) {
        for (int[] ints : temp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
