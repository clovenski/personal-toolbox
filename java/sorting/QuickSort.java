// implementation of mquicksort on integer arrays

public class QuickSort {
    public void quickSort(int[] list, int startIndex, int endIndex) {
        int pivotIndex;
        int compareIndex;
        int temp;

        if(startIndex == endIndex)
            return;

        pivotIndex = endIndex;
        compareIndex = startIndex;

        while(compareIndex != pivotIndex) {
            if(list[compareIndex] - list[pivotIndex] > 0) {
                temp = list[pivotIndex];
                list[pivotIndex] = list[compareIndex];
                list[compareIndex] = list[pivotIndex - 1];
                list[pivotIndex - 1] = temp;

                pivotIndex = pivotIndex - 1;
            } else {
                compareIndex = compareIndex + 1;
            }
        }

        if(pivotIndex == startIndex) {
            quickSort(list, startIndex + 1, endIndex);
        } else if(pivotIndex == endIndex) {
            quickSort(list, startIndex, endIndex - 1);
        } else {
            quickSort(list, startIndex, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, endIndex);
        }
    }
}