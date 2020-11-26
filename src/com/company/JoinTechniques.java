package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class JoinTechniques
{
    public static ArrayList<Integer> intersectionTechniqueOne(Integer m [], Integer n [])
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        //Java Arrays.sort uses Timsort: Average case is O(nlogn)
        //Sort both arrays
        Arrays.sort(m);
        Arrays.sort(n);

        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueTwo(Integer m [], Integer n [])
    {
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();
        Arrays.sort(n);
        int key;
        int low;
        int high;
        for(int i = 0; i < m.length; i ++)
        {
            low = 0;
            high = n.length - 1;
            key = m[i];
            while (low <= high)
            {
                int middle = (low + high) / 2 ;
                if(n[middle] == key)
                {
                    intersectedArr.add(m[i]);
                    break;
                }
                if(n[middle] < key)
                {
                    low = middle + 1;
                }
                if(n[middle] > key)
                {
                    high = middle -1;
                }
            }
        }
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueThree(Integer m [], Integer n [])
    {
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();
        Arrays.sort(m);
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
                int middle = (low + high) / 2 ;
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
    public static ArrayList<Integer> intersectionTechniqueFour(Integer m [], Integer n [])
    {
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < n.length; j++)
            {
                if(m[i] == n[j])
                {
                    intersectedArr.add(m[i]);
                    break;
                }
            }
        return intersectedArr;
    }
}
