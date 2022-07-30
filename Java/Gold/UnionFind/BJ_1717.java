package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

/**
 * 집합의 표현
 */
public class BJ_1717 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //숫자의 개수
        m = Integer.parseInt(st.nextToken()); //입력 개수

        //부모값 초기화
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int io = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(io==1){
                if(check(x, y)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                union(x, y);
            }
        }

    }

    static int find(int x){
        if(x == parent[x]){
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    static boolean check(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return true;
        } else return false;
    }
}
