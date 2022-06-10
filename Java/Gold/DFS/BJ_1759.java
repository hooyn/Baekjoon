import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 암호 만들기
 */
public class BJ_1759 {
    static int pi(String s){return Integer.parseInt(s);}
    static int n;
    static int m;
    static char[] arr;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //필수 입력값 저장
        n = pi(st.nextToken());
        m = pi(st.nextToken());

        //배열 입력값 저장
        arr = new char[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        //배열 정렬
        Arrays.sort(arr);

        //각각의 case를 저장하기 위한 char 배열
        char[] store = new char[n];
        dfs(0, 0, store);

        System.out.println(sb);
    }

    private static void dfs(int depth, int point, char[] store) {
        //원하는 문자열 일 때
        if(depth==n){
            int consonants = 0; //자음의 개수
            int vowels = 0; //모음의 개수
            String str = "";

            for (char c : store) {
                str += c;
                if( c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    vowels++; //모음일 때 +1
                } else consonants++; //자음일 때 +1
            }

            if(consonants>1 && vowels>0){ //모음 최소1개, 자음 최소 2개일 때
                sb.append(str + '\n'); //sb에 저장
            }

            return;
        }

        for (int i = point; i < m; i++) {
            //해당 point에 있는 문자를 선택하면 원하는 개수의 문자열을 만들 수 있는지 확인
            if(i+(n-1-depth)>=m) break;

            //store에 저장하고
            store[depth] = arr[i];
            //깊이 우선 탐색
            dfs(depth+1, i+1, store);
        }
    }
}
