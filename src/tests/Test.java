package tests;

import DataStructures.SortedArrayList;
import User.Buddy;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int size = (int)Math.pow(10, 3)*50;
        SortedArrayList arr = new SortedArrayList();
        TreeSet<Buddy> treeSet = new TreeSet<>(Buddy::compareTo);

        double sumOfTreeTimes = 0;
        double sumOfArrTimes = 0;
        Random rnd = new Random();
        for(int i = 0; i < 10; i++) {
            String[] ar = buildArrayWithRandomWords(size);
            long timeBeforeArrayListWhenAdding = System.nanoTime();
             arr = new SortedArrayList();
            for (int j = 0; j < size; j++) {
                Buddy b = new Buddy(ar[j]);
                if (!arr.contains(b))
                    arr.add(b);
            }

            long timeAfterArrayListWhenAdding = System.nanoTime();

            //System.out.printf("The array took %d nanoseconds to be created%n", timeAfterArrayListWhenAdding - timeBeforeArrayListWhenAdding);
            long timeBeforeTreeSetWhenAdding = System.nanoTime();
            treeSet = new TreeSet<>(Buddy::compareTo);
            for (int j = 0; j < size; j++) {
                treeSet.add(new Buddy(ar[j]));
            }
            long timeAfterTreeSetWhenAdding = System.nanoTime();
            //System.out.printf("The tree set took %d%n ", (timeAfterTreeSetWhenAdding - timeBeforeTreeSetWhenAdding));

            long timeForArr = timeAfterArrayListWhenAdding - timeBeforeArrayListWhenAdding;
            long timeForTree = timeAfterTreeSetWhenAdding - timeBeforeTreeSetWhenAdding;
            sumOfArrTimes += timeForArr*Math.pow(10, -9);
            sumOfTreeTimes += timeForTree*Math.pow(10, -9);
            //System.out.printf("Tree is %f seconds faster%n", (timeForArr - timeForTree) * Math.pow(10, -9));
            System.out.printf("Arr size: %d, TreeSet Size: %d%n", arr.size(), treeSet.size());
        }
        System.out.println(sumOfArrTimes/10);
        System.out.println(sumOfTreeTimes/10);
        double averageDifference = (double) ((sumOfArrTimes-sumOfTreeTimes)/10);
        System.out.printf("On average, tree is %f seconds faster%n", averageDifference);

        long t1 = System.nanoTime();
        arr.add(new Buddy("ndosahfekjafuhs"));
        long t2 = System.nanoTime();
        treeSet.add(new Buddy("ndosahfekjafuhs"));
        long t3 = System.nanoTime();

        long arrTime = t2-t1;
        long treeTime = t3-t2;
        System.out.println(arrTime);
        System.out.println(treeTime);
        System.out.printf("Tree added one el %f seconds faster", (arrTime-treeTime)*Math.pow(10, -9));


    }

    public static String[] buildArrayWithRandomWords(int size) {

        ArrayList<Character> alphabet = new ArrayList<>(54);
        for(char ch = 'A'; ch <= 'z'; ch++){
            alphabet.add(ch);
        }
        String[] words = new String[size];
        for(int i = 0; i < size; i++){
            Random rnd = new Random();
            StringBuilder word = new StringBuilder();
            for(int j = 0; j < rnd.nextInt(1, 50); j++){
                word.append(alphabet.get(rnd.nextInt(0, alphabet.size())));
            }
           words[i] = word.toString();
            rnd = null;
        }
        return words;
    }



}
