import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 */
public class BJ_11725 {
    static int n;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        } //List배열 초기화

        arr = new int[n+1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        find(1);

        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void find(int root) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list[root].size(); i++) {
            Integer child = list[root].get(i);

            if(!visited[child]){
                arr[child] = root;
                visited[child] = true;
                stack.add(child);
            }

        }

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            find(pop);
        }
    }
}
