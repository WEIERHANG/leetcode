package interviewByHead;



public class Eor {

    public static void main(String[] args) {
        int[] testArray1 = {1, 2, 3, 2, 1, 3, 3};
        int[] testArray2 = {4, 4, 5, 6, 6, 5, 7};
        int[] testArray3 = {8, 8, 9, 10, 10, 9, 11};

        System.out.print("The odd occurring number in testArray1 is: ");
        printOddNum1(testArray1); // Expected output: 3

        System.out.print("The odd occurring number in testArray2 is: ");
        printOddNum1(testArray2); // Expected output: 7

        System.out.print("The odd occurring number in testArray3 is: ");
        printOddNum1(testArray3); // Expected output: 11

    }

    /**
     * arr中，只有一个数出现奇数次
     * @param arr1
     */
    public static void printOddNum1(int[] arr1){
        int eor = 0;
        for(int i = 0; i < arr1.length; i++) eor ^= arr1[i];
        System.out.println(eor);
    }



}
