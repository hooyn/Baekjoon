package baek0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 촌수계산
 */
public class BJ_2644 {
    static int n;
    static int a;
    static int b;
    static int[][] arr;
    static boolean[] visited;
    static int result = -1;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            arr[parent][child] = 1;
            arr[child][parent] = 1;
        }
        find(a, b, 0);

        System.out.println(result);
    }

    private static void find(int a, int b, int depth) {
        if(a==b){
            result = depth;
            return;
        }
        
        visited[a] = true;
        for (int i = 0; i < arr.length; i++) {

        }
    }


}
