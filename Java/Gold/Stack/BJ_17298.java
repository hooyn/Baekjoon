import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오큰수 골드 4
 */
public class BJ_17298 {
    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //배열 선언과 StringTokenizer Setting
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 받은 데이터 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //스택 선언 후 arr 첫번째 원소 push
        Stack<Integer> stack = new Stack<>();

        //스택 배열을 활용하여 탐색
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        //스택에 남은 index -1로 설정
        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        //System.out.print 를 사용하니 시간초과가 나서 StringBuffer 사용
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
