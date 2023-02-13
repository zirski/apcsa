public class Sum {
    public static void main(String[] args) {
        int[][] array = {{32, 4, 14, 65, 23, 6},
                        {4, 2, 53, 31, 765, 34},
                        {64235, 23, 522, 124, 42, 64}};

    }
    
    // Assuming the user of sumRow knows that array indices start at 0
    public static int sumRow(int[][] array, int row) {
        int sum = 0;
        // for loop measures size of specified row, as rows may not be of equal length
        for (int i = 0; i < array[row].length; i++) {
            sum += array[row][i];
        }

        return sum;
    }

    public static int sumColumn(int[][] array, int column) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][column];
        }

        return sum;
    }
}