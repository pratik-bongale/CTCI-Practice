package problems.ch1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class URLParser {

    String URLify(String url, int trueLength) {
        // replace spaces, we have extra space at the end of string
        // start from the end and go forward with two pointers

        char[] chArr = url.toCharArray();
        int i = trueLength-1;
        int j = chArr.length - 1;

        // check if we have enough spaces at the end
        long spaceCounts = IntStream.range(0, trueLength).filter( idx -> chArr[idx] == ' ' ).count();
        if ( url.length() != spaceCounts*2 + trueLength ) {
            // not enough spaces at the end
            return url;
        }

        while( i >= 0 ) {
            if( chArr[i] == ' ' ) {
                chArr[j] = '0';
                chArr[j-1] = '2';
                chArr[j-2] = '%';
                j -= 3;
            }
            else {
                chArr[j] = chArr[i];
                j--;
            }
            i--;
        }

        String res = String.valueOf(chArr);

        return res;
    }
}
