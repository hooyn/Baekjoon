import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 거스름돈 브론즈 2
 */
class BJ_5585 {
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int cost = Integer.parseInt(br.readLine());
    int result = 0;
    cost = 1000 - cost;
    
    int[] arr = {500, 100, 50, 10, 5, 1};
    
    for(int i = 0; i < arr.length; i++){
      if(cost/arr[i]>0){ //첫번째 동전을 사용할 수 있다면
        result += cost/arr[i]; //동전을 사용한 개수
        cost = cost%arr[i]; //동전을 최대로 사용하고 남은 금액
      }
    }
    
    System.out.println(result);
  }
}
