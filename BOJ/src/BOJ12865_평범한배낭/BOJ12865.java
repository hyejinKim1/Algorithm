package BOJ12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12865 {

    static int N, K;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] split = br.readLine().split("");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        int [] W = new int[N];
        int [] V = new int[N];

        for(int i=0; i<N; i++){
            split = br.readLine().split("");
            W[i] = Integer.parseInt(split[0]);
            V[i] = Integer.parseInt(split[1]);
        }

        
    }
}
