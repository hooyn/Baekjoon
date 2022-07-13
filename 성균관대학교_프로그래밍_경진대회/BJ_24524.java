import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 아름다운 문자열 골드 5
 */
public class BJ_24524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        int result = 0;

        //큐 배열 선언과 초기화
        Queue<Integer>[] list = new Queue[26];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }

        //큐 배열에 데이터 저장
        for (int i = 0; i < S.length(); i++) {
            list[(S.charAt(i)-'a')].add(i);
        }

        int idx = 0;
        int pos = -1;
        while(true){
            int ch = (T.charAt(idx) - 'a');

            while(!list[ch].isEmpty() && pos > list[ch].peek()){
                list[ch].poll();
            }

            if(!list[ch].isEmpty()){
                pos = list[ch].poll();
            } else {
                break;
            }

            idx++;

            if(idx==T.length()){
                result++;
                idx = 0;
                pos = -1;
            }
        }

        System.out.println(result);
    }
}

//참고: https://burningfalls.github.io/algorithm/boj-24524/
