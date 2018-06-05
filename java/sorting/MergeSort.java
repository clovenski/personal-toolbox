// implementation of mergesort on integer arrays

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] list) {
        int[] leftList;
        int[] rightList;;
        int middleIndex;
        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;

        if(list.length <= 1)
            return list;

        middleIndex = list.length / 2;
        leftList = Arrays.copyOfRange(list, 0, middleIndex);
        rightList = Arrays.copyOfRange(list, middleIndex, list.length);

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        while(leftIndex != leftList.length && rightIndex != rightList.length) {
            if(leftList[leftIndex] - rightList[rightIndex] <= 0)
                list[currentIndex++] = leftList[leftIndex++];
            else
                list[currentIndex++] = rightList[rightIndex++];
        }

        if(leftIndex != leftList.length)
            for(;leftIndex < leftList.length; leftIndex++)
                list[currentIndex++] = leftList[leftIndex];
        else
            for(;rightIndex < rightList.length; rightIndex++)
                list[currentIndex++] = rightList[rightIndex];

        return list;
    }
}