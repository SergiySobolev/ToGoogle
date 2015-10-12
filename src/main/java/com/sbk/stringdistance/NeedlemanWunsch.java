package com.sbk.stringdistance;

import java.util.HashSet;
import java.util.Set;

import static com.sbk.util.MathUtils.max;

public class NeedlemanWunsch {
    public static final int GAPSCORE = -2;
    public static final int MATHSCORE = 2;
    public static final int MISMATCHSCORE = -1;
    private static char DASH = '-';
    private Set<Trace> decision = new HashSet();

    private int[][] a;
    char[] c1, c2;
    int cols;
    int rows;

    public NeedlemanWunsch(String s1, String s2) {
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

    public void findTrace(){
        findTrace(cols-1, rows-1, new Trace());
    }

    private void findTrace(int k, int l, Trace suffix){
        int m = k;
        int n = l;
        if(m == 0 && n == 0){
            this.decision.add(suffix);
            return;
        }
        int scroeDiag = (c1[m - 1] == c2[n - 1]) ? MATHSCORE : MISMATCHSCORE;
        if (m > 0 && n > 0 && a[n][m] == a[n-1][m-1] + scroeDiag)
        {
            Trace newSuffix = suffix.clone();
            newSuffix.append(c2[n-1], c1[m-1]);
            findTrace(m-1,n-1, newSuffix);
        }
        if (n > 0 && a[n][m] == a[n-1][m] + GAPSCORE) {
            Trace newSuffix = suffix.clone();
            newSuffix.append(c2[n-1], DASH);
            findTrace(m,n-1, newSuffix);
        }
        if (m > 0 && a[n][m] == a[n][m - 1] + GAPSCORE) {
            Trace newSuffix = suffix.clone();
            newSuffix.append(DASH, c1[m-1]);
            findTrace(m-1,n, newSuffix);
        }

    }

    public void printAligents(){
        for(Trace trace : decision){
            System.out.println(trace.toString());
        }
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

    public Set<Trace> getDecision(){
        return decision;
    }

    public void findAligments(){
        initializeScoreTable();
        printScoreTable();
        findTrace();
        printAligents();
    }
}

