package Recursion.PrintTypes;

import java.util.Scanner;

public class PrintMazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        scn.close();
        printMazePathswithJumps(0, 0, n - 1, m - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");



    }
    public static void printMazePathswithJumps(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }

        for (int i = 1; i <= dc; i++) {
            printMazePathswithJumps(sr, sc + i, dr, dc, psf + "h" + i);
        }

        for (int i = 1; i <= dr; i++) {
            printMazePathswithJumps(sr + i, sc, dr, dc, psf + "v" + i);
        }
        for (int i = 1; i <= dc && i <= dr; i++) {
            printMazePathswithJumps(sr + i, sc + i, dr, dc, psf + "d" + i);
        }
    }

}
