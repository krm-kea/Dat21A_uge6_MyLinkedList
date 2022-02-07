package com.company;

import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        Random randGen = new Random();

        for (int i=0; i<12; i++)
        {
            myList.add(randGen.nextInt(100));
            //myList.add("Danmark" + i);  //Hvis T er String
        }

        System.out.println(myList);

        myList.add(-1);
        System.out.println(myList);

        myList.add(2,-2);
        System.out.println(myList);
    }
}
