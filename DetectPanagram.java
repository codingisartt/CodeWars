import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

public class DetectPanagram {
    /**
     A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

    Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     */
    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkChar("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkStream("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkWithHashSet("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkIntStream("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkForEach("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkLists("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkMapToObj("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkIndexOf("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkCleverLogic("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkHashSet("The quick brown fox jumps over the lazy dog"));

    }

    public static boolean check(String sentence){
        String str=sentence.replaceAll("[^A-Za-z]", "").toLowerCase();
        String[] letters="abcdefghijklmnopqrstuvwxyz".split("");
        int count=0;
        for (int i = 0; i < letters.length; i++) {
            if(str.contains(letters[i])){
                count++;
                if(count==26)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkChar(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

    }

    public static boolean checkIndexOf(String sentence){

        String neu = sentence.toLowerCase();
        for (char c = 'a'; c <= 'z'; c++) {
            if (neu.indexOf(c) == -1) {
              return false;
            }
          }
      
          return true;
        }

        public static boolean checkCleverLogic(String sentence){
            //return 27 <= (int) sentence.toLowerCase().chars().distinct().count();
            return sentence.length() - sentence.toLowerCase().replaceAll("[a-z]", "").length() > 25;
          }

    public static boolean checkStream(String sentence){
        //return sentence.toLowerCase().chars().filter(i -> i >= 'a' && i <= 'z').distinct().count()== 26; 

        //return sentence.toLowerCase().chars().filter(Character::isLetter).distinct().count() == 26;

        //return sentence.toLowerCase().chars().distinct().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining("")).contains(ALL_LETTERS);

        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

    public static boolean checkHashSet(String s){
        // wrong solution !!! should not be false
        return new HashSet<>(Arrays.asList(s.toUpperCase().replaceAll("[^A-Z]","").split(""))).size() == 26;
    }

    public static boolean checkWithHashSet(String sentence){
        String str = sentence.toLowerCase().replaceAll("[^a-z]", "");
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
          set.add(c);
        }
        return set.size() == 26;
    }

    public static boolean checkIntStream(String inputSentence){
        String loweredInput = inputSentence.toLowerCase();
        return IntStream.range('a', 'z' + 1).allMatch(a -> loweredInput.indexOf(a) >= 0);
    }

    public static boolean checkForEach(String sentence){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        for (char letter: alph.toCharArray()) {
            if (!sentence.toLowerCase().contains(String.valueOf(letter))) return false;
        }
        return true;
   }
   public static boolean checkLists(String sentence){
    
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    List<String> sentence_chars = Arrays.asList( sentence.toLowerCase().split("") );
    List<String> alphabet_chars = Arrays.asList( alphabet.split("") );
    
    return sentence_chars.containsAll( alphabet_chars ); 
   }

   public static boolean checkMapToObj(String sentence){
    //return sentence.toLowerCase().chars().mapToObj(i -> (char)i).filter(Character::isAlphabetic).distinct().count() == 26;

    return sentence.toLowerCase().replaceAll("[^a-z]", "").chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet()).size() == 26;
  }


    

}
