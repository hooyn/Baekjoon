import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 안정적인 문자열 실버 1
 */
public class BJ_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        while(true){
            String input = br.readLine();
            if(input.contains("-")) break; // -가 처음에 등장하면 break;
            else {
                int result = 0;

                Stack<Character> stack = new Stack<>();

                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);

                    if(ch=='{'){ //그냥 추가
                        stack.add(ch);
                    } else {
                        if(stack.isEmpty()){ //방향을 반대로 하여 추가
                            result++;
                            stack.add('{');
                        } else { //커플완성
                            stack.pop();
                        }
                    }
                }

                result += (stack.size()/2); //남은 stack 처리
                System.out.println((idx++) + ". " + result);
                continue;
            }
        }
    }
}
