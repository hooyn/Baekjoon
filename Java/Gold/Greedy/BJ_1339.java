import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 단어 수학
 */
public class BJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);

            //reverse를 해주는 이유는 idx 0이 첫번째 자리수
            //idx 1이 두번째 자리수.. 이런식으로 생각하면 편리합니다.
            arr[i] = sb.reverse().toString();
        }

        //길이의 내림차순으로 정렬
        Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());

        //알파벳과 매핑되어지는 숫자
        Map<Character, Integer> map = new HashMap<>();

        //자리수 최대값
        int start = arr[0].length() - 1;

        for (int i = start; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                //현재 i(자리수) 보다 문자열의 길이가 짧은 경우
                if(i >= arr[j].length()){
                    break;
                }

                //j번째 최대 자리수 (start) 부터 0까지
                char c = arr[j].charAt(i);

                if(!map.containsKey(c)){
                    //키가 없다면 추가
                    map.put(c, (int) Math.pow(10, i));
                } else {
                    //키가 있다면 기존 값에 더하기
                    map.put(c, map.get(c) + (int) Math.pow(10, i));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Character> it = map.keySet().iterator();

        //리스트에 value값 저장
        while(it.hasNext()){
            char c = it.next();
            list.add(map.get(c));
        }

        //리스트 내림차순으로 정렬
        Collections.sort(list, (a,b)->b-a);

        int num = 9;
        int ans = 0;

        //큰 수에 9부터 차례대로 배정
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i) * num--;
        }

        System.out.println(ans);
    }
}

//참고: https://steady-coding.tistory.com/248
