package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class JoinTechniques
{
    //Implemented merge pseudocode from Introduction to Algorithms Third edition pg. 31
    //Author: Cormen et. all.
    public static void merge(Integer [] arr, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r -q;

        Integer [] L = new Integer[n1 + 1];
        Integer [] R = new Integer[n2 + 1];

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
    public static void mergeSort (Integer [] arr, int p, int r)
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
    public static ArrayList<Integer> intersectionTechniqueOne(Integer [] small, Integer [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        Integer [] m = new Integer[small.length];
        Integer [] n = new Integer[large.length];

        //temp copy of arrays, needed to maintain single array with identical values
        //in main function for technique comparison. Both arrays copied to maintain uniformity
        //across functions for time analysis.
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);

        //Sort both arrays
        mergeSort(m, 0, m.length - 1);
        mergeSort(n, 0, n.length - 1);

        int i = 0;
        int j = 0;

        //Modified merge to intersect two sorted arrays
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
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueTwo(Integer [] small, Integer [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        Integer [] m = new Integer[small.length];
        Integer [] n = new Integer[large.length];

        //temp copy of arrays, needed to maintain single array with identical values
        //in main function for technique comparison. Both arrays copied to maintain uniformity
        //across functions for time analysis.
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);

        //sort the larger array
        mergeSort(n, 0, n.length -1);

        int key;
        int low;
        int high;
        //search linearly through m for each value
        for (Integer integer : m) {
            //set initial indices to start and end of array
            low = 0;
            high = n.length - 1;
            //set the key == to ith element in the smaller array, m.
            key = integer;
            //continue searching array until low(start) has passed high(end).
            while (low <= high) {
                int middle = (low + high) / 2;

                if (n[middle] == key) {
                    intersectedArr.add(integer);
                    break;
                }
                if (n[middle] < key) {
                    low = middle + 1;
                }
                if (n[middle] > key) {
                    high = middle - 1;
                }
            }
        }
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueThree(Integer [] small, Integer [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        Integer[] m = new Integer[small.length];
        Integer[] n = new Integer[large.length];

        //temp copy of arrays, needed to maintain single array with identical values
        //in main function for technique comparison. Both arrays copied to maintain uniformity
        //across functions for time analysis.
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);

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
                if(m[middle] == key)
                {
                    intersectedArr.add(n[i]);
                    break;
                }
                if(m[middle] < key)
                {
                    low = middle + 1;
                }
                if(m[middle] > key)
                {
                    high = middle -1;
                }
            }
        }
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueFour(Integer [] small, Integer [] large)
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        Integer [] m = new Integer[small.length];
        Integer [] n = new Integer[large.length];

        //temp copy of arrays, needed to maintain single array with identical values
        //in main function for technique comparison. Both arrays copied to maintain uniformity
        //across functions for time analysis.
        System.arraycopy(small, 0, m, 0, m.length);
        System.arraycopy(large, 0, n, 0, n.length);

        //Brute force iteration through m that check each value of n for every value of m
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < n.length; j++)
            {
                if(m[i].equals(n[j]))
                {
                    intersectedArr.add(m[i]);
                    break;
                }
            }
        return intersectedArr;
    }
}
