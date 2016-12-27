import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Yifan on 10/29/16.
 */
public class PrintNeatly {
    /**
     * First we calculate the badness of input paragraph
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
        minNeatness(temp, M);
    }

    private static int minNeatness(List<String> input, int M){
        if (input.size() == 0) {
            System.out.println(Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        int n = input.size();
        //so this problem does not belong to knapsack problem,
        //如果是的话，每个word应该有个value，而这里是一串连续的words有个value.
        long[] dp = new long[n+1];

        //the previous line start from p[p[i]] and end at p[i]-1.
        //the first word of current line is p[i]
        int[] pointer = new int[n+1];

        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            dp[i] = badness(input, 1, i, M);
            pointer[i] = 1;
            for (int j = 2; j <= i; j++){
                long temp = dp[j-1]+ badness(input, j, i, M);
                if (dp[i] > temp) {
                    dp[i] = temp;
                    pointer[i] = j;
                }
            }
        }

        System.out.println(dp[n]);
        print(input, pointer, n, M);

        return (int)dp[n];
    }

    private static int badness(List<String> input, int i, int j, int M){

        int allWords = 0;
        for(int k = i-1; k <= j-1; k++)
            allWords += input.get(k).length();
        int temp = M - j + i - allWords;

        if (temp < 0) return Integer.MAX_VALUE;

        //over all lines except the last
        if (j == input.size()) return 0;
        return temp * temp * temp;
    }

    private static void print(List<String> in, int[] p, int j, int M){
        int i = p[j];
        if(i > 1)
            print(in, p, i-1, M);
        System.out.println(distributeSpace(in, i, j, M));

    }

    private static String distributeSpace(List<String> in, int i, int j, int M){
        if(i == j) return in.get(i-1);
        StringBuilder sb = new StringBuilder();
        int words = 0;
        for(int k = i-1; k <= j-1; k++)
            words += in.get(k).length();
        int spaces = M - words;
        int each = spaces/(j-i);
        int offset = spaces % (j-i);
        for (int k = i-1; k <= j-2; k++){
            sb.append(in.get(k));
            int t1 = each;
            while(t1-- > 0)
                sb.append(' ');
            if(offset-- > 0)
                sb.append(' ');
        }
        sb.append(in.get(j-1));
        return sb.toString();
    }
}
