package com.company;

import java.util.ArrayList;
import java.util.Arrays;


public class Main
{
    /*public static ArrayList<Integer> intersectionTechniqueOne(Integer m [], Integer n [])
    {
        //Array list used to store intersected array so it will grow when common values are found
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        //Java Arrays.sort uses Timsort: Average case is O(nlogn)
        //Sort both arrays
        //Arrays.sort(m);
        //Arrays.sort(n);

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
        System.out.println("Int arr: " + intersectedArr.toString());
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
    }*/
    public static void main(String[] args)
    {
        int n = 0;
        int m = 0;
        int k = 0;

        if(args.length < 3)
        {
            System.out.println("Arguments: int m, int n, int k.");
            System.exit(1);
        }
        try
        {
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Arguments: m n k must be an integers.");
            System.exit(1);
        }

        if((m <= 0 || k <= 0 || n <= 0) || (m > n || n > k))
        {
            System.out.print("Arguments: m , n , k: m <= n <= k && m, n, k > 0");
            System.exit(1);
        }
        CreateArrays aM = new CreateArrays();
        CreateArrays aN = new CreateArrays();
        Integer arrNT1 [] = aN.RandArrayCreator(n, k);
        Integer arrMT1 [] = aM.RandArrayCreator(m,k);

/*      System.out.println("Array N" + Arrays.toString(arrNT1));
        System.out.println("Array M" + Arrays.toString(arrMT1));*/

        Integer arrNT2 [] = aN.RandArrayCreator(n, k);
        Integer arrMT2 [] = aM.RandArrayCreator(m,k);

        Integer arrNT3 [] = aN.RandArrayCreator(n, k);
        Integer arrMT3 [] = aM.RandArrayCreator(m,k);

        Integer arrNT4 [] = aN.RandArrayCreator(n, k);
        Integer arrMT4 [] = aM.RandArrayCreator(m,k);

        JoinTechniques j1 = new JoinTechniques();
        JoinTechniques j2 = new JoinTechniques();
        JoinTechniques j3 = new JoinTechniques();
        JoinTechniques j4 = new JoinTechniques();


        ArrayList<Integer> arrOne = j1.intersectionTechniqueOne(arrMT1, arrNT1);
        ArrayList<Integer> arrTwo = j2.intersectionTechniqueTwo(arrMT2, arrNT2);
        System.out.println("Array using technique two" + arrTwo.toString());
        ArrayList<Integer> arrThree = j3.intersectionTechniqueThree(arrMT3, arrNT3);
        System.out.println("Array using technique three" + arrThree.toString());
        ArrayList<Integer> arrFour = j4.intersectionTechniqueFour(arrMT4, arrNT4);
        System.out.println("Array using technique four" + arrFour.toString());
    }
}
