import java.util.Arrays;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] words) {
        boolean match = true;
        int count = 0;
        String prefix = "";
        do{
            char value = words[0].charAt(count);
            for(String word: words) {
                if(word.charAt(count) != value)
                    match = false;
            }
            count ++;
            if(match){
                prefix += value;
            }
        } while (match);

        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
