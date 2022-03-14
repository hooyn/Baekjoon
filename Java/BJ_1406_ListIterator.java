import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
* 에디터
*/
public class BJ_1406_ListIterator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<Character>();

        for(int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        //iterator 메소드 호출
        //iterator는 ArrayList, HashSet과 같은 컬렉션을 반복하는 데 사용할 수 있는 객체다.
        //iterator는 반복의 기술 용어기 때문에 반복자라고 한다

        //Iterator의 장점
        //1. 컬렉션에서 요소를 제어하는 기능
        //2. next() 및 previous()를 써서 앞뒤로 이동하는 기능
        //3. hasNext()를 써서 더 많은 요소가 있는지 확인하는 기능
        //출처: https://onlyfor-me-blog.tistory.com/319
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char key = command.charAt(0);
            switch(key) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();

                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();

                    break;
                case 'B':
                    //remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char value = command.charAt(2);
                    iter.add(value);

                    break;
                default:
                    break;
            }
        }
        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}
