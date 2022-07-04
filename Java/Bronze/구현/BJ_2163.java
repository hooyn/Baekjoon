import java.io.*;
import java.util.*;

/**
* 초콜릿 자르기
*/
public class BJ_2163 {
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    
    	System.out.println((n-1) + (n*(m-1)));
  }
}
