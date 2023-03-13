import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        int maxDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        
       //int sumDays[] = new int[12];
        int sumDays = 0;
        int passedMonth = 0;
        
        int day, month;
        
	// Check Leap year
	if(year < 1918 && year % 4 == 0) {
		maxDays[1] = 29;
	}
	else if(year >= 1918){
		if(year % 400 == 0) {
			maxDays[1] = 29;
		}
		else if(year % 4 == 0 && year % 100 != 0) {
			maxDays[1] = 29;
		}
	}
        
        for(int max: maxDays){
            if(sumDays + max <= 256){
                sumDays += max;
                passedMonth++;
            }
        }        

	if(year == 1918 && sumDays > 31) {
		sumDays -= 13;
	}
        
        day = 256 - sumDays;
        month =  passedMonth + 1;
        
        String output = String.format("%02d.%02d.%04d", day, month, year);
        
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

	System.out.println(result);

        bufferedReader.close();
    }
}

