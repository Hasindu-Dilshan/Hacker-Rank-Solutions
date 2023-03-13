public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
        int maxHeight = 0;
        int maxCount = 0;
        
        for(Integer candle: candles) {
            if(maxHeight < candle) {
                maxHeight = candle;
                maxCount = 1;
            }
            else if(maxHeight == candle){
                maxCount++;
            }
        }
        
        return maxCount;
    }
