package problems.ch1;

public class PalindromeChecker {
    // find if any permutation of string is a palindrome

    boolean isPermutationOfPalindrome(String s) {
        // only one character can have odd count, all others must have an even count
        // get counts, check odd, even
        // can use bit vector if only ascii lowercase, check with the interviewer if case matters

        int oddCounter = 0;
        int[] charCounter = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for(char c : s.toCharArray()) {
            int index = c - 'a';
            if ( index >= 0 && index < s.length() ) {
                charCounter[index]++;
                if ( charCounter[index] % 2 == 1 ) {
                    oddCounter++;
                } else {
                    oddCounter--;
                }
            }
        }

        return oddCounter <= 1;
    }
}
