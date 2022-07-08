import java.io.*;
import java.util.*;

/**
* 터렛
* 문제인식: 두원의 접점을 구하는 문제
* 1. 원의 중심이 같고 반지름이 같을 때 접점 개수 INF
* 2. 두 원의 정점 사이 거리가 두 원의 반지름의 합보다 클 때 접점 개수 0
* 3. 한 원이 다른 원 안에 위치한다. 접점 개수 0
* 4. 내접할 때와 외접할 때 접점 개수 1
* 5. 두 점에서 만날 때 접점 개수 2
*/
class BJ_1002 {
  static int pi(String s){return Integer.parseInt(s);}
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = pi(br.readLine());
    
    while(n-->0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int x1 = pi(st.nextToken());
      int y1 = pi(st.nextToken());
      int r1 = pi(st.nextToken());
      
      int x2 = pi(st.nextToken());
      int y2 = pi(st.nextToken());
      int r2 = pi(st.nextToken());
      
      double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
      
      // case별로 분기처리하여 접점 구하기
      
      //* 1. 원의 중심이 같고 반지름이 같을 때 접점 개수 INF
      if(x1==x2 && y1==y2 && r1==r2) {
        System.out.println(-1);
      }
	  //* 2. 두 원의 정점 사이 거리가 두 원의 반지름의 합보다 클 때 접점 개수 0
	  else if(distance > Math.sqrt(Math.pow(r1+r2, 2))){
        System.out.println(0);
      }
      //* 3. 한 원이 다른 원 안에 위치한다. 접점 개수 0
	  else if(distance < Math.sqrt(Math.pow(r2-r1, 2))){
        System.out.println(0);
      }
      //* 4. 내접할 때 접점 개수 1
      else if(distance == Math.sqrt(Math.pow(r2 - r1, 2))){
        System.out.println(1);
      }
      //* 5. 외접할 때 접점 개수 1
      else if(distance == Math.sqrt(Math.pow(r1 + r2, 2))){
        System.out.println(1);
      } 
      //* 6. 두 점에서 만날 때
      else {
        System.out.println(2);
      }
    }
  }
}
