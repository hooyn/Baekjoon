package beak0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회전 초밥
 */
public class BJ_2531 {
    static int n;
    static int d;
    static int k;
    static int c;
    static int[] arr;
    static int[] eated;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //접시의 수
        d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        arr = new int[n];
        eated = new int[d+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //0부터 k개수 만큼 먹었을 때 몇가지 종류인지.
        int count = 0;
        for (int i = 0; i < k; i++) {
            if(eated[arr[i]]==0){
                count++;
            }

            eated[arr[i]]++;
        }

        int max = count;
        for (int i = 1; i < n; i++) {

            if(max<=count){
                if(eated[c] == 0){
                    max = count+1;
                } else {
                    max = count;
                }
            }

            int end = (i+k-1)%n;
            if(eated[arr[end]]==0){
                count++;
            }
            eated[arr[end]]++;

            eated[arr[i-1]]--;
            if(eated[arr[i-1]] == 0){
                count--;
            }

        }

        System.out.println(max);
    }
}
