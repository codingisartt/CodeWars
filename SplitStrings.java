import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStrings {
    public static void main(String[] args) {
        /**
         * Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').
        'abc' =>  ['ab', 'c_']
        'abcdef' => ['ab', 'cd', 'ef']
         */
        
        System.out.println(Arrays.toString(solution("")));
        System.out.println(Arrays.toString(solutionBest("abcedf")));
        System.out.println(Arrays.toString(solutionWithCharAt("abcde")));
        System.out.println(Arrays.toString(solutionWithList("abcde")));
        System.out.println(Arrays.toString(solutionWithStringBuilder("abcde")));
        System.out.println(Arrays.toString(solutionShortest("abcde")));
        System.out.println(Arrays.toString(solutionTryCatch("abcd")));
        System.out.println(Arrays.toString(solutionWithAnother("abcde")));
        System.out.println(Arrays.toString(solutionWithRegex("abcde")));

    }
    
        public static String[] solution(String s) {
            String[] arr=s.split("");
            String res[]=new String[(int) Math.round(arr.length/2.0)];
            int k=0;
            if(!arr.equals(res)){// arr -> [] , res -> [null]
                //res[k]=arr[0];
                return arr;
            }
            for (int i = 1; i < arr.length; i+=2) {
                if(arr.length%2==0){//ab cd ef 1 3 5
                    res[k]=arr[i-1]+arr[i];
                    k++;
                    if(i==arr.length){
                        break;
                    }                                   
                }else{  
                    res[k]=arr[i-1]+arr[i];
                    k++;
                    if(arr[i]==arr[arr.length-2]){
                        res[k]=arr[i+1]+"_";
                        break;
                    }
                } 
            }
            
            return res;
        }

        static String[] solutionShortest(String s) {
            return (s + (s.length() % 2 > 0 ? "_" : "")).split("(?<=\\G.{2})");
          }

        public static String[] solutionBest(String s) {
            /**
            "a;b;c;d".split("(?<=;)")            // Results in ["a;", "b;", "c;", "d"]
            "a;b;c;d".split("(?=;)")             // Results in ["a", ";b", ";c", ";d"]
            "a;b;c;d".split("((?<=;)|(?=;))")    // Results in ["a", ";", "b", ";", "c", ";", "d"]
             */

            s = (s.length() % 2 == 0)?s:s+"_";
            return s.split("(?<=\\G.{2})");//"(?<=\\G..)"
        }

        public static String[] solutionWithCharAt(String s) {
            //Write your code here
            if(s.length()%2==1) s+="_";
            int n=s.length()/2;
          
          String[] sub=new String[n];
          for(int i=0;i<n;++i)
          sub[i]=""+s.charAt(i*2)+s.charAt(1+i*2);
          
          return sub;
        }

        public static String[] solutionWithList(String s) {
            List<String> result = new ArrayList<String>();
            if(s.length() %2 == 1){
              s = s+"_";
            }
            for(int i=0;i<s.length() - 1;i+=2){
               result.add(s.substring(i, i+2));
            }
            
            return result.toArray( new String[0] );
        }

        public static String[] solutionWithStringBuilder(String s) {
            StringBuilder builder = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            for (char ch : s.toCharArray()) {
                builder.append(ch);
                if (builder.length() == 2) {
                    list.add(builder.toString());
                    builder.setLength(0);// ***
                }
            }
            if (builder.length() == 1) {
                builder.append('_');
                list.add(builder.toString());
            }
            
            return list.toArray(new String[0]);
        }

        public static String[] solutionTryCatch(String s){
            String[] result = new String [s.length()%2==0? s.length()/2:(s.length()+1)/2];
            if(s.length() == 0) {return result;}
            try {
              for(int i = 0, j = 0; i < result.length; i++,j+=2) {
                result[i] = (s.charAt(j)+""+s.charAt(j+1));
                if(i == result.length-1) {return result;}
              }
            }catch(Exception e) {}

            result[result.length-1] = (s.charAt(s.length()-1)+"_");
            
            return result;
        }

        public static String[] solutionWithAnother(String s) {
            int slen = s.length();
            String ret[] = new String[(slen + 1) / 2];
            for (int i = 0; i < ret.length; i++) {
              int a = i * 2, b = a + 1;
              ret[i] = "" + s.charAt(a) + (b < slen ? s.charAt(b) : "_");
            }
            return ret;
        }

        public static String[] solutionWithRegex(String s) {
        
            ArrayList<String> respuesta = new ArrayList<String>();
        
            if (s.length()%2!=0) 
                s=s+"_";
        
            for(int i=0; i<s.length(); i=i+2) 
                respuesta.add(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)));
            
            return respuesta.toArray(new String[0]);
        
        }

    
}
