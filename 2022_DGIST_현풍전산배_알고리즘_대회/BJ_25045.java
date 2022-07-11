import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class BJ_25045 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int controller = Math.min(n, m);
    
    Long[] N = new Long[n];
    Long[] M = new Long[m];
    
    //만족도 입력 받기
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      N[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(N, Collections.reverseOrder());
    
    //비용 입력 받기
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < m; i++){
      M[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(M, Collections.reverseOrder());
 
    //만족도 - 비용을 해서 0보다 크면 Score sum에 더하기
    //만족도는 내림차순으로 정렬하고
    //비용은 오름차순으로 정렬하여
    //물건과 회사 중 수가 적은만큼 비교하기
    long sum = 0;
    for(int i = 0; i < controller; i++){
      long score = N[i] - M[i];
      if(score>0){
        sum += score;
      }
    }
    
    System.out.println(sum);
  }
}
