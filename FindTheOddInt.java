import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import static java.util.Arrays.stream;

import java.util.ArrayList;
public class FindTheOddInt {
    public static void main(String[] args) {
        /*
        Given an array of integers, find the one that appears an odd number of times.

        There will always be only one integer that appears an odd number of times.

        [7] should return 7, because it occurs 1 time (which is odd).
        [0] should return 0, because it occurs 1 time (which is odd).
        [1,1,2] should return 2, because it occurs 1 time (which is odd).
        [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
        [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
        */

        int[] arr={1,2,2,3,3,3,4,3,3,3,2,2,1};
        System.out.println(findIt(arr));
        System.out.println(findItSimilar(arr));
        System.out.println(findItXOR(arr));
        System.out.println(findItStream(arr));
        System.out.println(findItMap(arr));
        System.out.println(FindOddSet(arr));
        System.out.println(findItWithStream(arr));
        System.out.println(findItCollectionFrequency(arr));
        System.out.println(findItGroupingBy(arr));
        System.out.println(findItWithinBoolean(arr));
        
    }

    public static int findIt(int[] a) {
        int counter=1,i;
        
        Arrays.sort(a);
        for (i = 1; i < a.length; i++) {
            if(a[i-1]==a[i]){
                counter++; 
            }else{
                if(counter%2!=0){
                    return a[i-1];
                }
                counter=1;
                
            }
            
        }
        return a[i-1];
    }

    public static int findItSimilar(int[] A) {
    
        // for every int in A, check if that int appears an odd number of times
        for (int i : A) { 
          
          int temp = 0; // to get the number of times I find A[i];
          
          for (int j : A)
            if (j == i)  // get the number of A[i]'s in the array
              temp++;
              
          if (temp % 2 == 1) // if it is odd
            return i; // return the number that appeared an odd number of times
        }
        return 0;
      }
    
    

    public static int findItXOR(int[] A) {
        /*   about single frequency ...  1^2^3^4^5^6=7
        x = z ^ b;  
        y = x ^ b;   =>   z = y .
        */
        int xor = 0; 
        for (int i = 0; i < A.length; i++) {
          xor ^= A[i];
        // XOR will cancel out everytime you XOR with the same number so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
        }
        return xor;
    }

    public static int findItStream(int[] arr) {//import static java.util.Arrays.stream;
        return stream(arr).reduce(0, (x, y) -> x ^ y);
    }

    public static int findItMap(int[] a) {
        Map<Integer, Integer> counts = new HashMap<>(a.length);
        for(int i : a) {// 1 1 2 --> 2
          if(!counts.containsKey(i)) 
            counts.put(i, 1); //1 key 1 value  ->changed    2 key "1 value"
          else 
            counts.put(i, counts.get(i) + 1);// 1 key  "2 value"   value is number (frequency)
        }
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) 
        if(entry.getValue() % 2 == 1) 
        return entry.getKey();
        return 0;
    }

    public static int FindOddSet(int[] A) {
        /*
        Set<Integer> odd = new HashSet<>();
    
        for(int i=0;i<A.length;i++) {
        if(odd.contains(A[i])) odd.remove(A[i]);
        else odd.add(A[i]);      
        }
        return odd.size() > 0 ? odd.iterator().next() : 0;
        */
        final TreeSet<Integer> set = new TreeSet<>();
        for (int x : A) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return set.first();     
    }

    public static int findItWithStream(int[] a) {
        //return Arrays.stream(A).reduce((a, b) -> a ^ b).getAsInt();
        return Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity())).entrySet().stream()
                    .filter(e -> e.getValue().size() % 2 == 1).mapToInt(e -> e.getKey()).findFirst().getAsInt();
    }
    
    public static int findItCollectionFrequency(int[] A) {
  
        //get a list rather so we can use Collections.frequency
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : A) {
            intList.add(i);
        }
        
        for (int i : A) {
            //find the first number with an odd number frequency i.e. mod 2
            if(Collections.frequency(intList, i) % 2 != 0)
              return i;
        }
        return -1;
    }

    public static int findItGroupingBy(int[] ints) {
        return Arrays.stream(ints).boxed().collect(groupingBy(identity(), counting())).entrySet().stream().filter(e -> e.getValue() % 2 != 0).limit(1).findFirst().get().getKey(); // we import groupingby, identitiy and counting methods
    }

    public static int findItWithinBoolean(int[] array) {
        for (int temp : array) {
          if (Arrays.stream(array).filter(i -> i == temp).count() % 2 != 0) {
            return temp;
          }
        }
        return -1;
    }

   



}
