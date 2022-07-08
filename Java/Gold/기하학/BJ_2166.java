import java.io.*;
import java.util.*;

/*
* 다각형의 면적
*/ 
class BJ_2166 {
  static int pi(String s){return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = pi(br.readLine());
    
    long[] X = new long[n+1];
    long[] Y = new long[n+1];
    
    // 신발끈 공식을 사용하기 위해 X좌표와 Y좌표를 나누어서 저장합니다.
    for(int i = 0; i < n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      X[i] = pi(st.nextToken());
      Y[i] = pi(st.nextToken());
    }
    
    // 신발끈 공식에 따라 마지막 자리를 배열의 첫번째 값으로 저장합니다.
    X[n] = X[0];
    Y[n] = Y[0];
    
    // 신발끈 공식에서 더해야하는 부분(left)과 빼야하는 부분(right)을 나누어서 저장합니다.
    long left_sum = 0;
    long right_sum = 0;
    for(int i = 0; i < n; i++){
      // 신발끈 공식을 사용합니다.
      left_sum += X[i] * Y[i+1];
      right_sum += X[i+1] * Y[i];
    }
    
    String result = String.format("%.1f", (Math.abs(left_sum - right_sum) / 2.0));
    System.out.println(result);
  }
}

/*
* 위키백과 참고
* 신발끈 공식(―公式)은 좌표평면 상에서 꼭짓점의 좌표를 알 때 다각형의 면적을 구할 수 있는 방법이다. 
* 다각형의 각 꼭짓점의 좌푯값을 교차하여 곱하는 모습이 신발끈을 묶을 때와 같아 이러한 이름이 붙었다.
* [1] 가우스의 면적 공식이나 사선 공식(斜線 公式)으로도 불린다.
*/
