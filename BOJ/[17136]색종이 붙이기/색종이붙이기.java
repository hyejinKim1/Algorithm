package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이붙이기 {
    static int [][] arr = new int[10][10];
    static int ans = Integer.MAX_VALUE;
    static int [] num = new int[6];
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<10; i++) {
            String [] split = br.readLine().split(" ");
            for(int j=0; j<10; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }
        
        for(int i=1; i<=5; i++) {
        	num[i] = 5;
        }
        
        dfs(0, 0, 0);
        
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    private static boolean check(int n, int x, int y) {
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
            	if(i >= 10|| j >= 10) return false;
                if(arr[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void dfs(int x, int y, int idx) {
    	if(x >= 9 && y > 9) {
    		ans = Math.min(ans, idx);
    		return;
    	}
    	
    	if(ans <= idx) return;
        
        if(y>9) {
        	dfs(x+1, 0, idx);
        	return;
        }

        if(arr[x][y]==1) {
            for(int i = 5; i >= 1; i--) {
            	if(num[i]==0) continue;
            	if(check(i, x, y)) {
            		change(x, y, i, 0);
            		num[i]--;
            		dfs(x, y+1, idx+1);
            		change(x, y, i, 1);
            		num[i]++;
            	}
            }
        }else dfs(x, y+1, idx);
    }
    
    private static void change(int x, int y, int d, int c) {
    	for(int i=x; i<x+d; i++) {
            for(int j=y; j<y+d; j++) {
                arr[i][j] = c;
            }
        }
    }

}

