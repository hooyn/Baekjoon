import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 쇠막대기
 */
public class BJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char one = input.charAt(i);
            if(one=='('){
                char two = input.charAt(i+1);
                if(two==')'){
                    result += queue.size();
                    i++;
                } else {
                    queue.add('(');
                    result++;
                }
            } else if(one==')'){
                queue.remove();
            }
        }
        System.out.println(result);
    }
}
