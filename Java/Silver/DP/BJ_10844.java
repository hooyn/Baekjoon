package baek0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쉬운 계단 수
 */
public class BJ_10844 {
    static int n;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        find(0, arr);

        System.out.println(result);
    }

    private static void find(int depth, int[] arr) {
        if(depth==n){
            result++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(depth==0&&i==0){
                continue;
            }

            arr[depth] = i;

            if(depth!=0){
                if(Math.abs(arr[depth-1]-arr[depth])==1){
                    find(depth+1, arr);
                }
            } else if(depth==0){
                find(depth+1, arr);
            }
        }
    }
}
