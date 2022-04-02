import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 */
public class FindOutlier {
    public static void main(String[] args) {
        int[] arr={2, 4, 0, 100, 4, 11, 2602, 36};//{160, 3, 1719, 19, 11, 13, -21};
        System.out.println(find(arr));
        System.out.println(findWithStream(arr));
        System.out.println(findWithArray(arr));
        System.out.println(findWithArray(arr));
        System.out.println(findSimple(arr));
        System.out.println(findWithCondition(arr));

        IntStream parallelmi=Arrays.stream(arr).parallel();
        System.out.println(parallelmi);//wrong usage
    }
    static int find(int[] integers){
        int counter1=0,sum1=0,sum2=0;
        for (int i : integers) {
            if(i%2==0){
                counter1++;
                sum1+=i; 
            }else{
                sum2+=i; 
            }
        }
        if(counter1==1){
            return sum1;
        }else{
            return sum2;
        }
    }
    public static int findWithStream(int[] integers){
        // We only need the first 3 integers to determine whether we are chasing odds or evens. ???
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.

        /**  Another very similar way
         * static int find(int[] integers) {
        final int p = stream(integers).limit(3).map(Math::abs).map(i -> i % 2).sum() / 2;
        return stream(integers).filter(i -> Math.abs(i) % 2 != p).findFirst().getAsInt();
        }
         */
        
        int sum=Arrays.stream(integers).limit(3).map(i->Math.abs(i)%2).sum();//.map(Math::abs).map(i->i%2)
        int mod=(sum==0 || sum==1) ? 1 : 0;

        // call parallel to get as much bang for the buck on a "large" array
        return Arrays.stream(integers).parallel().filter(n->Math.abs(n)%2==mod).findFirst().getAsInt();
    }
    static int findWithArrayStream(int[] integers) {
        int[] array = Arrays.stream(integers).filter(i -> i % 2 == 0).toArray();  
        return array.length == 1 ? array[0] : Arrays.stream(integers).filter(i -> i % 2 != 0).findAny().getAsInt();
    }
    static int findWithArray(int[] integers){
        int[] odd = Arrays.stream(integers).filter(n -> n % 2 != 0).toArray();
        int[] even = Arrays.stream(integers).filter(n -> n % 2 == 0).toArray();
    
        return odd.length == 1 ? odd[0] : even[0];
    }
    static int findSimple(int[] integers) {
        int even = 0;
        int odd = 0;
        int cycle = 0;

        for(Integer value : integers) {
            if(value % 2 == 0) {
                cycle++;
                even = value;
            }else {
                odd = value;
            }
        }
        return (cycle > 1) ? odd : even;
    }
    static int findWithCondition(int[] integers){//java.lang.Math.abs() also possible
        if ((Math.abs(integers[0])%2+ java.lang.Math.abs(integers[1])%2+Math.abs(integers[2])%2)<2){
          for (int i : integers)
             if (i%2!=0) return i;
        } else {
          for (int j : integers)
             if (j%2==0) return j;
        }
        return 0;
      }


}
