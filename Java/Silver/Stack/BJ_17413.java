import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 단어 뒤집기 2
 * BJ_17413.java
 */

public class BJ_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        String result = ""; //결과 값

        boolean check = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch=='<'){
                check = true; //reverse를 안하기 위해 boolean변수 true로 변경
                result = stack_pop(stack, result); //<시작하면 stack을 확인해서 만약 비어있지 않다면 stack내용 result에 저장
            } else if(ch=='>'){
                result += '>'; //result에 >를 저장하고
                check = false; //check값 false로 변경한 후에 i값 증가하고 아래 로직 실행x
                continue;
            }

            if(check){ //check값이 true라면 그냥 result에 저장
                result += ch;
            } else if(!check && ch==' '){
                result = stack_pop(stack, result); //만약 check값이 false인데 공백이면 stack에 있는 내용 result에 저장
                result += ' ';
            } else {
                stack.add(ch); //만약 check값이 false라면 stack에 저장
            }
        }

        if(!stack.isEmpty()){ //만약 반복문을 다 돌았는데 stack에 내용이 있다면 pop해주기!
            result = stack_pop(stack, result);
        }

        System.out.println(result);
    }

    private static String stack_pop(Stack<Character> stack, String result) {
        while (!stack.isEmpty()){ //스택에 데이터가 있다면
            Character chh = stack.pop(); //하나씩 빼서
            result += chh; //result에 저장
        }
        return result;
    }
}
