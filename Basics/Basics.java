import java.util.ArrayList;

public class Basics {

    //Print 1-255

    public void printNums() {
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
    }
    //Print odd #'s 1-255

    public void printOdd() {
        for (int i = 1; i < 256; i = i + 2) {
            System.out.println(i);
        }
    }

    //print sum of 0 - 255
    public void printSum255() {
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum = sum + i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }

    //iterate an array
    public void itterArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Find Max
    public int findMax(int[] arr2) {
    int max = arr2[0];
        for(int i = 0; i < arr2.length; i++) {
            if(max < arr2[i]) {
                max = arr2[i];
            }
        }
        System.out.println(max);
        return max;
    }

    // get average
    public int findAvg(int[] arr3) {
    int sum = 0;
        for(int i = 0; i < arr3.length; i++) {
            sum = sum + arr3[i];
        }
        int avg = (sum / arr3.length);
        System.out.println(avg);
        return avg; 
    }
    // print an odd array
    public ArrayList arrayOdd() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 0; i < 256; i++) {
            if(i % 2 != 0) {
                y.add(i);
            }
        }
        System.out.print(y);
        return y;
    }
    // greater than y
    public int greaterY(int[] arr4, int y) {
        int count = 0;
    
        for(int i = 0; i < arr4.length; i++){
            if(arr4[i] > y) {
                count++;
            }
        }
        System.out.println(count);
        return count; 
    }
    // Square the values

    public ArrayList squareVal(int[] arr5) {
        ArrayList<Integer> yy = new ArrayList<Integer>();
        for(int i = 0; i < arr5.length; i++) {
            arr5[i] = (arr5[i] * arr5[i]);
                yy.add(arr5[i]);
        }
        System.out.println(yy);
        return yy;
    }
    //No negatives
    public ArrayList noNeg(int[] arr6) {
        ArrayList<Integer> arrX = new ArrayList<Integer>();
        for(int i = 0; i < arr6.length; i++) {
            if (arr6[i] < 0) {
                arr6[i] = 0;
            }
            arrX.add(arr6[i]);
        }
        System.out.println(arrX);
        return arrX; 
    }
    // Min Avg Max
    public ArrayList maxMinAvg(int[] arr7) {
        ArrayList<Integer> arrayMxMnAv = new ArrayList<Integer>();
        int max = 0;
        int min = arr7[0];
        int avg = 0;
        int sum = 0;
        
        for(int i = 0; i < arr7.length; i++) {
            if(max < arr7[i]) {
                max = arr7[i];
            }
            if(min > arr7[i]) {
                min = arr7[i];
            }
            sum = ( sum + arr7[i]);
            
            avg = (sum / arr7.length);
        }
        arrayMxMnAv.add(max);
        arrayMxMnAv.add(min);
        arrayMxMnAv.add(avg);
        System.out.println(arrayMxMnAv);
        return arrayMxMnAv; 
    }
}