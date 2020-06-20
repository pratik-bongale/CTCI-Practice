package problems.ch1;

public class MagicIndex {

    int getMagicIndexFromDistinctArr(int[] arrSorted) {
        // return -1 if not found
        return getMagicIndexFromDistinctArrHelper(arrSorted, 0, arrSorted.length-1);
    }

    int getMagicIndexFromDistinctArrHelper(int[] arr, int l, int r) {
        if (l > r) {
            return -1;
        } else {
            int mid = l + ((r - l) / 2);
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] < mid) {
                return getMagicIndexFromDistinctArrHelper(arr, mid + 1, r);
            } else {
                return getMagicIndexFromDistinctArrHelper(arr, l, mid - 1);
            }
        }
    }

    int getMagicIndexFromArrayWithDuplicates(int[] arrSorted) {
        //return -1 if not found
        return getMagicIndexFromArrayWithDuplicatesHelper(arrSorted, 0, arrSorted.length-1);
    }

    int getMagicIndexFromArrayWithDuplicatesHelper(int[] arr, int l, int r) {

        if( l > r ) {
            return -1;
        } else {
            int mid = l + ((r-l)/2);
            if(arr[mid] == mid) {
                return mid;
            } else if(arr[mid] < mid) { // ex mid = 5, a[mid] = 3, then look for a[0..3] and a[6..n]
                int leftSubArrayIndex = getMagicIndexFromArrayWithDuplicatesHelper(arr, l, arr[mid]);
                if(leftSubArrayIndex == -1) return getMagicIndexFromArrayWithDuplicatesHelper(arr, mid+1, r);
                else return leftSubArrayIndex;
            } else { // if(arr[mid] > mid) { // ex mid = 5, a[mid] = 8, then look for a[0..4] and a[8..n]
                int leftSubArrayIndex = getMagicIndexFromArrayWithDuplicatesHelper(arr, l, mid-1);
                if(leftSubArrayIndex == -1) return getMagicIndexFromArrayWithDuplicatesHelper(arr, arr[mid], r);
                else return leftSubArrayIndex;
            }
        }
    }

}
