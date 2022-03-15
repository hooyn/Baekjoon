import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 에디터
 */
public class BJ_1406 {
    public static void main(String[] args) throws IOException {
        Character[] editor = new Character[100002];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int input_size = input.length();
        int cursor = input.length(); //초기 커서 위치로 index설정
        for (int i = 0; i < cursor; i++) {
            char ch = input.charAt(i); //input을 받아서
            editor[i] = ch; //editor 배열 구성
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine(); //명령어를 받는다.
            char com = command.charAt(0);

            if(com=='P'){ //만약 명령어가 P일 때만 what을 받아서 저장한다.
                char what = command.charAt(2);
                if(input_size!=cursor){
                    for (int j = input_size; j > cursor; j--) { 
                        editor[j] = editor[j-1]; //cursor부터 배열을 옆으로 밀고
                    }
                }
                editor[cursor] = what; //cursor에 배열 넣기
                cursor++;
                input_size++;

            } else if(com=='L') {
                if(cursor!=0){
                    //커서가 맨 왼쪽에 있지 않을 때만 cursor index감소
                    cursor--;
                }
            } else if(com=='D') {
                if(!(editor[cursor]==null&&editor[cursor+1]==null)){
                    //editor[cursor]가 null이고 editor[cursor+1]도 null이 아닐 때만
                    //커서가 맨 오른쪽에 있지 않을 때만 cursor index 증가
                    cursor++;
                }
            } else if(com=='B'){
                if(cursor!=0){
                    //커서가 맨 왼쪽에 있지 않을 때만 데이터 삭제
                    for (int j = cursor-1; j < editor.length; j++) {
                        editor[j] = editor[j+1];
                        if(editor[j] == null) break;
                    }
                    input_size--;
                    cursor--;
                }
            }
        }

        for (int i = 0; i < editor.length; i++) {
            if(editor[i]==null) break;
            else System.out.print(editor[i]);
        }
    }
}
