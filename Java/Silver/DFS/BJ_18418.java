package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 감시 피하기
 */
public class BJ_18418 {
    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int n = 0;
    static char[][] map;
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S'){
                    list.add(new Node(i, j));
                }
            }
        }

        dfs(0);

        System.out.println("NO");
    }

    private static void dfs(int depth) {
        if(depth == 3){
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='X'){
                    map[i][j] = 'O';
                    dfs(depth+1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static void bfs() {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        Queue<Node> queue = new LinkedList<>();
        char[][] copyMap = new char[n][n];
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(copyMap[i][j] == 'T'){
                    queue.add(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int r = now.r;
            int c = now.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                while(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(copyMap[nr][nc] != 'O'){
                        check[nr][nc] = true;
                        nr += dr[i];
                        nc += dc[i];
                    } else {
                        break;
                    }
                }
            }
        }
        if (catchStudent(check)) {
            System.out.println("YES");
            System.exit(0);
        }
    }

    private static boolean catchStudent(boolean[][] check) {
        for (Node node : list) {
            if(check[node.r][node.c] == true){
                return false;
            }
        }
        return true;
    }
}
