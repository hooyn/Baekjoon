import java.io.*;
import java.util.Stack;

public class BJ_1406_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        //stack은 LIFO구조로 나중에 들어간 데이터가 먼저 나온다.
        Stack<String> stack_left = new Stack<String>(); //stack 왼쪽
        Stack<String> stack_right = new Stack<String>(); //stack 오른쪽


        String[] arr = input.split(""); //split을 사용해서 arr에 초기 문자 저장
        for(String s : arr) {
            //처음 커서는 문장의 맨 뒤에서 시작하므로 왼쪽 스택에 문자를 초기화한다.
            stack_left.push(s);
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch(c) {
                case 'L':
                    if(!stack_left.isEmpty())
                        stack_right.push(stack_left.pop());

                    break;
                case 'D':
                    if(!stack_right.isEmpty())
                        stack_left.push(stack_right.pop());

                    break;
                case 'B':
                    if(!stack_left.isEmpty()) {
                        stack_left.pop();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    stack_left.push(String.valueOf(t));

                    break;
                default:
                    break;
            }
        }

        while(!stack_left.isEmpty())
            stack_right.push(stack_left.pop());
            //왼쪽 스택에 있는 데이터를 오른쪽 스택으로 이동시키고
            //오른쪽 스택 출력하기
        while(!stack_right.isEmpty())
            bw.write(stack_right.pop());

        bw.flush();
        bw.close();
    }
}
