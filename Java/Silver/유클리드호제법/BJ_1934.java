import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최소공배수 - 브1
 */
public class BJ_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gdc = GDC(a, b);
            int result = gdc * (a/gdc) * (b/gdc);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int GDC(int a, int b){
        int temp = 0;
        int n = 0;

        if(b>a){
            temp = a;
            a = b;
            b = temp;
        }

        while(b!=0){
            n = a%b;
            a = b;
            b = n;
        }

        return a;
    }
}
