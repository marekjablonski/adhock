package exercises;

import java.util.HashMap;
import java.util.Map;

public class adhock {
    public static void main(String[] args) {
        Integer[] inputList = new Integer[]{2};
        System.out.println(solution(inputList));
    }


    public static int solution(Integer[] A) {
        int startTurbulenceIndex;
        int longestTurbulence = 0;
        int currentChange;
        int tableSize = A.length;
        if (tableSize < 2) return 0;
        int previousChange = Integer.compare(A[0], A[1]);
        startTurbulenceIndex = previousChange == 0 ? 1 : 0;

        for (int i = 2; i < tableSize; i++) {
            currentChange = Integer.compare(A[i - 1], A[i]);
            if (currentChange == 0 || currentChange == previousChange) {
                longestTurbulence = Integer.max(longestTurbulence, i - startTurbulenceIndex);
                startTurbulenceIndex = i;
            }
            previousChange = currentChange;
        }
        longestTurbulence = Integer.max(longestTurbulence, A.length - startTurbulenceIndex);
        return longestTurbulence;
    }

    public static int solution(int[] A, int X, int Y, int Z) {
        // write your code in Java SE 8

        Integer waitTime = 0;
        Integer[] toTankXYZ = {0, 0, 0};
        Integer[] distributorsXYZ = {X, Y, Z};
        int i = 0;

        while (i <= A.length - 1) {
            if (tank(A[i], distributorsXYZ, toTankXYZ, waitTime)) break;
        }

        return i == A.length - 1 ? waitTime : -1;
    }

    public static boolean tank(int amount, Integer[] distribuotrs, Integer[] distribuotrsOccupation, Integer timeAdder) {

        boolean tankSuccessful = false;
        boolean tryToTank = true;

        while (tryToTank) {

            for (int i = 0; i < 2; i++) {
                if (distribuotrsOccupation[i] == 0 && distribuotrs[i] >= amount) {
                    distribuotrsOccupation[i] = amount;
                    tankSuccessful = true;
                    tryToTank=false;
                    break;
                } else {
                    int minToTank = minToTank(distribuotrsOccupation);
                    if (minToTank == 0) {
                        tryToTank=false;
                    }else{
                        timeAdder=+minToTank;
                        tankAmount(distribuotrsOccupation,minToTank);
                    }

                    }

                }


            }




        return tankSuccessful;
    }


    public static int minToTank(Integer[] list) {
        int min = 0;
        for (int i = 0; i < list.length - 1; i++) {
            min = list[i] == 0 ? min : min == 0 ? list[i] : Math.min(min, list[i]);
        }
        return min;
    }

    public static void tankAmount(Integer[] list,int minToTank){
        for (int i = 0; i < list.length - 1; i++) {
            if( list[i] > 0 ) list[i]=list[i]-minToTank;
        }

    }

    ;

}