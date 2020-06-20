package problems.ch1;

public class SubstringChecker {

    boolean isSubstring(String s1, String s2) {
        // is S1 a substring of S2
        int n = s1.length();
        for (int i = 0; n+i < s2.length(); i++) {
            if( s2.substring(i, n+i).equals(s1) ) {
                return true;
            }
        }

        return false;
    }

    boolean isRotation(String s1, String s2) {
        // is S2 a rotation of S1
        // you can call isSubstring only once
        if(s1.length() != s2.length())
            return false;

        String s3 = s2.concat(s2);   // xy -> rotation = yx, concat gives yxyx, use isSubstring
        return isSubstring(s1, s3);
    }
}
