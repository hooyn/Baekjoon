import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자 끼워넣기
 */
public class BJ_14888 {
    static int n;
    static int[] arr;
    static int[] operator;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        find(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void find(int num, int count) {
        if(count==n){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if(operator[i]!=0){
                operator[i]--; //연산자 사용

                int temp = num;
                if(i==0){ //덧셈
                    temp += arr[count];
                } else if(i==1){ //뺄셈
                    temp -= arr[count];
                } else if(i==2){ //곱셈
                    temp *= arr[count];
                } else if(i==3){ //나눗셈
                    temp /= arr[count];
                }
                find(temp, count+1);

                operator[i]++; //백트래킹
            }
        }
    }
}
