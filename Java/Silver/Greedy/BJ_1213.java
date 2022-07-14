import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 팰린드롬 만들기
 */
class BJ_1213 {
  public static void main(String[] args) throws IOException{
    int[] arr = new int[26]; //알파벳 개수 저장 배열
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input_str = br.readLine();
    
    //알파벳 개수를 알기 위해 for문 사용
    for(int i = 0; i < input_str.length(); i++){
      int n = (input_str.charAt(i) - 'A');
      arr[n]++;
    }
    
    //홀수의 알파벳이 있는지 확인
    int hol_count = 0;
    int hol_idx = 0;
    for(int i = 0; i < 26; i++){
      if(arr[i]%2==1){
        hol_count++;
        hol_idx=i;
      }
    }
    
    StringBuilder sb = new StringBuilder();
    if((input_str.length()%2==1 && hol_count>1) || (input_str.length() % 2 == 0 && hol_count>0)){
      //만약 입력받은 문자열의 길이가 홀수 인데 홀수의 수가 2개 이상이라면 불가
      //만약 입력받은 문자열의 길이가 짝수 인데 홀수의 수가 1개 이상이라면 불가
      sb.append("I'm Sorry Hansso");
    } 
    else {
      String answer = "";
      //arr[i]가 홀 수일때 문자 하나만 가운데에 입력하고 다른 수들은 대칭을 맞추기 위해 사용해야
      //사전에서 가장 앞에 있는 수를 만들 수 있다.
      for(int i = 0; i < 26; i++){
        for(int j = 0; j < arr[i]/2; j++){
          answer += (char) (i + 'A');
        }
      }
        
      String rev_answer = new StringBuilder(answer).reverse().toString();

      //홀 수개 문자 하나를 가운데에 삽입
      if(hol_count==1){
        answer += (char)(hol_idx+'A');
      }
      sb.append(answer + rev_answer);
    }
    System.out.println(sb);
  }
}

//참고 https://lms0806.tistory.com/66
