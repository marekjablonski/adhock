import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FirstTask {
    private static HashSet<String> quickAccessLibrary = new HashSet<String>();
    private static int maxLength;

    public static void main(String[] args) {
        System.out.println(isWordMadeFromLibrary("abbcbc", Arrays.asList("ab", "b", "abbcbc")));
        preprocessList(Arrays.asList("abc", "bc", "a", "b", "c", ""));
        preprocessList(Arrays.asList("", "c", "b", "a", "bc", "abc"));/* O(n) looping all element to remove
        words that can be made out of others */
        isWordMadeFromLibrary("cbdcdba"); // O(1) searching in hasSet is linear
        //
    }

    private static boolean isWordMadeFromLibrary(final String word, final List<String> library) {
        preprocessList(library);
        return isWordMadeFromLibrary(word);
    }

    public static boolean isWordMadeFromLibrary(final String word) {
        if (word.length() == 0) return true;
        int i = 0;
        while (i < word.length()) {
            i++;
            String leftPart = word.substring(0, i);
            if (quickAccessLibrary.contains(leftPart)) {
                String rightPart = word.substring(i, word.length());
                if (isWordMadeFromLibrary(rightPart)) return true;
            }
        }
        return false;
    }

    private static void preprocessList(final List<String> library) {
        quickAccessLibrary.clear();
        quickAccessLibrary.addAll(library);

        for (String e : library) {
            quickAccessLibrary.remove(e);
            if (!isWordMadeFromLibrary(e)) {
                quickAccessLibrary.add(e);

            }
        }
        System.out.println(quickAccessLibrary);
    }
}
