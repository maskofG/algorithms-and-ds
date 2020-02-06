package com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public int numberOfPartitions = 0;
    public Integer [] sort(Integer [] arrayToBeSorted, int low, int high){
        System.out.println(" ");
        printArray(arrayToBeSorted);
        System.out.print("low:" + low + ", high:" + high);
        if (high > low) {
            int partition = partition(arrayToBeSorted, low, high);
            numberOfPartitions++;
            System.out.print(" partition index:" + partition);
            int p11 = low;int p12 = partition-1;int p21 = partition+1;int p22=high;
            System.out.println(" partitions : {" + p11 + "," +  p12 + "},{" + p21 + "," + p22 + "} ");
            sort(arrayToBeSorted, low, partition-1);
            sort(arrayToBeSorted, partition+1, high);
        }
        return arrayToBeSorted;
    }

    public void exchange(Integer [] a, int i, int j){
        //swap element at index i with element at index j
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int partition(Integer [] arrayToBePartitioned, int low, int high){
        int partitionIndex = low;
        int i = low;
        int j = high;

        while(true) {
            while(arrayToBePartitioned[++i] < arrayToBePartitioned[low]) if (i == high) break;

            while(arrayToBePartitioned[j] > arrayToBePartitioned[low]) j--;
            if (j == low) break;

            if (i >= j) break; // check will it ever be equal

            exchange(arrayToBePartitioned, i, j);
        }
        partitionIndex = j;
        exchange(arrayToBePartitioned, low, partitionIndex);
        return partitionIndex;
    }
    public static void printArray(int [] array){
        System.out.print("[ ");
        for (int elem: array) {
            System.out.print( elem + " ");
        }
        System.out.println(" ]");
    }
    public static void main(String [] args){
        QuickSort qs = new QuickSort();
        int [] x = {1,2,3,4,5,6,7};
        int [] y = {11,10,1,3,100,200,-1,99,1,2,3,4,5,63,23,124,124,13,1};
        Integer [] temp = new Integer[y.length];
        int i=0;
        for(Integer elem: y){
            temp[i++] =
        }
        List<Integer> intList = Arrays.asList(y);
        Collections.shuffle(intList);
        intList.toArray(y);
        long startTime = System.nanoTime();
        qs.sort(y, 0, y.length-1);
        long timeTaken = (System.nanoTime() - startTime)/1000;
        System.out.println("Time of execution in micro seconds:" + timeTaken);
        System.out.println(" ");
        printArray(y);
        System.out.println("number of partitions:" + qs.numberOfPartitions);
        System.out.println("number of items:" + y.length);
        System.out.println("Hello world");
    }
}
