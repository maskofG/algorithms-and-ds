package com.algorithm;

public class BottomUpMergeSort {
    private boolean less(int a, int b){
        if (a <= b) return true;
        else return false;
    }

    public void sort(int [] arrayToBeSorted, int [] aux, int low, int high){

        for(int size=1; size <= arrayToBeSorted.length;size = size + size){
            //subarrays
            //[low,low+size-1][low+size,low+size+size-1]
            for(int i = low; i <= high; i = i + size + size) {
                int lowTemp = i;
                int midTemp = i + size - 1;
                int highTemp = Math.min(i + size + size -1, high);
                merge(arrayToBeSorted, aux, lowTemp, midTemp,highTemp);
            }
        }
    }

    private void merge(int [] arrayToBeSorted, int [] aux, int low, int mid, int high){
        //two arrays : [low,mid] and [mid+1,high] that we have to merge
        //both arrays are sorted before calling this function.
        // assert isSorted(arrayToBeSorted, low, mid) = true
        // assert isSorted(arrayToBeSorted, mid+1, high) = true

        //copy the array to be merged part into aux array first
        for(int k=low;k<=high;k++){
            aux[k] = arrayToBeSorted[k];
        }
        int i = low;
        int j = mid+1;
        for(int k=low;k<=high;k++){
            if ( i > mid) arrayToBeSorted[k] = aux[j++];
            else if ( j > high) arrayToBeSorted[k] = aux[i++];
            else if ( less(aux[i],aux[j]) ) arrayToBeSorted[k] = aux[i++];
            else arrayToBeSorted[k] = aux[j++];
        }
    }

    public static void main(String [] args){
        BottomUpMergeSort bms = new BottomUpMergeSort();
        int [] x = {1,2,3,4,5,6,7};
        int [] y = {11,10,1,3,100,200,-1,99,1,2,3,4,5,63,23,124,124,13,1};
        int [] aux = new int[y.length];
        long startTime = System.nanoTime();
        bms.sort(y, aux, 0, y.length-1);
        long timeTaken = (System.nanoTime() - startTime)/1000;
        System.out.println("Time of execution in micro seconds:" + timeTaken);
        System.out.println(" ");
        QuickSort.printArray(y);
        System.out.println("number of items:" + y.length);
        System.out.println("Hello world");
    }
}
