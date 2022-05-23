import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 나무 탈출
 */
public class BJ_15900 {
    static int pi(String s){return Integer.parseInt(s);}
    static List<Integer> list[];
    static boolean[] visited;
    static int n;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());

        list = new List[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l1 = pi(st.nextToken());
            int l2 = pi(st.nextToken());

            list[l1].add(l2);
            list[l2].add(l1);
        }

        int level = 0;
        find(1, level);

        if(count%2==0){ //짝수이면 No 홀수이면 Yes
            System.out.println("No");
        } else System.out.println("Yes");
    }

    private static void find(int node, int level) {
        boolean check = false;
        visited[node] = true;

        /**
         * 메모리 초과 오류
         * 해결방법: List<Integer> list[] = new List[n+1]
         *  - 리스트 배열을 생성하여 노드의 자식 값만 저장
         *  - boolean 배열을 사용하면 0~n까지 계속 반복을 하지만
         *  - 리스트 배열을 사용하면 반복을 줄여준다.
         */
        for (int i = 0; i < list[node].size(); i++) {
            Integer num = list[node].get(i);
            if(!visited[num]){
                find(num, level+1);
                check = true;
            }
        }

        if(!check){ //자식 노드가 없다면 check는 false이므로 level을 count에 저장시켜준다.
            count += level;
        }
    }
}
