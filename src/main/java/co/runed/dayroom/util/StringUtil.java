package co.runed.dayroom.util;

import java.util.Collection;

public class StringUtil {
    public static boolean wildcardMatch(String input, String match) {
        return input.matches(createRegexFromGlob(match));
    }

    public static boolean anyWildcardMatch(Collection<String> inputs, String match) {
        for (var input : inputs) {
            if (wildcardMatch(input, match)) return true;
        }

        return false;
    }

    public static String createRegexFromGlob(String glob) {
        var out = new StringBuilder("^");
        for (var i = 0; i < glob.length(); ++i) {
            final var c = glob.charAt(i);
            switch (c) {
                case '*' -> out.append(".*");
                case '?' -> out.append('.');
                case '.' -> out.append("\\.");
                case '\\' -> out.append("\\\\");
                default -> out.append(c);
            }
        }
        out.append('$');
        return out.toString();
    }
}
