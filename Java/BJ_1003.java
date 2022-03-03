import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 * 이 문제는 처음에 풀었을 때 시간초과 오류가 나서
 * 규칙을 찾아보니
 * x: 1,0,1,1,2,3... 이런식으로 2부터 피보나치 수의 수열처럼 반복 되었고
 * y: 0,1,1,2,3,5... 이런식으로 2부터 피보나치 수의 수열처럼 반복 되었다.
 * 그래서 아래와 같이 풀었다.
 */
public class BJ_1003_sol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        long[] fibonacci_x = new long[50]; //피보나치 x 배열 선언
        long[] fibonacci_y = new long[50]; //피보나치 y 배열 선언

        fibonacci_x[0] = 1;
        fibonacci_x[1] = 0;

        fibonacci_y[0] = 0;
        fibonacci_y[1] = 1;

        int max = 0;
        int[] list = new int[testcase]; //n을 저장하기 위한 배열 선언

        for (int i = 0; i < testcase; i++) { //n중에서 제일 큰 수를 구하기 위해 입력을 받을 때마다 비교한다.
            int n = Integer.parseInt(br.readLine());
            list[i] = n;
            if(n>max) max = n; //제일 큰 수를 max에 저장한다.
        }

        if(max>1){ //max가 1보다 클 때만 아래 로직을 실행시킨다.
            for (int i = 2; i <= max; i++) { //제일 큰 수 까지 반복문을 돌려서 값들을 배열에 저장한다.
                fibonacci_x[i] = fibonacci_x[i-1] + fibonacci_x[i-2];
                fibonacci_y[i] = fibonacci_y[i-1] + fibonacci_y[i-2];
            }
        }

        for (int i : list) { //그리고 list에 저장된 n을 출력하면 된다.
            System.out.println(fibonacci_x[i] + " " + fibonacci_y[i]);
        }
    }
}
