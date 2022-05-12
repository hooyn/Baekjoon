import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 외계인의 기타 연주
 */
public class BJ_2841 {
    static int N;
    static int P;
    static int[][] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int[] idx = new int[7]; //각 줄의 값이 있는 인덱스를 저장하기 위한 배열
        arr = new int[7][N]; //각 줄의 누르고 있는 플랫을 배열로 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(idx[n]==0){
                arr[n][idx[n]] = p;
                idx[n]++;
                count++;
            } else {
                while (true) {
                    int x = arr[n][idx[n]-1]; //전에 들어가 있던 수
                    if(x==p){
                        break;
                    } else if(x<p){
                        arr[n][idx[n]] = p;
                        idx[n]++;
                        count++;
                        break;
                    } else if(x>p){
                        idx[n]--;
                        count++;
                    }

                    if(idx[n]==0){
                        arr[n][idx[n]] = p;
                        idx[n]++;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
