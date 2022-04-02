import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You function receives one side of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

 Input      Output
"ATTGC" --> "TAACG"
"GTAT" --> "CATA"
dnaStrand []        `shouldBe` []
dnaStrand [A,T,G,C] `shouldBe` [T,A,C,G]
dnaStrand [G,T,A,T] `shouldBe` [C,A,T,A]
dnaStrand [A,A,A,A] `shouldBe` [T,T,T,T]
 */
public class ComplementaryDNA {
    public static void main(String[] args) {
        System.out.println(makeComplement("ATTGC"));
        System.out.println(makeComplement2("ATTGC"));
        System.out.println(makeComplementWithReplaceAll("ATTGC"));
        System.out.println(makeComplementWithReplace("ATTGC"));
        System.out.println(makeComplementWithHashMap("ATTGC"));
        System.out.println(makeComplementWithStringBuilder("ATTGC"));
        System.out.println(makeComplementWithException("ATTGC"));
        System.out.println(makeComplementWithEnum("ATTGC"));

        
    }
    public static String makeComplement(String dna) {
        char[] ch=dna.toUpperCase().toCharArray();
        char[] res=new char[ch.length];
        int i=0;
        for (char c : ch) {
            if(c=='A'){
                res[i]='T';
                i++;
            }else if(c=='T'){
                res[i]='A';
                i++;
            }else if(c=='G'){
                res[i]='C';
                i++;
            }else{
                res[i]='G';
                i++;
            }
        }
        String result=String.valueOf(res);
        return result;
    }
    public static String makeComplement2(String dna) {
        char[] chars = dna.toCharArray();
        for(int i = 0; i < chars.length; i++) {
          chars[i] = getComplement(chars[i]);
        }
        
        return new String(chars);
    }
    private static char getComplement(char c) {
        switch(c) {
          case 'A': return 'T';
          case 'T': return 'A';
          case 'C': return 'G';
          case 'G': return 'C';
        }
        return c;
    }

    public static String makeComplementWithReplaceAll(String dna) {
        dna = dna.replaceAll("A","Z");
        dna = dna.replaceAll("T","A");
        dna = dna.replaceAll("Z","T");
        dna = dna.replaceAll("C","Z");
        dna = dna.replaceAll("G","C");
        dna = dna.replaceAll("Z","G");
        return dna;
    }

    public static String makeComplementWithReplace(String dna) {
        return dna.replace("A","B")
                  .replace("C","D")
                  .replace("T","A")
                  .replace("G","C")
                  .replace("B","T")
                  .replace("D","G");
    }

    private static HashMap<Character, Character> map = new HashMap<>(4);
    static {map.put('A', 'T'); map.put('T', 'A'); map.put('C', 'G'); map.put('G', 'C');}
    public static String makeComplementWithHashMap(String dna) {
      return dna.chars().mapToObj(c -> String.valueOf(map.get((char)c))).collect(Collectors.joining());
    }

    public static String makeComplementWithStringBuilder(String dna) {
        char[] chars = dna.toCharArray();
        
        StringBuilder builder = new StringBuilder();
        for (char c : chars){
          switch (c){
          case 'A': {builder.append("T"); break;}
          case 'T': {builder.append("A"); break;}
          case 'C': {builder.append("G"); break;}
          case 'G': {builder.append("C"); break;}
          }
        }
        
        return builder.toString();
    }

    public static String makeComplementWithCondition(String dna) {
    
        if (dna == null || dna.isEmpty()) {
          return dna;
          
        } else {
          char[] chars = dna.toCharArray();
          for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            chars[i] = (c == 'A') ? 'T'
                     : (c == 'T') ? 'A'
                     : (c == 'C') ? 'G'
                     : (c == 'G') ? 'C'
                     : c;      
          }
          return new String(chars);
        }
    }



    private static final Map<String, String> compliments = Map.of(
        "A", "T",
        "T", "A",
        "C", "G",
        "G", "C");

    public static String makeComplementWithException(String dna) {
        if (dna == null || dna.isEmpty()) {
            throw new IllegalStateException(String.format("DNA is either null or empty: %s", dna));
        }
        char[] characters = dna.toCharArray();

        return IntStream.range(0, characters.length)
                .mapToObj(index -> characters[index])
                .map(c -> Character.toString(c))
                .map(compliments::get)
                .collect(Collectors.joining());
    }



    public static String makeComplementWithEnum(String dna) {
        StringBuilder sb = new StringBuilder();
       for (char s : dna.toCharArray()) {
           for (DnaStrandEnum dnaStrandEnum : DnaStrandEnum.values()) {
               if (dnaStrandEnum.name().equalsIgnoreCase(String.valueOf(s))) {
                   sb.append(dnaStrandEnum.getComplement());
               }
           }
       }
       return sb.toString();
    }
    private enum DnaStrandEnum {// Enum structure
       A("T"),
       T("A"),
       C("G"),
       G("C");
       private String complement;

       DnaStrandEnum(String complement) { //constructor
           this.complement = complement;
       }

       public String getComplement() {
           return this.complement;
       }
    }

}
