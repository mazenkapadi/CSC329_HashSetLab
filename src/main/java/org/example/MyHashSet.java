package org.example;

import java.util.ArrayList;

public class MyHashSet {

    private int numElements;

    private ArrayList<Integer>[] buckets;

    public MyHashSet() {
        //  Allocate the array of buckets
        this.buckets = new ArrayList[10];

        //  Allocate the individual buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        numElements = 0;
    }

//    My version
//    void add (int i) {
//        int bucketIndex = i % buckets.length;
//        buckets[bucketIndex].add(i);
//        numElements++;
//    }


//    public void add (int i){      Initial method by prof
//        ArrayList<Integer> bucketList;
//
//        //Get the bucket index
//        int bucketIndex = i % buckets.length;
//
//        //Get the list for the bucket
//        bucketList = buckets[bucketIndex];
//
//        //  Add the new item to the bucket list
//        bucketList.add(i);
//
//        numElements++;
//    }

        public void add (int i){      //Updated method
        ArrayList<Integer> bucketList;

        //If the item is in don't add
        if (hasItem(i)){
            System.out.println("Has Item");
            return;
        }


        //Get the bucket index
        int bucketIndex = i % buckets.length;

        //Get the list for the bucket
        bucketList = buckets[bucketIndex];

        //  Add the new item to the bucket list
        bucketList.add(i);

        numElements++;
    }



    //create a method to make new buckets createBuckets(int numBuckets)
    public ArrayList<Integer>[] createBuckets(int numBuckets) {
        this.buckets = new ArrayList[numBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        return buckets; // Return the initialized buckets array.
    }


    public void show () {
        ArrayList<Integer> currentList;
        for (int i = 0; i < buckets.length; i++) {
            currentList = buckets[i];
            System.out.printf("Bucket %d: ", i);
            if (currentList.isEmpty())
                System.out.print("Empty Bucket");
            //  Show all data in the current list.
            for (Integer data: currentList) {
//
                System.out.printf("%d ", data);
            }
            System.out.println();
        }
    }

//    boolean hasItem(int targetItem){          my way?
//        ArrayList<Integer> currentList;
//        for (int i = 0; i < buckets.length; i++) {
//            currentList = buckets[i];
//            //  Show all data in the current list.
//            for (Integer data: currentList) {
//                if (data == targetItem) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    boolean hasItem(int targetItem) {
        ArrayList<Integer> bucketList;

        //Get the bucket index
        int bucketIndex = targetItem % buckets.length;

        //Get the list for the bucket
        bucketList = buckets[bucketIndex];

        for (int i = 0; i < bucketList.size(); i++) {
            if(targetItem == bucketList.get(i))
                return true;
        }
        return false;
    }

    //  Tried to complete loadFactor method
    public double loadFactor(){
        return (double) numElements / buckets.length;
    }

//    public void resize(int newSize){
//        ArrayList<Integer> currentList;
//        int bucketIndex;
//        int newBucketIndex;
//        ArrayList<Integer> newBucketList;
//
//        createBuckets(newSize);
//
//        for (int i = 0; i < buckets.length; i++){
//            currentList = buckets[i];
//            for (int j = 0; j < currentList.size(); j++) {
//                bucketIndex = currentList.get(j) % buckets.length;
//                newBucketList = buckets[bucketIndex];
//                newBucketList.add(currentList.get(j));
//            }
//        }
//    }

    // Tried to complete the resize method
    public void resize(int newSize) {
        ArrayList<Integer>[] newBuckets = createBuckets(newSize);

        for (ArrayList<Integer> currentList : buckets) {
            int newBucketIndex; // Declare newBucketIndex here
            for (Integer item : currentList) {
                newBucketIndex = item % newSize;
                newBuckets[newBucketIndex].add(item);
            }
        }
        buckets = newBuckets; // Update the reference to the new buckets array.
    }

    // Tried to play around a little!
    public void autoResize() {
        double loadFactor = loadFactor();

        if (loadFactor > 0.75) {
            int newSize = (int) (buckets.length * 2); // Double the current number of buckets.
            resize(newSize);
        }
    }

}
