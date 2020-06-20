package problems.ch1;

public class EditDistanceChecker {

    public boolean isOneEditAway(String s1, String s2) {
        // check if they are one edit away from each other
        // edits: insert, delete, replace one character

        int i = 0, j = 0, edits = 0;

        int lenDiff = s1.length() - s2.length();
        if ( lenDiff > 1 || lenDiff < -1 ) {
            return false;
        }

        while ( i < s1.length() && j < s2.length() ) {

            if ( s1.charAt(i) != s2.charAt(j) ) {
                if ( edits < 1 ) {
                    edits++;
                    if ( lenDiff == 0  ) {
                        i++; j++;   // replace needed
                    } else if ( lenDiff == -1 ) {
                        j++;        // delete / insert
                    } else {
                        i++;        // delete / insert
                    }
                } else {
                    return false;
                }
            } else {
                i++; j++;
            }

        }

        return true;

    }
}
