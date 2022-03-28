import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 눈덩이 굴리기
 */
public class BJ_21735 {

    static int size;
    static int time;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[size+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0, 1);
        System.out.println(result);
    }

    private static void find(int cnt, int idx, int sum) {
        if(cnt==time||idx==size){ //시간이 되거나, 거리가 앞마당 끝까지 도달할 때
            result = Math.max(result, sum);
        } else {
            if(idx<size){
                find(cnt+1, idx+1, sum+arr[idx+1]);
            }
            if(idx<size-1){
                find(cnt+1, idx+2, sum/2+arr[idx+2]);
            }
        }
    }
}
