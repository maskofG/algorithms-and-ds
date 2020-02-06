package com.algorithm;

public class InsertionSort {
    public int jumpWidth=1;

    private boolean less(int a, int b){
        if (a < b) return true;
        else return false;
    }

    private void exchange(int [] array, int indexi, int indexj){
        int temp = array[indexi];
        array[indexi] = array[indexj];
        array[indexj] = temp;
    }

    public void sort(int [] arrayToBeSorted){
        for(int i=0;i<arrayToBeSorted.length;i=i+jumpWidth){
            for(int j=i;j>0 && j-jumpWidth >= 0;j = j - jumpWidth){
                if ( less(arrayToBeSorted[j] , arrayToBeSorted[j-jumpWidth] )){
                        exchange(arrayToBeSorted, j, j - jumpWidth);
                }
            }
        }
    }

     public static void main(String [] args){
         InsertionSort is = new InsertionSort();
         int [] x = {1,2,3,4,5,6,7};
         int [] y = {11,10,1,3,100,200,-1,99,1,2,3,4,5,63,23,124,124,13,1};
         long startTime = System.nanoTime();
         is.sort(y);
         long timeTaken = (System.nanoTime() - startTime)/1000;
         System.out.println("Time of execution micro second:" + timeTaken);
         System.out.println(" ");
         QuickSort.printArray(y);
       //  System.out.println("number of partitions:" + qs.numberOfPartitions);
         System.out.println("number of items:" + y.length);
         System.out.println("Hello world");
     }
}
