import java.util.Scanner;

public class EndsWith {
    public static boolean solution(String str, String ending) {

        StringBuffer strRev = new StringBuffer(str);
        StringBuffer endingRev = new StringBuffer(ending);

        strRev.reverse().toString();
        endingRev.reverse().toString();

        if (str.length() >= ending.length()) {

            for (int i = 0; i<ending.length();i++){
                if (strRev.charAt(i) != endingRev.charAt(i)) {
                    return false;
                }
            }

            return true;
        }
        else {
            return false;}
    }
    public static boolean solutionArray(String str, String ending) {
        char[] strung = str.toCharArray(), out = ending.toCharArray();
        if (out.length>strung.length) return false;
        for (int i=0; i<(out.length); i++)
          if (strung[(strung.length-1)-i]!=out[(out.length-1)-i])
            return false;
        return true;
      }
    public static boolean solutionbest(String str, String ending) {
        return str.endsWith(ending);
      }
    public static boolean solution2(String start, String end){
        return (start.length()>=end.length()) ? start.substring(start.length()-end.length()).equals(end) : false;
    }
    public static boolean solutionTernary(String str, String ending) {
        return str.length() >= ending.length() ? 
        str.substring(str.length()-ending.length()).equals(ending) : false;
    
      }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String ending=scan.nextLine();
        System.out.println(solution(str, ending));
        System.out.println(solution2(str, ending));
        System.out.println(solutionbest(str, ending));
        System.out.println(solutionArray(str, ending));
        System.out.println(solutionTernary(str, ending));
        scan.close();
    }
    
}