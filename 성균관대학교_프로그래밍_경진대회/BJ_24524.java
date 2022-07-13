import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 아름다운 문자열 골드 5
 */
public class BJ_24524 {
    static String S;
    static String T;
    static int result = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        // S의 문자열을 중복으로 사용하면 안되므로 체크하기 위한 boolean배열 선언
        visited = new boolean[S.length()];

        dfs(0, "");

        System.out.println(result);
    }

    private static void dfs(int idx, String makeStr) {
        if(makeStr.length()==T.length()){
            //String은 객체이기 때문에 equals를 꼭 사용해야합니다.
            if(T.equals(makeStr)){
                result++;
            }
            return;
        }

        for (int i = idx; i < S.length(); i++) {
            if(S.charAt(i)==T.charAt(makeStr.length())){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(i+1, makeStr+S.charAt(i));
                }
            }
        }
    }
}
