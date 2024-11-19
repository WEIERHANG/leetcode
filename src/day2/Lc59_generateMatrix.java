package day2;

public class Lc59_generateMatrix {

    public static void main(String[] args) {

    }
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int startX = 0, startY = 0, offset = 1,loop = 1,count = 1,x,y;
        while (loop <= n / 2){
            for(y = startY; y < n - offset; y++) arr[startX][y] = count++;
            for(x = startX; x < n - offset; x++) arr[x][y] = count++;
            for( ; y > startY; y--) arr[x][y] = count++;
            for( ; x > startX; x--) arr[x][y] = count++;
            startX++;
            startY++;
            loop++;
            offset++;
        }
        if(n % 2 == 1) arr[startX][startY] = count;
        return arr;
    }

}
