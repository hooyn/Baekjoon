import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 괄호
 * Stack구조 활용해서 문제 해결하기
 */
public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int input_size = input.length();

            char[] stack = new char[input_size];
            int stack_point = 0;

            for (int j = 0; j < input_size; j++) {
                char ch = input.charAt(j);
                if(stack_point==0){
                    stack[stack_point] = ch;
                    stack_point++;
                } else {
                    if(ch=='('){
                        stack[stack_point] = ch;
                        stack_point++;
                    } else if(ch==')'){
                        if(stack[stack_point-1] == '('){
                            stack_point--;
                        }
                    }
                }
            }
            if(stack_point==0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
