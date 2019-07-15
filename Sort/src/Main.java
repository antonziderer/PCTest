package sort.src;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

class Main{
    
    public static void mainSort(String [] args){
        display();
    }

    public static void display() {
        int lenghtArr = 10000;
        int[] sortArray = new int[lenghtArr];
        int mainMenu = 0;
        int settingMenu = 0;
        int arrMin = 0;
        int arrMax = 100;
        Scanner main = new Scanner(System.in);
        Scanner setting = new Scanner(System.in);
        Scanner lenghtArrChange = new Scanner(System.in);
        Scanner minMaxChange = new Scanner(System.in);
        for (; ;)
        {
            System.out.print("\n1 - BubleSort \n2 - QuickSort \n9 - Setting \n0 - Exit \n\n");
            mainMenu = main.nextInt();
            if (mainMenu == 1)
            {
                clrscr();
                System.out.println("This is bublSort");
                double startTime = System.nanoTime(); 
                sortArray = bublSort(arrCreate(lenghtArr, arrMin, arrMax));
                System.out.println("Total time: " + (System.nanoTime() - startTime)*Math.pow(10,-9) + " in seconds");
                System.out.println("Arrays size: " + lenghtArr);
                System.out.println("Sorted array: "+ Arrays.toString(sortArray));
            }
            if (mainMenu == 2)
            {
                clrscr();
                System.out.println("This is quickSort");
                double startTime = System.nanoTime(); 
                sortArray = quickSort(arrCreate(lenghtArr, arrMin, arrMax), 0, lenghtArr - 1);
                System.out.println("Total time: " + (System.nanoTime() - startTime)*Math.pow(10,-9) + " in seconds");
                System.out.println("Arrays size: " + lenghtArr);
                System.out.println("Sorted array: "+ Arrays.toString(sortArray));
            }
            if (mainMenu == 9)
            {
                System.out.print("\n1 - Change lenght \n2 - Change min/max value in array \n3 - Back \n\n");
                settingMenu = setting.nextInt();
                if (settingMenu == 1)
                {
                    System.out.print("\nLenght now: " + lenghtArr +"\nEnter new value\n");
                    lenghtArr = lenghtArrChange.nextInt();
                }
                if (settingMenu == 2)
                {   
                    System.out.print("\nMin now: " + arrMin + " Max now: " + arrMax + "\nEnter two new values\n");

                    arrMin = minMaxChange.nextInt();
                    arrMax = minMaxChange.nextInt();
                }
                if (settingMenu == 3)
                {

                }

            }
            if (mainMenu == 0)
            {
                clrscr();
                break;
            }
        }
    }

    public static int[] bublSort(int [] sortArray){
        int buff = 0;
        for(int i = 0; i<sortArray.length; i++)
            for(int j = 0; j<sortArray.length - i - 1; j++)
            {
                if (sortArray[j]>sortArray[j+1])
                {
                    buff = sortArray[j];
                    sortArray[j] = sortArray[j + 1];
                    sortArray[j + 1] = buff; 
                }
            }
        return sortArray;
    }  

    public static int[] quickSort(int [] sortArray, int low, int high){
        if (low >= high)
            return sortArray;
        int middle = sortArray[(low + high)/2];
        int i = low;
        int j = high;
        int buff = 0;
        while (i <= j){
            while (sortArray[i]<middle){
                i++;
            }
            while (sortArray[j]>middle){
                j--;
            }
            if (i<=j)
            {
                buff = sortArray[i];
                sortArray[i] = sortArray[j];
                sortArray[j] = buff;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(sortArray, low, j);
        if (high > i)
            quickSort(sortArray, i, high);
        return sortArray;
    }

    public static int[] arrCreate(int lenghtArr, int min, int max){
        int[] nonSortArray = new int[lenghtArr];
        int[] sortArray = new int[lenghtArr];
        int type = 0;
        for(int i = 0; i<nonSortArray.length; i++)
        {
            nonSortArray[i] = (int)(Math.random()*max+min);
        }
        return nonSortArray;
    }

    public static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}