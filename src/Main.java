import java.util.*;

public class Main {
    public static void bubbleSort(ArrayList<Integer> arrayList){
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if(arrayList.get(i) > arrayList.get(i + 1)){
                Integer temp = arrayList.get(i + 1);
                arrayList.set(i + 1, arrayList.get(i));
                arrayList.set(i, temp);
            }
        }
    }
    public static void selectionSort(ArrayList<Integer> arrayList){
        int leftPointer = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Integer valueOfI = arrayList.get(i);
            ArrayList<Integer> minValueInfo =  selectionSortGetMinimumInRange(arrayList, i);
            arrayList.set(i, minValueInfo.get(0));
            arrayList.set(minValueInfo.get(1), valueOfI);
        }
    }
    public static ArrayList<Integer> selectionSortGetMinimumInRange(ArrayList<Integer> arrayList,
                                                                    int firstIndex){
        ArrayList<Integer> minValueWithIndex = new ArrayList<>(2);
        Integer minValue = arrayList.get(firstIndex);
        Integer minIndex = firstIndex;
        for (int i = firstIndex; i < arrayList.size(); i++) {
            if(arrayList.get(i) < minValue){
                minValue = arrayList.get(i);
                minIndex = i;
            }
        }
        minValueWithIndex.add(minValue);
        minValueWithIndex.add(minIndex);
        return minValueWithIndex;
    }


    public static void mergeSort(ArrayList<Integer> array){
        if(array.size() < 2)
            return;

        int midIndex = array.size()  / 2;
        ArrayList<Integer> leftArray = new ArrayList<>(Collections.nCopies(midIndex,-1));
        ArrayList<Integer> rightArray = new ArrayList<>(Collections.nCopies(array.size() - midIndex, -1));

        for (int i = 0; i < midIndex; i++) {
            leftArray.set(i, array.get(i));
        }
        for (int i = midIndex; i < array.size(); i++) {
            rightArray.set(i - midIndex, array.get(i));
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, array);

    }

    public static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> array){
        int leftArrayPointer = 0;
        int rightArrayPointer = 0;
        int mainArrayPoiner = 0;

        while (leftArrayPointer < left.size() && rightArrayPointer < right.size()){
            if(left.get(leftArrayPointer) > right.get(rightArrayPointer)){
                array.set(mainArrayPoiner++,right.get(rightArrayPointer++));
            }else {
                array.set(mainArrayPoiner++, left.get(leftArrayPointer++));
            }
        }

        while (rightArrayPointer < right.size()){
            array.set(mainArrayPoiner++,right.get(rightArrayPointer++));
        }


        while (leftArrayPointer < left.size()){
            array.set(mainArrayPoiner++, left.get(leftArrayPointer++));
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(scanner.nextInt());
        }
        System.out.println(arrayList);
        mergeSort(arrayList);

        System.out.println(arrayList);

    }
}