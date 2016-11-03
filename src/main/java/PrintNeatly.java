import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Yifan on 10/29/16.
 */
public class PrintNeatly {
    /**
     * First we calculate the neatness of input paragraph
     */



    public static void main(String[] args) throws IOException {
        Scanner in;
        int M = 20;
        if (args.length > 0) {
            Path path = Paths.get(args[0]);
            in = new Scanner(path);
            if (args.length > 1) { M = Integer.parseInt(args[1]); }
        } else {
            in = new Scanner(System.in);
        }

        List<String> temp = new ArrayList<>();
        String tmpS;
        while(in.hasNext() /*&& !(tmpS = in.next()).equals("```")*/)
            temp.add(in.next()/*tmpS*/);
//        System.out.println(minNeatness(temp, M));
//        minNeatness(temp, M);
    }

    private static int minNeatness(List<String> input, int M){
        int n = input.size();
        //so this problem does not belong to knapsack problem,
        //如果是的话，每个word应该有个value，而这里是一串连续的words有个value.
        long[] dp = new long[n+1];

        //the previous line start from p[p[i]] and end at p[i]-1.
        int[] pointer = new int[n+1];

        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            dp[i] = neatness(input, 1, i, M);
            pointer[i] = 0;
            for (int j = 2; j <= i; j++){
                long temp = dp[j-1]+neatness(input, j, i, M);
                if (dp[i] > temp) {
                    dp[i] = temp;
                    pointer[i] = j;
                }
            }
        }

        System.out.println(dp[n]);
        //todo print


        return (int)dp[n];
    }

    private static int neatness(List<String> input, int i, int j, int M){

        int allWords = 0;
        for(int k = i-1; k <= j-1; k++)
            allWords += input.get(k).length();
        int temp = M - j + i - allWords;

        if (temp < 0) return Integer.MAX_VALUE;

        //over all lines except the last
        if (j == input.size()) return 0;
        return temp * temp * temp;
    }

    private static void print(int[] p){
        Stack<Integer> s = new Stack<>();
        //todo
    }

    private static void helper(int[] p, int k, Stack<Integer> s){
        //todo
    }

}
