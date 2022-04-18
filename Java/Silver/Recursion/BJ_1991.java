import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 트리 순회
 */
public class BJ_1991 {
    static int n;
    static char[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][3];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr[i][0] = input.charAt(0);
            arr[i][1] = input.charAt(2);
            arr[i][2] = input.charAt(4);
        }

        visited = new boolean[n];
        preorder('A'); //전위 순회
        System.out.println();

        visited = new boolean[n];
        inorder('A'); //중위 순회
        System.out.println();


        visited = new boolean[n];
        postorder('A'); //후위 순회
        System.out.println();

    }

    private static void postorder(char node) {
        // 왼쪽 오른쪽 루트
        int idx = getIdx(node); //노드에 해당하는 인덱스 구하기

        if(arr[idx][1]!='.'&&!visited[(int)(arr[idx][1]-'A')]){ //자식이 없고, 방문을 한 노드가 아니라면 순회
            postorder(arr[idx][1]);
        }
        if(arr[idx][2]!='.'&&!visited[(int)(arr[idx][2]-'A')]){
            postorder(arr[idx][2]);
        }
        System.out.print(node);
    }

    private static void inorder(char node) {
        // 왼쪽 루트 오른쪽
        int idx = getIdx(node); //노드에 해당하는 인덱스 구하기

        if(arr[idx][1]!='.'&&!visited[(int)(arr[idx][1]-'A')]){
            inorder(arr[idx][1]);
        }
        System.out.print(node);
        if(arr[idx][2]!='.'&&!visited[(int)(arr[idx][2]-'A')]){
            inorder(arr[idx][2]);
        }
    }

    private static void preorder(char node) {
        // 루트 왼쪽 오른쪽
        int idx = getIdx(node); //노드에 해당하는 인덱스 구하기

        System.out.print(node);
        if(arr[idx][1]!='.'&&!visited[(int)(arr[idx][1]-'A')]){
            preorder(arr[idx][1]);
        }
        if(arr[idx][2]!='.'&&!visited[(int)(arr[idx][2]-'A')]){
            preorder(arr[idx][2]);
        }
    }

    private static int getIdx(char node) {
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i][0]== node) {
                idx = i;
                break;
            }
        } //인덱스 구하기
        return idx;
    }
}
