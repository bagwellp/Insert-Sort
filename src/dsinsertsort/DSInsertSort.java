/*
 * Patty Bagwell
 * Data Structure Project
 * December 2017
 */

package dsinsertsort;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class DSInsertSort {

    
    static Scanner scn;//create scanner for input
    public static void main(String[] args)//main method
    {
    long insertStartTime = System.currentTimeMillis();//start timer   
    try
    {
        scn = new Scanner(new File("test/words.txt"));//load data file
    }
    catch(FileNotFoundException ex)//if file not found through exception
    {
        System.out.println(ex.getMessage());
    }
    System.out.println("Items loaded into the Array: ");
    
    String[] array = scn.next().split(",");//load array with data from file
    System.out.println(array.length);//print the array length
        
        for(int i = 0; i<array.length; i++)//print array 
        {
            System.out.print(array[i] + ", ");
        }
        //Begin insertion Sort
        
        int j;
        String temp;
        for(int i = 1; i< array.length; i++)//set up iteration starting at 1
            //because the first element in the array is considered to be 
            //sorted
        {
            j=i;//initialize j
            temp = array[i];//initialize temp
                        
            while(j !=0 && array[j-1].compareTo(temp)>0)//compare j and temp
                //shift element to right as long as the comparison is greater
                //than 0 and j has not been decremented to 0
            {
                array[j] = array[j-1]; 
                j--;
            }
            array[j] = temp;
        }
        
        
        System.out.print("\n");
        System.out.println("Unique Items in Sorted Order:");
        
        
        //print unique items in an array
        String t = array[0]; //assign first value of the array to var t
        System.out.print(t); //print out first value in the array
        for (int i = 1; i < array.length; i++)//iterate through the remaining values in the array
        {
            if (!array[i].equals(t))//if next value in array does not equal the 
                                    //t then assign t to the new value and print
                                    //print the new value followed by a comma.
            {
                t = array[i];
                System.out.print(", " + array[i]);
            }
            
        }
        long insertEndTime = System.currentTimeMillis();
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Selection Sort Took " + (insertEndTime - insertStartTime) + " milliseconds");
    }
    
}
