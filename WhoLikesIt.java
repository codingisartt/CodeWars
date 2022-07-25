import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhoLikesIt {
    /*You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

    Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:
    Output:
    []                                -->  "no one likes this"
    ["Peter"]                         -->  "Peter likes this"
    ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
    ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
    ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
 */
    public static void main(String[] args) {
        System.out.println(whoLikesItFormat());
        System.out.println(whoLikesIt("Peter","Jack"));
        System.out.println(whoLikesItTernary("Tuba","Ayşe","Zeynep"));
        System.out.println(whoLikesItStatic("Ahmet","Mehmet","Yusuf","Meryem"));
        System.out.println(whoLikesItStringBuilder("Salih"));
        System.out.println(whoLikesItStringBuilder2("Zehra","Fatma","Derya","Kemal","Ümit"));
    }
    public static String whoLikesIt(String... names) {
        //Do your magic here
        if(names.length==0){
            return "no one likes this";
        }else if(names.length==1){
            return names[0]+" likes this";
        }else if(names.length==2){
            return names[0]+" and "+names[1]+" like this";
        }else if(names.length==3){
            return names[0]+", "+names[1]+" and "+names[2]+" like this";
        }else
            return names[0]+", "+names[1] +" and "+(names.length-2)+" others like this";
       
    }
    public static String whoLikesItFormat(String... names) {
        switch (names.length) {
          case 0: return "no one likes this";
          case 1: return String.format("%s likes this", names[0]);
          case 2: return String.format("%s and %s like this", names[0], names[1]);
          case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
          default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
    public static String whoLikesItTernary(String... names) {
        final String Template1 = "%s likes this";
        final String Template2 = "%s and %s like this";
        final String Template3 = "%s, %s and %s like this";
        final String TemplateN = "%s, %s and %d others like this";
        return
            names.length == 0 ? "no one likes this" :
            names.length == 1 ? String.format(Template1, names[0]) :
            names.length == 2 ? String.format(Template2, names[0], names[1]) :
            names.length == 3 ? String.format(Template3, names[0], names[1], names[2]) :
            String.format(TemplateN, names[0], names[1], names.length-2);
    }


    private static Map<Integer, String> choices = new HashMap<>();

    static {
        choices.put(0, "no one likes this");
        choices.put(1, "%s likes this");
        choices.put(2, "%s and %s like this");
        choices.put(3, "%s, %s and %s like this");
    }

    public static String whoLikesItStatic(String... names) {
        int namesCount = names.length;
        return namesCount <= 3 ?
                String.format(choices.get(namesCount), names) :
                String.format("%s, %s and %s others like this", names[0], names[1], namesCount - 2);
    }

    public static String whoLikesItStringBuilder(String... names) {
        //Do your magic here
        
        StringBuilder output = new StringBuilder();
        
        List<String> values = Arrays.asList(names);
        
        if (values.isEmpty()) {
          output.append("no one likes this");
        } else if (values.size() == 1) {
          output.append(values.get(0))
          .append(" likes this"); 
        } else if (values.size() == 2) {
          output.append(values.get(0))
          .append(" and ")
          .append(values.get(1))
          .append(" like this");
        } else if (values.size() == 3) {
          output.append(values.get(0))
          .append(", ")
          .append(values.get(1))
          .append(" and ")
          .append(values.get(2))
          .append(" like this");
        } else {
          output.append(values.get(0))
          .append(", ")
          .append(values.get(1))
          .append(" and ")
          .append(values.size() - 2)
          .append(" others like this");        
        }
        
        return output.toString();
    }

    public static String whoLikesItStringBuilder2(String... names) {
        if (names == null || names.length == 0) return "no one likes this";
        StringBuilder likes = new StringBuilder();
        if (names.length == 1) {
            likes.append(names[0]);
            return likes.append(" likes this").toString();
        }
        if (names.length == 2)
            likes.append(names[0]).append(" and ").append(names[names.length - 1]);
        if (names.length > 2 && names.length < 4)
            likes.append(names[0]).append(", ").append(names[1]).append(" and ").append(names[2]);
        if (names.length > 3) {
            likes.append(names[0]).append(", ").append(names[1]).append(" and ").append(names.length - 2).append(" others");
        }
        return likes.append(" like this").toString();
    }
}
