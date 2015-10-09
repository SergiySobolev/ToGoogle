package com.sbk.stringdistance;

import static com.sbk.util.MathUtils.max;

public class NW {
    public static final int GAPSCORE = -2;
    public static final int MATHSCORE = 2;
    public static final int MISMATCHSCORE = -1;
    private static char DASH = '-';

    private int[][] a;
    char[] c1, c2;
    int cols;
    int rows;

    public NW(String s1, String s2) {
        this.cols = s1.length() + 1;
        this.rows = s2.length() + 1;
        a = new int[rows][cols];
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
    }

    private void initializeScoreTable() {
        for (int i = 0; i < rows; i++) a[i][0] = GAPSCORE * i;
        for (int i = 0; i < cols; i++) a[0][i] = GAPSCORE * i;
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                int scroeDiag = (c2[i-1] == c1[j-1]) ? a[i-1][j-1] + MATHSCORE : a[i-1][j-1] + MISMATCHSCORE;
                int scroeLeft = a[i][j - 1] + GAPSCORE;
                int scroeUp = a[i - 1][j] + GAPSCORE;
                int maxScore = max(max(scroeDiag, scroeLeft), scroeUp);
                a[i][j] = maxScore;
            }
        }
    }

    private String[] findTrace(){
        int m = cols-1;
        int n = rows-1;
        StringBuilder trace1=new StringBuilder();
        StringBuilder trace2=new StringBuilder();
        while(m > 0 && n > 0){
            int scroeDiag = (c1[m - 1] == c2[n - 1]) ? MATHSCORE : MISMATCHSCORE;
            if (m > 0 && n > 0 && a[n][m] == a[n-1][m-1] + scroeDiag)
            {
                trace1.append(c2[n-1]);
                trace2.append(c1[m-1]);
                --m;
                --n;
            } else if (n > 0 && a[n][m] == a[n-1][m] + GAPSCORE) {
                trace1.append(c2[n-1]);
                trace2.append(DASH);
                --n;
            } else if (n > 0 && a[n][m] == a[n][m - 1] + GAPSCORE) {
                trace1.append(DASH);
                trace2.append(c1[m-1]);
                --m;
            }
        }
        return new String[]{trace2.reverse().toString(), trace1.reverse().toString()};
    }

    private void print4(int i) {
        String s = "" + i;
        if (s.length() == 1) System.out.print("   " + s);
        else if (s.length() == 2) System.out.print("  " + s);
        else if (s.length() == 3) System.out.print(" " + s);
        else if (s.length() == 4) System.out.print(s);
        else System.out.print("***");
    }

    private void printScoreTable() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                print4(a[i][j]);
            System.out.println();
        }
    }

    public String[] findAligments(){
        initializeScoreTable();
        printScoreTable();
        return findTrace();
    }
}

