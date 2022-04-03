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
        } //연결된 간선들을 arr에 반영
        find();
        System.out.println(result);
    }

    private static void find() {
        for (int i = 0; i < arr.length; i++) { //모든 간선을 탐색하기 위해 0부터 arr.length까지
            if(!visited[i]){
                Stack<Integer> stack = new Stack<>(); //탐색할 간선을 저장하기 위한 스택
                visited[i] = true; //탐색한 노드는 true로 변경
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i][j]==1){ //만약 노드와 연결된 다르 노드가 발견되면 스택에 모두 저장
                        if(!visited[j]){
                            stack.add(j);
                        }
                    }
                }
                while (!stack.isEmpty()){ //스택을 탐색하면서 간선으로 연결된 다른 노드들 모두 탐색
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
                //모든 연결된 노드를 탐색했으므로 result++
                //만약 탐색하지 않은 노드가 있다면 다시 탐색
                result++;
            }
        }
    }
}
