package SWEA.swea_1288;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 새로운불면증{
  public static void main(String [] args) throws NumberFormatException, IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    int mask = (1<<10)-1;
    int v = 0;

    for(int tc = 1; tc<=t; tc++){
      int n = Integer.parseInt(br.readLine());
      int ans = 1;
      
      for(ans = 1;;ans++){
        char [] ch = String.valueOf(n*ans).toCharArray();
        for(char c: ch){
          int num = c - '0';
          v |= (1<<num);
        }
        if(v == mask) break;
      }
      System.out.println("#"+tc+" "+n*ans);
    }
  }
}