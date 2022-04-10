package jpabook.baekjoon.baek0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 */
public class BJ_11725 {
    static int n;
    static int[][] vertex;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        vertex = new int[n+1][n+1];
        visited = new boolean[n+1];
        arr = new int[n+1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            vertex[x][y] = 1;
            vertex[y][x] = 1;
        }

        find(1);

        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void find(int root) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < vertex.length; i++) {
            if(vertex[root][i]==1&&!visited[i]){
                visited[i] = true;
                arr[i] = root;
                stack.add(i);
            }
        }

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            find(pop);
        }
    }
}
