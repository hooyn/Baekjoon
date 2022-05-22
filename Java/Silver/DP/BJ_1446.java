import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 지름길
 */
public class BJ_1446 {
    static int pi(String s){return Integer.parseInt(s);}
    static int[] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = pi(st.nextToken());
        int d = pi(st.nextToken());

        arr = new int[n][3];
        dp = new int[d+1];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = pi(st.nextToken());
            arr[i][1] = pi(st.nextToken());
            arr[i][2] = pi(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() { //배열 값 내림차순으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o1[1];
                }

                return o1[0] - o2[0];
            }
        });

        for (int[] ints : arr) {
            System.out.print(ints[0] + " ");
            System.out.print(ints[1] + " ");
            System.out.print(ints[2] + " ");
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            int len = arr[i][2];

            if(end>d){ //만약 고속도로 거리를 넘어가면 continue;
                continue;
            } else if((end-start)<=len ){ //실제 고속도로 길이보다 크면 continue;
                continue;
            } else {
                if(dp[end]>dp[start]+len){ //비교를 해서 값이 작으면
                    int x = dp[start]+len;
                    for (int j = end; j <= d; j++) {
                        dp[j] = x;
                        x++;
                    }
                }
            }
        }

        System.out.println(dp[d]);
    }
}
