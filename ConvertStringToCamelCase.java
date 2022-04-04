import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ConvertStringToCamelCase {
    public static void main(String[] args) {
        /**
        Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
        "the-stealth-warrior" gets converted to "theStealthWarrior"
        "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
         */

        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCaseCleverest("the-stealth-warrior"));
        System.out.println(toCamelCaseArraysStream("the-stealth-warrior"));
        System.out.println(toCamelCaseWithArray("the-stealth-warrior"));
        System.out.println(toCamelCaseWithTernaryBuffer("the-stealth-warrior"));
        System.out.println(toCamelCaseWithStream("the-stealth-warrior"));
        System.out.println(toCamelCaseShortest("the-stealth-warrior"));
        System.out.println(toCamelCaseWithBuilder("the-stealth-warrior"));
        System.out.println(toCamelCasePossible("the-stealth-warrior"));
        
    }
    static String toCamelCase(String s){       
        StringBuilder builder=new StringBuilder(s);
        //System.out.println(builder.length()); //19
        for (int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i)=='_'){
                builder.replace(i, i+1, "");
                builder.setCharAt(i,Character.toUpperCase(builder.charAt(i)));
            }else if(builder.charAt(i)=='-'){
                builder.replace(i, i+1, "");
                builder.setCharAt(i,Character.toUpperCase(builder.charAt(i)));
            }
        }
       
        return builder.toString();
        
       
    }

    static String toCamelCasePossible(String s){
        String result = "";
        char[] chars =  s.toCharArray();
        for(int ii = 0; ii < chars.length; ii++) {
          if(chars[ii] == '-' || chars[ii] == '_') {
            result += Character.toUpperCase(chars[ii + 1]);
            ii++;
          } else {
            result += chars[ii];
          }
        }
        return result;
    }

    static String toCamelCaseCleverest(String s){
        Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
        StringBuffer sb = new StringBuffer(); 
        
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        return m.appendTail(sb).toString();
      }

    static String toCamelCaseArraysStream(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    static String toCamelCaseWithStream(String s){
        String[] stringArray = s.split("[-|_]");

        /**
        return Arrays.stream(words).skip(1).map(w -> w.substring(0, 1).toUpperCase().concat(w.substring(1)))
        .reduce(words[0], String::concat);
         */
        return stringArray[0] + Arrays.stream(stringArray).skip(1).map(i -> i.substring(0,1).toUpperCase()+i.substring(1)).collect(Collectors.joining());
    }

    static String toCamelCaseWithArray(String s){
        String[] words = s.split("[_\\-]");
        s=words[0];//the
        for(int i=1; i<words.length; i++)
          s+=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
        return s;
    }

    static String toCamelCaseWithTernaryBuffer(String s){
        StringBuffer sb = new StringBuffer();
        
        boolean flToUpperCase = false;
        for ( char ch: s.toCharArray() ) {
          if ( ch == '-' || ch == '_' )
            flToUpperCase = true;
          else {
            sb.append( ( flToUpperCase ) ? Character.toUpperCase(ch) : ch ); //  ***
            flToUpperCase = false;
          }
        }
        
        return sb.toString();
    }

    static String toCamelCaseShortest(String s){
        return Pattern.compile("[-|_](.)").matcher(s).replaceAll(r -> r.group(1).toUpperCase());
    }

    static String toCamelCaseWithBuilder(String s){
        StringBuilder result = new StringBuilder();
        boolean capitalize = false;
        
        for(char c : s.toCharArray()){
          if(c == '-' || c == '_'){
            capitalize = true;
          }else{
            if(capitalize){
              c = Character.toUpperCase(c);
              capitalize = false;
            }
            
            result.append(c);
          }
        }
        
        return result.toString();
    }  
    
}
