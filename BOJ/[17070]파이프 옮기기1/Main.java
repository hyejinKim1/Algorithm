import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, ans;
    static int [][] a;
    static boolean [][]v;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        v = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String [] split = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0, 0, 0, 1, false);
        System.out.println(ans);
    }

    private static void dfs(int x1, int y1, int x2, int y2, boolean flag) {
    	if(x1 >= n || y1 >= n || x2 >= n || y2 >= n) return;
        if(flag) {
            if( a[x2][y2] == 1 || a[x2][y2-1] == 1 || a[x2-1][y2] == 1 ) return;
        }else if(a[x2][y2] == 1) return;
        
        if(x2 == n-1 && y2 == n-1) {
            ans++;
            return;
        }

        if(x1 == x2) { // 가로 방향
            dfs(x1, y1+1, x2, y2+1, false);
            dfs(x1, y1+1, x2+1, y2+1, true);
        }else if( y1 == y2) { // 세로 방향
            dfs(x1+1, y1, x2+1, y2, false);
            dfs(x1+1, y1, x2+1, y2+1, true);
        }else { //대각선
            dfs(x1+1, y1+1, x2, y2+1, false);
            dfs(x1+1, y1+1, x2+1, y2, false);
            dfs(x1+1, y1+1, x2+1, y2+1, true);
        }
    }
}