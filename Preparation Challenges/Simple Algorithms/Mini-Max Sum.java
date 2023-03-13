public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long totalSum = 0;
        long sumMax = 0;
        long sumMin = 0;
        
        for(Integer item : arr) {
            totalSum += item;
        }
        
        sumMax = totalSum - arr.get(0);
        sumMin = totalSum - arr.get(0);
        
        for(int count = 0; count < arr.size(); count++) {
            long sum = totalSum - arr.get(count);
            
            if(sumMax < sum) {
                sumMax = sum;
            }
            if(sumMin > sum) {
                sumMin = sum;
            }
        }
        
        System.out.printf("%d %d", sumMin, sumMax);
    }