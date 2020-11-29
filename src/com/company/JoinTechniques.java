package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class JoinTechniques
{
    //Implemented merge pseudocode from Introduction to Algorithms Third edition pg. 31
    //Author: Cormen et. all.
    public static void merge(int [] arr, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r -q;

        int [] L = new int[n1 + 1];
        int [] R = new int[n2 + 1];

        for(int i =0; i < n1; i++)
        {
            L[i] = arr[p + i];
        }
        for(int j = 0; j < n2; j++)
        {
            R[j] = arr[q + 1 + j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
        }
    }
    public static void mergeSort (int [] arr, int p, int r)
    {
        //Implemented mergeSort pseudocode from Introduction to Algorithms Third edition pg. 33
        //Author: Cormen et. all.
        if(p < r)
        {
           int q = (p + r - 1)/2;
           mergeSort(arr, p, q);
           mergeSort(arr,q+1, r);
           merge(arr, p, q, r);
        }
    }
    public static ArrayList<Integer> intersectionTechniqueOne(int [] small, int [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        int [] m = new int[small.length];
        int [] n = new int[large.length];

        //local value copy of arrays
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);


        long startTime = System.nanoTime();
        //Sort both arrays
        mergeSort(m, 0, m.length - 1);
        mergeSort(n, 0, n.length - 1);

        int i = 0;
        int j = 0;

        //Modified merge to intersect two sorted arrays from pseudocode in
        //Introduction to Algorithms Third edition pg. 33
        //Author: Cormen et. all.
        while(i < m.length && j<n.length)
        {
            if(m[i] < n[j])
            {
                i++;
            }
            else if(m[i] > n[j])
            {
                j++;
            }
            else
            {
                intersectedArr.add(m[i]);
                i++;
                j++;
            }
        }
        long endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("Total time for technique 1 is: " + totalTime / 1000000000 + "seconds");
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueTwo(int [] small, int [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        int [] m = new int[small.length];
        int [] n = new int[large.length];

        //local array copy
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);


        //Start timer
        long startTime = System.nanoTime();

        //sort the larger array
        mergeSort(n, 0, n.length -1);

        int key;
        int low;
        int high;
        //search linearly through m(smaller array) for each value
        for (int i =0; i < m.length; i++) {
            //set initial indices to start and end of array
            low = 0;
            high = n.length - 1;
            //set the key == to ith element in the smaller array, m.
            key = m[i];
            //continue searching array until low(start) has passed high(end).
            while (low <= high) {
                int middle = (low + high) / 2;

                if (n[middle] < key)
                {
                    low = middle + 1;
                }
                else if (n[middle] > key) {
                    high = middle - 1;
                }
                else {
                    intersectedArr.add(m[i]);
                    break;
                }
            }
        }
        long endTime = System.nanoTime();
        //calculate total time
        double totalTime = endTime - startTime;
        System.out.println("Total time for technique 2 is: " + totalTime / 1000000000 + "seconds");
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueThree(int [] small, int [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        int [] m = new int[small.length];
        int [] n = new int[large.length];

        //temp copy of arrays
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);

        long startTime = System.nanoTime();
        mergeSort(m, 0, m.length -1);

        int key;
        int low;
        int high;
        for(int i = 0; i < n.length; i ++)
        {
            low = 0;
            high = m.length - 1;
            key = n[i];
            while (low <= high)
            {
                int middle = (low + high) / 2;

                if(m[middle] < key)
                {
                    low = middle + 1;
                }
                else if(m[middle] > key)
                {
                    high = middle -1;
                }
                else
                {
                    intersectedArr.add(n[i]);
                    break;
                }
            }
        }

        long endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("Total time for technique 3 is: " + totalTime / 1000000000 + "seconds");
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueFour(int [] m, int [] n)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        long startTime = System.nanoTime();
        //Brute force iteration through m that check each value of n for every value of m
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < n.length; j++)
            {
                if(m[i] == (n[j]))
                {
                    intersectedArr.add(m[i]);
                    break;
                }
            }
        long endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("Total time for technique 3 is: " + totalTime / 1000000000 + "seconds");
        return intersectedArr;
    }
}
