package com.company;

import java.util.Arrays;
import java.util.Collections;

public class CreateArrays {
    Integer kArrValues [];
    Integer randArr [];
/*    public CreateArrays(int k)
    {
        k = k;
        Integer kArrValues [] = new Integer[k];

        for (int i = 0; i < k; i++ )
        {
            kArrValues[i] = i;
        }
        Collections.shuffle(Arrays.asList(kArrValues));
    }*/
    public Integer [] RandArrayCreator(int size, int k)
    {
        randArr = new Integer[size];
        kArrValues = new Integer[k];
        for (int i = 0; i < k; i++ )
        {
            kArrValues[i] = i;
        }
        Collections.shuffle(Arrays.asList(kArrValues));
        for(int i = 0; i < size; i++)
        {
            randArr[i] = kArrValues[i];
        }
        return randArr;
    }
}
