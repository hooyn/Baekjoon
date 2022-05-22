import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 지름길
 */
public class BJ_1446_dijkstra {
    static class Road{
        int start, end, len;

        public Road(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Road{" +
                    "start=" + start +
                    ", end=" + end +
                    ", len=" + len +
                    '}';
        }
    }
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = pi(st.nextToken());
        int d = pi(st.nextToken());

        List<Road> list = new ArrayList<>();

        while(n-->0){
            st = new StringTokenizer(br.readLine());

            int s = pi(st.nextToken());
            int e = pi(st.nextToken());
            int l = pi(st.nextToken());

            if(e>d) continue;
            if(e - s <= l) continue;
            list.add(new Road(s, e, l));
        }

        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                if(o1.start==o2.start) {
                    return o1.end - o2.end;
                }
                else{
                    return o1.start-o2.start;
                }
            }
        });

        for (Road road : list) {
            System.out.println(road);
        }

        int idx = 0, move = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, 10001); //배열 값 전체 10001(최대값)로 채우기
        dist[0] = 0;

        while(move<d){
            if(idx < list.size()){ //list에 들어가 있는 값이 없다면
                Road road = list.get(idx); //저장한 값중 하나 빼고
                if(move == road.start){ //만약 현재 위치가 지름길의 시작위치이면
                    dist[road.end] = Math.min(dist[move] + road.len, dist[road.end]); //더 빨리 갈 수 있다면
                    idx++; //list 다음 값으로 이동
                } else {
                    dist[move+1] = Math.min(dist[move+1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move+1] = Math.min(dist[move+1], dist[move] + 1);
                move++;
            }
        }
        System.out.println(dist[d]);
    }
}

//참고: https://coder-in-war.tistory.com/entry/BOJ-JAVA1446-%EC%A7%80%EB%A6%84%EA%B8%B8
