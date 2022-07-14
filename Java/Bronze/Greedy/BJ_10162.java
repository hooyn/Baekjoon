import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 전자레인지
 * 버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.
 */
class BJ_10162 {
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sec = Integer.parseInt(br.readLine());
    
    int[] arr = {300, 60, 10};
    int[] result = {0, 0, 0};
    
    for(int i = 0; i < 3; i++){
      if(sec/arr[i]>0){
        result[i] = sec/arr[i];
        sec = sec%arr[i];
      }
    }
    
    if(sec!=0){
      System.out.println(-1);
    } else {
      for(int ans : result){
        System.out.print(ans + " ");
      }
    }
  }
}
