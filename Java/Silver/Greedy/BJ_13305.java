import java.io.*;
import java.util.*;

/**
* 주유소
*/
public class BJ_13305 {
    static int pi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = pi(br.readLine());
      	
      	long[] distances = new long[n-1];
      	long[] oils = new long[n];
      
        StringTokenizer st = new StringTokenizer(br.readLine());
      	for(int i = 0; i < n-1; i++){
          	distances[i] = pi(st.nextToken());
        }
      
      	st = new StringTokenizer(br.readLine());
      	for(int i = 0; i < n-1; i++){
         	oils[i] = pi(st.nextToken());
        }
      	
      	long sum = 0;
      	long minOil = oils[0];
      
        //sort oil info desc
      	for(int i = 0; i < n-1; i++){
          	if(oils[i]<minOil){
              	minOil = oils[i];
			}
          
          	sum += (minOil*distances[i]);
        }
      
      	System.out.println(sum);
    }
}
