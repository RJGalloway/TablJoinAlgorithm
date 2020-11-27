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
        Integer [] arrN = aN.RandArrayCreator(n, k);
        Integer [] arrM = aM.RandArrayCreator(m,k);

        double startTimeT1, startTimeT2,startTimeT3,startTimeT4;
        double endTimeT1, endTimeT2,endTimeT3,endTimeT4;
        double totalTimeT1, totalTimeT2,totalTimeT3,totalTimeT4;

        startTimeT1 = System.nanoTime();
        ArrayList<Integer> arrOne = JoinTechniques.intersectionTechniqueOne(arrM, arrN);
        endTimeT1 = System.nanoTime();
        totalTimeT1 = (endTimeT1 - startTimeT1);
        System.out.println("Resulting intersected was is size: " + arrOne.size());
        System.out.println("Total Time Tech 1: " + (totalTimeT1 / 1_000_000_000) + "seconds");

        startTimeT2 = System.nanoTime();
        JoinTechniques.intersectionTechniqueTwo(arrM, arrN);
        endTimeT2 = System.nanoTime();
        totalTimeT2 = (endTimeT2 - startTimeT2);
        System.out.println("Resulting intersected array is of size: " + arrOne.size());
        System.out.println("Total Time Technique 2: " + (totalTimeT2/1_000_000_000) + " seconds");

        startTimeT3 = System.nanoTime();
        JoinTechniques.intersectionTechniqueThree(arrM, arrN);
        endTimeT3 = System.nanoTime();
        totalTimeT3 = (endTimeT3 - startTimeT3);
        System.out.println("Resulting intersected array is of size: " + arrOne.size());
        System.out.println("Total Time Technique 3: " + (totalTimeT3/1_000_000_000) + " seconds");

        startTimeT4 = System.nanoTime();
        JoinTechniques.intersectionTechniqueFour(arrM, arrN);
        endTimeT4 = System.nanoTime();
        totalTimeT4 = (endTimeT4 - startTimeT4);
        System.out.println("Resulting intersected array is of size: " + arrOne.size());
        System.out.println("Total Time Technique 4: " + (totalTimeT4/1_000_000_000) + " seconds");
    }
}
