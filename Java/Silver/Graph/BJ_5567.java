package jpabook.baekjoon.baek0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 결혼식
 */
public class BJ_5567 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //동기의 수
        int m = Integer.parseInt(br.readLine()); //리스트 수

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        find(1);
        System.out.println(result);
    }

    private static void find(int depth) {
        visited[1] = true;
        for (int i = 1; i < arr.length; i++) {
            if(arr[depth][i] == 1 && !visited[i]){
                visited[i] = true;
                stack.add(i);
                result++;
            }
        } //상근이의 친구 조회해서 스택에 저장

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            for (int i = 1; i < arr.length; i++) {
                if(arr[pop][i] == 1 && !visited[i]){
                    visited[i] = true;
                    result++;
                }
            } //친구의 친구 조회
        }
    }
}
