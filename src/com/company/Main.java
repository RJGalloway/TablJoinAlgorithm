package com.company;
import java.util.ArrayList;
import java.util.Arrays;


public class Main
{
    public static ArrayList<Integer> intersectionTechniqueOne(Integer m [], Integer n [])
    {
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();

        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueTwo(Integer m [], Integer n [])
    {
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();
        return intersectedArr;
    }
    public static ArrayList<Integer> intersectionTechniqueThree(Integer m [], Integer n [])
    {
        ArrayList<Integer> intersectedArr = new ArrayList<Integer>();
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
        Integer arrN [] = aN.RandArrayCreator(n, k);
        Integer arrM [] = aM.RandArrayCreator(m,k);

        System.out.println("Array N" + Arrays.toString(arrN));
        System.out.println("Array M" + Arrays.toString(arrM));


        ArrayList<Integer> arrOne = intersectionTechniqueOne(arrM, arrN);
        ArrayList<Integer> arrTwo =intersectionTechniqueTwo(arrM, arrN);
        ArrayList<Integer> arrThree =intersectionTechniqueThree(arrM, arrN);
        ArrayList<Integer> arrFour = intersectionTechniqueFour(arrM, arrN);
        System.out.println("Array using technique four" + arrFour.toString());
    }
}
