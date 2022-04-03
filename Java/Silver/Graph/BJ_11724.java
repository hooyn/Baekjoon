package jpabook.baekjoon.baek0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 연결 요소의 개수
 */
public class BJ_11724 {
    static int n;
    static int m;
    static int result = 0;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        find();
        System.out.println(result);
    }

    private static void find() {
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                Stack<Integer> stack = new Stack<>();
                visited[i] = true;
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i][j]==1){
                        if(!visited[j]){
                            stack.add(j);
                        }
                    }
                }
                while (!stack.isEmpty()){
                    Integer pop = stack.pop();
                    if(!visited[pop]){
                        visited[pop] = true;
                        for (int j = 0; j < arr.length; j++) {
                            if(arr[pop][j]==1){
                                if(!visited[j]){
                                    stack.add(j);
                                }
                            }
                        }
                    }
                }
                result++;
            }
        }
    }
}
