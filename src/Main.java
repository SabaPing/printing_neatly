


import java.util.Scanner;


/**
 * Created by yql on 12/14/16.
 */
public class Main {


    public static void main(String args[]) {


        String buffer=null;
        Scanner cin = new Scanner(System.in);
        String temp = cin.nextLine();
        //  while(! (buffer=cin.nextLine()).equals("\n") ){}
        //   cin.nextl








        String[] temp1 = temp.split(" ");
        int n = Integer.parseInt(temp1[0]);
        int m = Integer.parseInt(temp1[1]);




        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp2 = cin.nextLine();
            String[] tempp2 = temp2.split(" ");
            for (int j = 0; j < m; j++) {
                ch[i][j] = Integer.parseInt(tempp2[j]);
            }
        }


        int result = 0;




        //  if(a.length == 0) return 0;
        //    int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (ch[i - 1][j - 1] == 1) {
                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
                    result = Math.max(b[i][j], result);
                }
            }
        }


        System.out.println(result);
    }
}
