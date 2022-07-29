import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     Write a function that takes an array of numbers (integers for the tests) and a target number. It should find two different items in the array that, when added together, give the target value. The indices of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).

    For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.

    The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers; target will always be the sum of two different items from that array).
    Example:  
        two_sum([1, 2, 3], 4) == {0, 2}
     */
    public static void main(String[] args) {
        int array[]={2, 2, 3};
        int target=4;
        System.out.println(Arrays.toString(twoSum(array,target))); // [0, 1]
        System.out.println(Arrays.toString(twoSumSecond(array, target))); // [0, 1]
        System.out.println(Arrays.toString(twoSumWithMap(array, target))); // [1, 0]
        System.out.println(Arrays.toString(twoSumWithMap2(array, target))); // [0, 1]
        System.out.println(Arrays.toString(twoSumWithArray(array, target))); // [0, 1]
        System.out.println(Arrays.toString(twoSumWithArrayList(array, target))); // [0, 1]
        System.out.println(Arrays.toString(twoSumRandom(array, target))); // [1, 0]
        System.out.println(Arrays.toString(twoSumWithLoop(array, target))); // [0, 1]
        
    }
    public static int[] twoSum(int[] numbers, int target) {
        int arr[]=new int[2];
        for(int i=0;i<numbers.length;i++){ // for(int i = 1; i < numbers.length; i++){
          for(int j=i+1;j<numbers.length;j++){ // for( int j = 0; j < i; j++){
            if(numbers[i]+numbers[j]==target){ // if((numbers[j] + numbers[i]) == target){
                arr[0]=i; // res[0] = j;
                arr[1]=j; // res[1] = i; break;
            }
          }
          
        }
        return arr; // Do your magic!
    }
    public static int[] twoSumSecond(int[] numbers, int target)
    {
       for(int i = 0; i < numbers.length; i++) {
           for(int j = i + 1; j < numbers.length; j++) {
               if(numbers[i] + numbers[j] == target){
                   return new int[]{i, j};
               }
           }
       }
      return null; 
    }
    public static int[] twoSumWithMap(int[] numbers, int target) {
        Map<Integer, Integer> numToIndexMapping = new HashMap<>(numbers.length);
        for(int i = 0; i < numbers.length; i++) {
          if(numToIndexMapping.containsKey(target - numbers[i])) {
            return new int[] { i, numToIndexMapping.get(target - numbers[i]) };
          } else {
            numToIndexMapping.put(numbers[i], i);
          }
        }
        return new int[0];
    }

    public static int[] twoSumWithMap2(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      int complement = 0,j=0;
      for (int i = 0; i < nums.length; i++) {
          complement = target - nums[i];

          if (map.containsKey(complement)) {
              return new int[] { map.get(complement), i };
          }
        map.put(nums[i], i);
      }
return new int[] { map.get(complement), j };
  }

  public static int[] twoSumWithArray(final int[] numbers, int target) {
    int[] resultIndexArray;
    int index1 = 0;
    int index2 = 0;
   
     for (int i = 0; i < numbers.length; i++) {
       for (int j = i + 1; j < numbers.length; j++) {
         if (numbers[i] + numbers[j] == target) {
           index1 = i;
           index2 = j;
         }
       }
     }
     resultIndexArray = new int [] {index1, index2};
     return resultIndexArray;
 }

 public static int[] twoSumWithArrayList(int[] numbers, int target) {
  ArrayList<Integer> lst = new ArrayList<>();
  for (int i = 0; i < numbers.length; i++) {
    if (lst.contains(numbers[i])) 
      return new int[] { lst.indexOf(numbers[i]), i };  
    lst.add(target - numbers[i]); 
  }
  return null;
}

  public static int[] twoSumRandom(int[] numbers, int target){

    while (true){ // Je sais. Je suis trés gentil

      int number1 = (int) (Math.random() * numbers.length);
      int number2 =(int) (Math.random() * numbers.length);
      int result = numbers[number1]  +  numbers[number2];
      if(result == target && number1 != number2){
        return new int[] {number1, number2} ;
      }
    }
  }

  public static int[] twoSumWithLoop(int[] numbers, int target)
    {
        for (int i = 0; i < numbers.length; i++)
        for (int j = 0; j < numbers.length; j++)
            if (i != j && numbers[i] + numbers[j] == target) return new int[] {i, j};
        return new int[2];
    }


    
}
