package problems.ch1;

public class IsPermutation {

    public boolean isPermutation(String s1, String s2) {
        // find if one is a permutation of other

        if(s1.length() != s2.length()) {
            return false;
        } else {
            int len = s1.length();
            int[] counter = new int[128];

            // initialize counter/hashmap
            for (int i = 0; i < len; i++) {
                int index = s1.charAt(i);
                counter[index]++;
            }

            // check map against s2
            for (int i = 0; i < len; i++) {
                int index = s2.charAt(i);
                if(counter[index] <= 0) {
                    return false;

                }
                counter[index]--;
            }
        }

        return true;
    }


}
