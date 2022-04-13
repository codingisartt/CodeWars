public class BitCounting {
    //Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.

    //Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
    public static void main(String[] args) {
        System.out.println(countBits(1234));
        System.out.println(countBitsShortest(1234));
        System.out.println(countBitsLogical(1234));
        System.out.println(countBitstoBinaryString(1234));
        System.out.println(countBitsDiff(1234));
        System.out.println(countBitsRecursive(1234));
        System.out.println(countBitsShifting(1234));
        System.out.println(countBits0b1(1234));
    }
    public static int countBits(int n){
		int num=Math.abs(n);
        String a="",reverse="";
        int counter=0;
        while(num>=1){
            a+=""+num%2;
            num=num/2;
        }
        for (int i = a.length()-1; i >= 0; i--) {
            reverse+=a.charAt(i);
            if(a.charAt(i) == '1') 
                counter++;
         
        }
           
        return counter;
	}

    public static int countBitsShortest(int n){
    
        return Integer.bitCount(n);
    }

    public static int countBitsLogical(int n){
        int ret = n % 2;
        while ((n /= 2) > 0) ret += n % 2;
        return ret;
    }

    public static int countBitstoBinaryString(int n){
        /*   2.way
        String s = Integer.toBinaryString(n);
        return  s.length() - s.replace("1", "").length();
        */ 
        //return Integer.toBinaryString(n).replaceAll("0","").length();  3.way
        return (int) Integer.toBinaryString(n).chars()
                  .filter(c -> c == '1')
                  .count();
    }

    public static int countBitsDiff(int n) {
        int i = 0;
        //  x & 1 is equivalent to x % 2.
        //  x >> 1 is equivalent to x / 2

        for (int j = n; j > 0; j>>=1) {
            i += j & 1;
        }

        return i;
    }

    public static int countBitsRecursive(int n){
        return n == 0 ? 0 : (n & 1) + countBits(n >>> 1);
    }

    public static int countBitsArray(int number){
        int res = 0;
        String[] digits = Integer.toBinaryString(number).split("");
        for (String digit : digits)
          if (digit.equals("1"))
            res++;
        return res;
    }

    public static int countBitsShifting(int n){
        // Show me the code!
        int sum = 0;
        for (int i=0; i<32; i++) {
            int bitmask = 1 << i;
            if ((bitmask & n) != 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public static int countBits0b1(int n){
        int res = 0;
        while(n != 0) {
          res += n & 0b1;
          n = n >> 1;
        }
        
        return res;
      }


}
