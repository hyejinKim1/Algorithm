package BOJ11559_PuyoPuyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BOJ11559 {
	static char[][] board = new char[12][6];
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		int ans = 0;
		while(check()) {// 4개이상 연결 확인
			ans++;
			// 아래로 내려오기
			down();
		}
		
		System.out.println(ans);
	}

	private static boolean check() {
		boolean flag = false;
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(board[i][j] != '.') {
					List<Integer[]> li = bfs(i, j);
					if(li.size() >= 4) {
						flag = true;
						delete(li);
					}
				}
			}
		}
		return flag;
	}
	
	private static List<Integer[]> bfs(int i, int j) {
		boolean [][] v = new boolean[12][6];
		Deque<Integer []> q = new ArrayDeque<>();
		List<Integer[]> li = new ArrayList<>();
		
		q.add(new Integer[] {i, j});
		li.add(new Integer[] {i, j});
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			Integer [] p = q.poll();
			int x = p[0];
			int y = p[1];
			char c = board[x][y];
			
			for(int d = 0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx<0 || ny<0 || nx>=12 || ny>=6) continue;
				if(v[nx][ny]) continue;
				if(board[nx][ny] != c) continue;
				
				q.add(new Integer[] {nx, ny});
				v[nx][ny] = true;
				li.add(new Integer[] {nx, ny});
			}
		}
		
		return li;
	}
	
	private static void delete(List<Integer[]> li) {
		for(Integer[] p: li) {
			int x = p[0];
			int y = p[1];
			
			board[x][y] = '.';
		}
	}
	
	private static void down() {
		while(true) {
			boolean flag = true;
			for(int i=10; i>=0; i--) {
				for(int j=0; j<6; j++) {
					if(board[i][j] != '.' && board[i+1][j] == '.') {
						board[i+1][j] = board[i][j];
						board[i][j] = '.';
						flag = false;
					}
				}
			}
			if(flag) break;
		}
	}
	
}
