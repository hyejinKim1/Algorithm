package BOJ15686_치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15686 {
	static int n, m, ANS = Integer.MAX_VALUE;
	static int [][] a;
	static ArrayList<Integer[]> chicken = new ArrayList<>();
	static ArrayList<Integer[]> home = new ArrayList<>();
	static int [] arr;
	static int [] sel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		
		a = new int[n][n];
		
		for(int i=0; i<n; i++) {
			split = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				a[i][j] =  Integer.parseInt(split[j]);
				if(a[i][j] == 2) chicken.add(new Integer[] {i, j});
				else if(a[i][j] == 1) home.add(new Integer[] {i, j});
			}
		}
		
		arr = new int[chicken.size()];
		for(int i=0; i<chicken.size(); i++) {
			arr[i] = i;
		}
		sel = new int[m];
		
		comb(0, 0);
		System.out.println(ANS);
	}
	
	private static void comb(int idx, int k) {
		if(k == sel.length) {
			int sum = 0;
			
			for(int i=0; i<home.size(); i++) {
				
				int min = Integer.MAX_VALUE;
				Integer [] h = home.get(i);
				
				for(int j=0; j<sel.length; j++) {
					Integer [] loc = chicken.get(sel[j]);
					min = Math.min(min, distance(loc[0], loc[1], h[0],h[1]));
				}
				sum += min;
			}
			ANS = Math.min(ANS, sum);
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			sel[k] = arr[i];
			comb(i+1, k+1);
		}
	}

	
	private static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2-x1)+Math.abs(y2-y1);
	}
}