import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * 내 뒤에 나와 다른 수 실버 3
 */
class BJ_24523 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n+1];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int cnt = 1;
    for(int i = 1; i <= n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      
      //i==2 부터 입력 받는 과정에서 전에 받은 수랑 다른 수를 받는다면
      //다른 수가 나온 인덱스를 전에 전에 같았던 수들에 대입
      //cnt를 통해 구분한다.
      if(i > 1){
        if(arr[i-1]!=arr[i]){
          for(int j = cnt; j < i; j++){
            arr[j] = i;
          }
          cnt = i;
        }
      }
    }
    
    //위에 처리 이후 남은 수들은 모두 같은 수 이기 때문에
    //마지막 인덱스 -1 처리를 해준다.
    if(cnt!=n){
      for(int j = cnt; j <= n; j++){
            arr[j] = -1;
          }
    } else {
      arr[n] = -1;
    }
    
    for(int i = 1; i<=n;i++){
      bw.write(arr[i] + " ");
    }
    bw.flush();
    bw.close();
  }
}
