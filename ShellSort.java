package com.algorithm;

import java.util.Timer;

public class ShellSort {

    public void sort(int [] arrayToBeSorted){
        int h = 1;

        while(h < arrayToBeSorted.length/3) h = 3*h+1;

        InsertionSort is = new InsertionSort();
        while(h >=1){
            is.jumpWidth = h;
            is.sort(arrayToBeSorted);
            h = h/3;
        }
    }

    public static void main(String [] args){
        ShellSort ss = new ShellSort();
        int [] x = {1,2,3,4,5,6,7};
        int [] y = {11,10,1,3,100,200,-1,99,1,2,3,4,5,63,23,124,124,13,1};
        long startTime = System.nanoTime();
        ss.sort(y);
        long timeTaken = (System.nanoTime() - startTime)/1000;
        System.out.println("Time of execution in micro seconds:" + timeTaken);
        System.out.println(" ");
        QuickSort.printArray(y);
        //  System.out.println("number of partitions:" + qs.numberOfPartitions);
        System.out.println("number of items:" + y.length);
        System.out.println("Hello world");
    }
}
