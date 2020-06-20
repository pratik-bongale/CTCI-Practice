package problems.ch1;

import java.util.*;

public class NumberToEnglishPhrase {

    String[] englishPhrasesMultiplesOfTen;
    String[] englishPhrasesLessThanTwenty;

    public NumberToEnglishPhrase() {

        this.englishPhrasesLessThanTwenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        this.englishPhrasesMultiplesOfTen = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    }

    String convertToPhrase(int n) {

        List<String> wordList = new LinkedList<>();
        List<String> threeDigitWordList;
        if(n == 0) return "Zero";
        int batchCtr = 0;

        String[] batch = {"", "Thousand", "Million", "Billion", "Trillion"};
        while(n > 0) {
            int nBatch = n % 1000;
            threeDigitWordList = convertThreeDigitsToPhrase(nBatch);
            threeDigitWordList.add( batch[batchCtr] );
            wordList.addAll( 0, threeDigitWordList );
            batchCtr++;
            n = n / 1000;
        }

        StringBuilder res = new StringBuilder();
        for( Iterator<String> iter = wordList.iterator();  iter.hasNext(); ) {
            String s = iter.next();
            if( !s.equals("") ) {
                res.append(s);
                res.append(" ");
            }
        }

        //return String.join(" ", wordList).trim();
        return res.toString().trim();

    }

    List<String> convertThreeDigitsToPhrase(int n) {
        // assuming n is 3 digit
        List<String> res = new LinkedList<>();

        if( n < 1000 ) {
            if(n < 20) {
                res.add(this.englishPhrasesLessThanTwenty[n]);
            } else if( n < 100 ) {
                int tens = (n/10)%10;
                int units = n%10;
                res.add(this.englishPhrasesMultiplesOfTen[tens]);
                res.add(this.englishPhrasesLessThanTwenty[units]);
            } else {
                int hundreds = (n/100)%10;
                res.add(this.englishPhrasesLessThanTwenty[hundreds]);
                res.add("Hundred");
                res.addAll(convertThreeDigitsToPhrase(n%100));
            }
        }

        return res;
    }
}
