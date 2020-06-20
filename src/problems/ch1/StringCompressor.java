package problems.ch1;

public class StringCompressor {

    String compressString(String s) {

        StringBuilder resSb = new StringBuilder();

        int prev_ct = 0;
        char prev_ch = s.charAt(0);
        char curr_ch = s.charAt(0);
        int i = 0;

        while ( i < s.length() && resSb.length()+2 < s.length() ) {
            curr_ch = s.charAt(i);
            if ( curr_ch != prev_ch ) {
                resSb.append(prev_ch);
                resSb.append(prev_ct);
                prev_ct = 1;
                prev_ch = curr_ch;
            } else {
                prev_ct++;
            }
            i++;
        }

        String res;

        if ( resSb.length()+2 < s.length() ) {
            resSb.append(prev_ch);
            resSb.append(prev_ct);
            res = resSb.toString();
        } else {
            res = s;
        }

        return res;

    }

}
