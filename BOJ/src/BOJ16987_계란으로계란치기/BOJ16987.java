package BOJ16987_계란으로계란치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16987 {
	static int n, cnt, ans = 0;
	static int [] s, w;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		w = new int[n];
		for(int i=0; i<n; i++) {
			String [] split = br.readLine().split(" ");
			s[i] = Integer.parseInt(split[0]); // 내구도
			w[i] = Integer.parseInt(split[1]); // 무게
		}
		
		dfs(0, 0);
		System.out.println(ans);
	}
	
	private static void dfs(int idx, int cnt) {
		if(idx == n) {
			ans = Math.max(ans, cnt);
			 return;
		}
		
		if(s[idx] <= 0 ) {
			dfs(idx+1, cnt);
			return;
		}
		
		boolean flag = true;
		for(int i = 0 ; i<n; i++) {
			if(i == idx) continue; // 들고있는 계란이면 넘어가기
			if(s[i]<=0) continue; // 이미 깨진 계란
			
			flag = false;
			s[i] -= w[idx];
			s[idx] -= w[i];

			// 둘 다 깨짐
			if(s[idx] <= 0 && s[i] <= 0) dfs(idx+1, cnt+2);
			//하나만 깨짐
			else if(s[idx] <=0 || s[i] <= 0)  dfs(idx+1, cnt+1);
			//둘 다 안깨짐
			else dfs(idx+1, cnt);
			
			s[i] += w[idx];
			s[idx] += w[i];
		}
		if(flag) dfs(n, cnt);
	}
	
}
