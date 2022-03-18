package jpabook.baekjoon.baek0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과 M (6)
 */
public class BJ_15655 {
    static int n;
    static int m;
    static int[] num_arr;
    static int[] arr;
    static boolean[] visited;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num_arr = new int[n];
        arr = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_arr.length; i++) {
            num_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num_arr);

        find(0, 0);
        System.out.println(sb);
    }

    static void find(int depth, int start){
        if(depth==m){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = num_arr[i];
                find(depth+1, i+1);
                visited[i] = false;
            }

        }
    }
}
