public class Test {    
    public static void main(String[] args) {
        Basics basic = new Basics();

        basic.printNums();

        basic.printOdd();

        basic.printSum255();

        int[] arr = {1, 3, 5, 7, 9, 13};
        basic.itterArr(arr);

        int[] arr2 = {2,-4,-6,-8,0};
        basic.findMax(arr2);

        int[] arr3 = {2,10,3};
        basic.findAvg(arr3);

        basic.arrayOdd();

        int[] arr4 = { 1,3,5,7};
        int y = 3;
        basic.greaterY(arr4, y);
    
        int[] arr5 = {1,5,10,-2};
        basic.squareVal(arr5);

        int[] arr6 = {1,2,10,-1};
        basic.noNeg(arr6);

        int[] arr7 = {1,5,10,-2};
        basic.maxMinAvg(arr7);
    }

}