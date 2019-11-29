package btu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Task 1
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<12; i++) {
            arrayList.add(rand.nextInt(Integer.MAX_VALUE));
        }
        ArrayList<Integer> originalCol = new ArrayList<>(arrayList);
        Collections.sort(originalCol);
        boolean del=true;
        for (Iterator iter=arrayList.iterator(); iter.hasNext(); del=!del)
        {
            iter.next();
            if(del) {
                iter.remove();
            }
        }
        Collections.sort(arrayList);
        System.out.println(originalCol);
        System.out.println(arrayList);

        // Task 2
        // ცოტა სადავო საკითხია ინდექსების წანაცვლების თემა. ვწერ ამოცანას ისე, როგორც მე გავიგე და გავიაზრე.
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayListCopy = new ArrayList<>();
        for(int i=0; i<12; i++) {
            int randomNumber = rand.nextInt(6)+5;
            arrayList1.add(randomNumber);
            arrayListCopy.add(randomNumber);
            if(i%3==0) {
                arrayListCopy.add(rand.nextInt(6)+20);
            }
        }
        System.out.println(arrayList1);
        System.out.println(arrayListCopy);
    }
}
