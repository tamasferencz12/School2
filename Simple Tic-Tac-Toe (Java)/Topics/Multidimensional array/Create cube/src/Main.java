import java.util.Scanner;

class ArrayOperations {

    public static int[][][] createCube() {
        int[][][] threeD = new int[3][3][3];
        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    threeD[i][j][k] = x;
                    x++;
                }
            }
            x = 0;
        }
        return threeD;
    }
}