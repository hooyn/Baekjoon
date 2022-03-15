import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 순열
 */
public class BJ_10974 {
    static StringBuffer sb = new StringBuffer();
    static int[] arr;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        find(0);
        System.out.println(sb);
    }

    private static void find(int cnt) {
        if(cnt==n){ //depth가 n일 때 arr에 있는 데이터 sb에 넣기
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                //방문하지 않은 노드일 때 visited true처리
                //arr에 데이터 저장
                //dfs 재귀호출 find()
                //그리고 중복을 다른 경우의 수도 구해야하기 때문에 
                // visited=false로 해주고 
                //for문 진행한다.
                visited[i] = true;
                arr[cnt] = i + 1;
                find(cnt+1);
                visited[i]=false;
            }
        }
    }
}
