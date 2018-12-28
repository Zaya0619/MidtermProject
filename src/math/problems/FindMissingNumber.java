package math.problems;

/**
 * Created by mrahman on 04/22/17.
 */
public class FindMissingNumber {
    public static void main(String[] args){



    //public static int main(String[] args){
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */

        int[] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
      //public int FindMissingNumber (int [] nums){
       int n = array.length;
       //int expectedSum = n*(n+1)/2;

       int actualSum = 0;
       for(int i=0; i<n; i++){
           actualSum= actualSum+array[i];
       }
        System.out.println("actualSum" +" " + actualSum);

       int total =0;
       for(int j=1; j<=10; j++)
           total=total+j;
        System.out.println("total" +" "+ total);
        System.out.println("MissingNumber" + " " + (total-actualSum));

    }
}
