import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 두 스티커 실버 3
 */
public class BJ_16937 {

	static int MAX_AREA;
	static int H, W, N;
	static int[][] stickers;
	
	public static void main(String[] args) throws Exception {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine().trim());
		
		stickers = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			stickers[i][0] = Integer.parseInt(st.nextToken());
			stickers[i][1] = Integer.parseInt(st.nextToken());
			stickers[i][2] = stickers[i][0] * stickers[i][1]; // 넓이
		}
		
		MAX_AREA = 0;
		
		calcMaxArea();
		
		System.out.println(MAX_AREA);
	}
	
  //최대 넓이 구하기
	private static void calcMaxArea() {
		for(int i = 0; i < stickers.length; i++) {
			for(int j = i + 1; j < stickers.length; j++) {
				if(i == j) continue;
				if(isCanStick(stickers[i], stickers[j])) { // 붙일 수 있다면
					MAX_AREA = Math.max(MAX_AREA, stickers[i][2] + stickers[j][2]);
				}
			}
		}
	}

  //그대로, 그대로/ 돌리고, 그대로/ 그대로, 돌리고/ 돌리고, 돌리고
	private static boolean isCanStick(int[] a, int[] b) {
	   for (int i = 0; i < 2; i++) {
		  for (int j = 0; j < 2; j++) {
			  if((a[i] + b[j]) <= H && Math.max(a[(i+1)%2], b[(j+1)%2]) <= W) return true;
			  if((a[i] + b[j]) <= W && Math.max(a[(i+1)%2], b[(j+1)%2]) <= H) return true;
		  }
	   }
	   return false;
	}
}

//참고: https://dev-myblog.tistory.com/entry/백준16937-두-스티커-문제풀이-JAVA
