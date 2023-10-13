package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 게리맨더링 {
	static int n, ans= Integer.MAX_VALUE;
	static int [][] map;
	static int [] num;
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		String [] split = br.readLine().split(" ");
		for(int i=1; i<=n; i++) {
			num[i] = Integer.parseInt(split[i-1]);
		}
	
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			split = br.readLine().split(" ");
			int m = Integer.parseInt(split[0]);
			for(int j=1; j<=m; j++) {
				int v = Integer.parseInt(split[j]);
				map[i][v] = 1;
			}
		}
		
		div(1, new boolean[n+1]);
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
	
	private static void div(int idx, boolean[] sel) {
		if(idx == n+1) {
			ArrayList<Integer> l1 = new ArrayList<>();
			ArrayList<Integer> l2 = new ArrayList<>();
			
			int sum1=0;
			int sum2=0;
			
			for(int i=1; i<=n; i++) {
				if(sel[i]) {
					l1.add(i);
					sum1 += num[i];
				}
				else{
					l2.add(i);
					sum2 += num[i];
				}
			}
			
			if( l1.size() == 0 || l2.size() == 0) return;
			
			boolean [] v = new boolean[n+1];
		
			dfs(l1, l1.get(0), v);
			dfs(l2, l2.get(0), v);
			
			for(int i=1; i<=n; i++) {
				if(!v[i]) return;
			}

			ans = Math.min(ans, Math.abs(sum1-sum2));
			return;
		}
		sel[idx] = true;
		div(idx+1, sel);
		sel[idx] = false;
		div(idx+1, sel);
	}
	
	private static void dfs(ArrayList<Integer> l, int start, boolean [] v) {
		v[start] = true;
		for(int i=1; i<l.size(); i++) {
			if(map[start][l.get(i)]==1 && !v[l.get(i)]) dfs(l, l.get(i), v);
		}
	}
	
}
