import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
public class RomanNumeralsEncoder {
    /**
    DESCRIPTION:
    Create a function taking a positive integer as its parameter and returning a string containing the Roman Numeral representation of that integer.

    Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

    Example:

    conversion.solution(1000); //should return "M"
    Help:

    Symbol    Value
    I          1
    V          5
    X          10
    L          50
    C          100
    D          500
    M          1,000
     */
    public static void main(String[] args) {
        System.out.println(solution(956));
        System.out.println(solutionWithMap(956));
        System.out.println(solutionWithWhile(956));
        System.out.println(solutionWithArrays(956));
        System.out.println(solutionWithR(956));
        System.out.println(solutionStringBuilder(956));
        System.out.println(solutionTreeMap(956));
        System.out.println(solutionStringBuffer(956));
        System.out.println(solutionEnum(956));
        System.out.println(solutionRepeat(956));
        System.out.println(solutionRegex(956));
        System.out.println(solutionMultiDimensionalArray(956));
    }
    public static String solution(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L","XC", "C", "CD", "D", "CM", "M" };
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,900, 1000 };
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];       
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }

    
    
    public static String solutionWithMap(int n) {   
        TreeMap<Integer, String> MAP;
   
        MAP = new TreeMap<Integer, String>(Collections.reverseOrder());
        MAP.put( 1, "I" );
        MAP.put( 4, "IV" );
        MAP.put( 5, "V" );
        MAP.put( 9, "IX" );
        MAP.put( 10, "X" );
        MAP.put( 40, "XL" );
        MAP.put( 50, "L" );
        MAP.put( 90, "XC" );
        MAP.put( 100, "C" );
        MAP.put( 400, "CD" );
        MAP.put( 500, "D" );
        MAP.put( 900, "CM" );
        MAP.put( 1000, "M" );
   
        StringBuilder builder = new StringBuilder();
        for( Map.Entry<Integer, String> entry: MAP.entrySet() ){
          int i = entry.getKey();
          String s = entry.getValue();
          while( n>=i ){
            builder.append(s);
            n -= i;
          }      
        }
        return builder.toString();
    }

    public static String solutionWithWhile(int number) {
        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return result.toString();
    }
    
    public static String solutionWithArrays(int n) {
        final String[] digit = {"", "I", "II", "III", "IV", "V", "VI", "VII",
                                  "VIII", "IX"};
        final String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
                                  "LXXX", "XC"};
        final String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
                                  "DCCC", "CM"};
        final String[] thousand = {"", "M", "MM", "MMM"};
        
        String result="";
        result = thousand[n/1000] + hundred[n%1000/100] + ten[n%100/10] +
                  digit[n%10];
        return result;
    }

    
    
    public static String solutionWithR(int n) { 
        final String R1[]    = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        final String R10[]   = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        final String R100[]  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        final String R1000[] = {"", "M", "MM", "MMM" };
        
        return R1000[n/1000]+R100[n%1000/100]+R10[n%100/10]+R1[n%10];
    }

    

    public static String solutionStringBuilder(int n) {

    final int[] arabs = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1, };
    final String[] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    final StringBuilder roman = new StringBuilder();
    int i = 0;
    while (n > 0) {
      if (n >= arabs[i++]) {
        roman.append(romans[--i]);
        n = n - arabs[i];
      }
    }
    return roman.toString();
    } 


    public static String solutionTreeMap(int number) {

        TreeMap<Integer, String> ROMAN_NUMBERS_MAP = new TreeMap<Integer, String>(); // Must use TreeMap -> floorKey Method
    
        ROMAN_NUMBERS_MAP.put(1000, "M");
        ROMAN_NUMBERS_MAP.put(900, "CM");
        ROMAN_NUMBERS_MAP.put(500, "D");
        ROMAN_NUMBERS_MAP.put(400, "CD");
        ROMAN_NUMBERS_MAP.put(100, "C");
        ROMAN_NUMBERS_MAP.put(90, "XC");
        ROMAN_NUMBERS_MAP.put(50, "L");
        ROMAN_NUMBERS_MAP.put(40, "XL");
        ROMAN_NUMBERS_MAP.put(10, "X");
        ROMAN_NUMBERS_MAP.put(9, "IX");
        ROMAN_NUMBERS_MAP.put(5, "V");
        ROMAN_NUMBERS_MAP.put(4, "IV");
        ROMAN_NUMBERS_MAP.put(1, "I");
        
        Integer key = ROMAN_NUMBERS_MAP.floorKey(number);
        if (key == null)
        return "No roman equivalent";
        
        if (number == key.intValue()) // Fits perfectly
        return ROMAN_NUMBERS_MAP.get(number);
        
        return ROMAN_NUMBERS_MAP.get(key) + solution(number - key); // Add rest recursively
    }

  

    public static String solutionStringBuffer(int num) {
    String[][] c={
        {"","I","II","III","IV","V","VI","VII","VIII","IX"},
        {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        {"","M","MM","MMM"}
    };
    StringBuffer roman = new StringBuffer();
      roman.append(c[3][num / 1000 % 10]);
      roman.append(c[2][num / 100 % 10]);
      roman.append(c[1][num / 10 % 10]);
      roman.append(c[0][num % 10]);
    
      return roman.toString();
    }

    enum Numeral {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
    int weight;

    Numeral(int weight) {
        this.weight = weight;
    }
    }

    public static String solutionEnum(int n) {
    StringBuilder buf = new StringBuilder();

    final Numeral[] values = Numeral.values();
    for (int i = values.length - 1; i >= 0; i--) {

        while (n >= values[i].weight) {
            buf.append(values[i]);
            n -= values[i].weight;
        }

    }
    return buf.toString();
   }

   static String solutionRepeat(int n) {
    return "I".repeat(n)
        .replace("IIIII", "V").replace("IIII", "IV")
        .replace("VV", "X").replace("VIV", "IX")
        .replace("XXXXX", "L").replace("XXXX", "XL")
        .replace("LL", "C").replace("LXL", "XC")
        .replace("CCCCC", "D").replace("CCCC", "CD")
        .replace("DD", "M").replace("DCD", "CM");
    }

    public static String solutionRegex(int n) {
        String[] strs = new String[n];
        java.util.Arrays.fill(strs, "I");
        String result = java.util.Arrays.toString(strs).replaceAll("[ \\[\\],]","");
        result = result.replaceAll("[I]{5}","V");
        result = result.replaceAll("[V]{2}","X");
        result = result.replaceAll("[X]{5}","L");
        result = result.replaceAll("[L]{2}","C");
        result = result.replaceAll("[C]{5}","D");
        result = result.replaceAll("[D]{2}","M");
        result = result.replaceAll("D[C]{4}","CM");
        result = result.replaceAll("[L]{4}","CD");
        result = result.replaceAll("L[X]{4}","XC");
        result = result.replaceAll("[X]{4}","XL");
        result = result.replaceAll("V[I]{4}","IX");
        result = result.replaceAll("[I]{4}","IV");
        return result;
    }

    public static String solutionMultiDimensionalArray(int n) {
        String rg = "";    
        // Tausender
        for (int i=0;i<n/1000;i++) rg += "M"; 
        
        // restliche Stellen
        String[][] t = {{"C","D","M"},{"X","L","C"},{"I","V","X"}};
        for(int i=0;i<3;i++) {
          String s = "";
          int c = String.valueOf(n%1000+1000).substring(1).charAt(i) - '0';
          if (c>4) s = t[i][1];
          if (c%5<4) for(int z=0;z<c%5;z++) s += t[i][0];
          if (c==4) s = t[i][0] + t[i][1];
          if (c==9) s = t[i][0] + t[i][2];
          rg += s;
        }
        
        return rg;
    }
}
