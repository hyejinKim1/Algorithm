import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1260 {
	static int n, m, v;
	static ArrayList [] arr;
	static boolean [] bv, dv;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] split = br.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		v = Integer.parseInt(split[2]);
		
		arr = new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			split = br.readLine().split(" ");
			int u = Integer.parseInt(split[0]);
			int v = Integer.parseInt(split[1]);
			arr[u].add(v);
			arr[v].add(u);
		}
		
		bv = new boolean[n+1];
		dv = new boolean[n+1];
		
		dfs(v);
		System.out.println();
		bfs(v);
	}
	
	private static void dfs(int k) {
		ArrayList<Integer> li = arr[k];
		Collections.sort(li);
		dv[k] = true;
		System.out.print(k+" ");
		for(int v: li) {
			if(!dv[v]) {
				dfs(v);
				dv[v] = true;
			}
		}
	}
	
	private static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(start);
		bv[start] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			
			ArrayList<Integer> li = arr[u];
			System.out.print(u+" ");
			Collections.sort(li);
			for(int v: li) {
				if(!bv[v]) {
					q.add(v);
					bv[v] = true;
				}
			}
		}
	}
	

}
