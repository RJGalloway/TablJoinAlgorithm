package com.company;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        int n = 0;
        int m = 0;
        int k = 0;

        if(args.length < 3)
        {
            System.out.println("Usage: int m, int n, int k.");
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
            System.err.println("Usage: m, n, and k must be an integers.");
            System.exit(1);
        }

        if((m <= 0 || k <= 0 || n <= 0) || (m > n || n > k))
        {
            System.out.print("Usage: m, n, and k must be m <= n <= k && m, n, k > 0");
            System.exit(1);
        }

        CreateArrays aM = new CreateArrays();
        CreateArrays aN = new CreateArrays();

        Integer [] arrN = aN.RandArrayCreator(n, k);
        Integer [] arrM = aM.RandArrayCreator(m,k);
        
        int [] newN = new int [arrN.length];
        int [] newM = new int [arrM.length];

        //Copy random arrays of type Integer to primitive type int
        for(int i = 0; i < arrN.length; i++)
        {
            newN[i] = arrN[i];
        }
        for(int i = 0; i < arrM.length; i++)
        {
            newM[i] = arrM[i];
        }

        //Run the techniques on the inputs
        ArrayList<Integer> arrOne = JoinTechniques.intersectionTechniqueOne(newM, newN);
        System.out.println("Resulting intersected was is size: " + arrOne.size());

        ArrayList<Integer> arrTwo = JoinTechniques.intersectionTechniqueTwo(newM, newN);
        System.out.println("Resulting intersected array is of size: " + arrTwo.size());

        ArrayList<Integer> arrThree = JoinTechniques.intersectionTechniqueThree(newM, newN);
        System.out.println("Resulting intersected array is of size: " + arrThree.size());

        ArrayList<Integer> arrFour = JoinTechniques.intersectionTechniqueFour(newM, newN);
        System.out.println("Resulting intersected array is of size: " + arrFour.size());
    }
}
