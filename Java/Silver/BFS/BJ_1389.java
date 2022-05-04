import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 케빈 베이컨의 6단계 법칙
 */
public class BJ_1389 {
    static int n;
    static int m;
    static boolean[][] relation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        relation = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            relation[x1][x2] = true;
            relation[x2][x1] = true;
        }

        int people = 0;
        int st_count = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) { //사람들과의 모든 관계의 레벨을 count에 더하기
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                count += find(i, j);
            }
            if(st_count>count){ //관계 레벨의 합이 최소가 되는 people 저장
                st_count = count;
                people = i;
            }
        }

        System.out.println(people);
    }

    private static int find(int i, int j) {
        int level = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int k = 1; k <= n; k++) {
            if(relation[i][k]==true){
                queue.add(k);
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Integer poll = queue.poll();
                if(poll==j){ //찾고자 하는 사람이라면 level return
                    return level;
                }
                else {
                    for (int l = 1; l <= n; l++) {
                        if(relation[poll][l]==true){ //찾으려는 사람이 아니라면 연관된 사람 queue에 저장
                            queue.add(l);
                        }
                    }
                }
            }
            level++; //size만큼 사람을 탐색했다면 레벨 증가
        }

        return level;
    }
}
