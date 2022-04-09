package jpabook.baekjoon.baek0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 차이를 최대로
 */
public class BJ_10819 {
    static int n;
    static int[] arr;
    static boolean visited[];
    static int[] store;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        store = new int[n];

        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0);
        System.out.println(max);
    }

    private static void find(int depth) {
        if(depth==n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(store[i] - store[i+1]);
            }
            if(sum>max) max = sum;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                store[depth] = arr[i];
                find(depth+1);
                visited[i] = false;
            }
        }
    }
}
