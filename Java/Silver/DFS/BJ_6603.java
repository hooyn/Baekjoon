import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로또
 */
public class BJ_6603 {
    static boolean[] visited;
    static StringBuffer sb;
    static int[] store;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if(input.equals("0")){
                break;
            } else {
                StringTokenizer st = new StringTokenizer(input);
                int size = Integer.parseInt(st.nextToken());
                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                } //로또 번호 저장

                visited = new boolean[size];
                store = new int[6];
                find(arr, 0, 0);
                System.out.println();
            }
        }
    }

    private static void find(int[] arr, int depth, int start) {
        if(depth==6){
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            find(arr, depth+1, i+1);
            visited[i] = false;
        }
    }
}
