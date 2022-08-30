import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제
 */
public class BJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()){
            if(queue.size()==1){
                sb.append(queue.poll());
                break;
            }

            for(int i = 0; i < K - 1; i++) {
                int val = queue.poll();
                queue.offer(val);
            }
            Integer out = queue.poll();
            sb.append(out+", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
