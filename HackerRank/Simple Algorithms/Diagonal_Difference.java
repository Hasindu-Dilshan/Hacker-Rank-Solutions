public static int diagonalDifference(List<List<Integer>> arr, int n) {
    // Write your code here
        int ltrSum = 0;
        int rtlSum = 0;

        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(row == col) {
                    ltrSum += arr.get(row).get(col);
                }
                if(row + col == n - 1) {
                    rtlSum += arr.get(row).get(col);
                }
            }
        }
        
        return Math.abs(ltrSum - rtlSum);
    }