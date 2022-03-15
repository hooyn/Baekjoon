import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 수열
 */
public class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        StringBuffer sb = new StringBuffer();

        while (n --> 0) { // n번을 반복한다.
            int num = Integer.parseInt(br.readLine());

            if(num > cnt) {
                for(int i = cnt + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');	// + 를 저장한다.
                }
                cnt = num;
            } else if(stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
