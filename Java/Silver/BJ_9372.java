import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 상근이의 여행
 */

public class BJ_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken()); // 2 <= n <= 1,000
            int airplane = Integer.parseInt(st.nextToken()); // 1 <= m <= 10,000

            boolean[][] list = new boolean[airplane+1][airplane+1];

            for (int j = 0; j < airplane; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;

                list[a][b] = true;
                list[b][a] = true;
            }

            System.out.println(country-1);
        }
    }
}

//트리에서 만약 3개의 노드가 있는 경우 간선은 최소 2개가 필요
//결국 노드-1을 구하는 문제
