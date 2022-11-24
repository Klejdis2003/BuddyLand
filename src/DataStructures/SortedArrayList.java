package DataStructures;

import User.Buddy;
import java.util.ArrayList;


public class SortedArrayList extends ArrayList<Buddy> {

    /*
     * Variation of ArrayList which is always ordered.
     * It uses binary search to find the index at which
     * a certain element has to be added to.
     * */
    public SortedArrayList() {
        super();
    }

    @Override
    public boolean add(Buddy buddy) {
        if (size() == 0) super.add(buddy);
        else {
            int index = getInsertingIndex(buddy);
            add(index, buddy);
        }
        return true;
    }

    public int binarySearch(Buddy buddy) {

        /*
            Slightly modified binary search algorithm to
            return the last traversed position if no match is found
         */

        int low = 0;
        int high = size() -1;
        int mid = 0;
        Buddy pivot = null;
        while (high >= low) {
            mid = (low + high) / 2;
            pivot = get(mid);
            if (buddy.equals(pivot)) return mid;
            else if (buddy.compareTo(pivot) > 0) low = mid + 1;
            else {
                high = mid;
            }
            if(high == low) return low;
        }
        return mid;
    }

    public int getInsertingIndex(Buddy buddy) {
        /*
        Gets the binary search last traversed term and sees if our buddy username is
        higher or lower lexographically. If the new buddy username lexographical value
        is higher, we return the index of the element to the right of the last traversed
        term, otherwise we input at exactly this index, pushing every other element to the
        right.
         */

        int lastTraversedIndex = binarySearch(buddy);
        if (size() >= 1) { //determines whether the element needs to be added before or after our pivot
            if(size() == 1){
                if(buddy.compareTo(get(0)) > 0) return lastTraversedIndex + 1;
                else{
                    return lastTraversedIndex;
                }
            }
            if (buddy.compareTo(get(lastTraversedIndex)) > 0)
                return lastTraversedIndex + 1;
            else {
                return lastTraversedIndex;
            }
        }
        return 0;

    }
    public boolean contains(Buddy buddy){
        if(size()==0) return false;
        else if(size() == 1) return buddy.equals(get(0));

        int index = binarySearch(buddy);
        return get(index).equals(buddy);
    }
}
