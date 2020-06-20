package problems.ch1;

public class IsUnique {

    public boolean isUnique( String s ) {
        // assuming that only ascii characters are used in 's'

        if ( s.length() > 128 ) return false; // cannot have more than 128 unique characters

        boolean charSet[] = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            int chIndex = s.charAt(i);

            if( charSet[chIndex] == true ) {
                return false;   // found a duplicate
            }
            charSet[chIndex] = true;
        }

        return true;
    }

    public boolean isUniqueBitVector( String s ) {
        // assuming that only lowercase characters(a-z) are given as input
        int bitVector = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';

            if( val >= 0 && val <= 32 && (bitVector & (1<<val)) != 0 ) {
                return false;
            }

            bitVector |= 1 << val;
        }

        return true;
    }

}
