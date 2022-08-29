import java.util.ArrayList;
import java.util.Arrays;
import static java.util.stream.IntStream.of;

public class FindTheMissingTerm {
    /**
     An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms of a given series of numbers. You are provided with consecutive elements of an Arithmetic Progression. There is however one hitch: exactly one term from the original series is missing from the set of numbers which have been given to you. The rest of the given series is the same as the original AP. Find the missing term.

    You have to write a function that receives a list, list size will always be at least 3 numbers. The missing term will never be the first or last one.

    Example
    findMissing([1, 3, 5, 9, 11]) == 7
    PS: This is a sample question of the facebook engineer challenge on interviewstreet. I found it quite fun to solve on paper using math, derive the algo that way. Have fun!
     
     */
    public static void main(String[] args) {
        int[] array={1, 2, 4}; 
        System.err.println(findMissing(array));
        System.out.println(findMissingWithStreamOf(array));
        System.out.println(findMissingBasic(array));
        System.out.println(findMissingSimilar(array));
        System.out.println(findMissingStream(array));
    }
    public static int findMissing(int[] numbers){
    // TODO: code me
    int value=((numbers[numbers.length-1]) - (numbers[0])) / (numbers.length);
    Arrays.sort(numbers);
    for (int i = 1; i < numbers.length; i++) {
        if( numbers[i-1]+value!=numbers[i]){
            return numbers[i-1]+value;
        }
    }
    return numbers[numbers.length-1];
	}
    
    static int findMissingWithStreamOf(int[] numbers) {
        return (numbers[0] + numbers[numbers.length - 1]) * (numbers.length + 1) / 2 - of(numbers).sum(); //import static java.util.stream.IntStream.of;
    }

    public static int findMissingBasic(int[] numbers){
        final int diffNumber = numbers[1] - numbers[0]; 
  
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] == numbers[i -1] || numbers[i - 1] + diffNumber != numbers[i])
                return numbers[i] - diffNumber;
        }
        return 0;
    }

    public static int findMissingSimilar(int[] numbers){
        int result = numbers[0];
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i + 2] - numbers[i + 1] != numbers[i + 1] - numbers[i]) {
                result = numbers[i + 2] - (numbers[i + 1] - numbers[i]);
                break;
            }
        }
        return result;
    }

    public static int findMissingStream(int[] numbers) {
        return (numbers[0] + numbers[numbers.length - 1]) * (numbers.length + 1) / 2 - Arrays.stream(numbers).sum();
      }
}
