import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here

    /*
        findMax
        returns the maximum value in the array
    */
    // Start
    
    public static int findMax(Integer[] input) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > maxValue) {
                maxValue = input[i];
            }
        }

        return maxValue;
    }
    // End


    /*
        findDuplicates
        returns an array (Integer[]) containing the duplicate values in the array

    */
    // Start
    
    public static Integer[] findDuplicates(Integer[] input) {
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (!resultMap.containsKey(input[i])) {
                resultMap.put(input[i], 1);
            } else {
                resultMap.put(input[i], resultMap.get(input[i]) + 1);
            }
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() > 1) {
                tempList.add(entry.getKey());
            }
        }

        Integer[] resultArray = new Integer[tempList.size()];
        return tempList.toArray(resultArray);
    }
    // End


    /*
        findUnique
        returns an array (Integer[]) containing the unique values in the array

    */
    // Start
    
    public static Integer[] findUnique(Integer[] input) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (!resultMap.containsKey(input[i])) {
                resultMap.put(input[i], 1);
            } else {
                resultMap.put(input[i], resultMap.get(input[i]) + 1);
            }
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() == 1) {
                tempList.add(entry.getKey());
            }
        }

        Integer[] resultArray = new Integer[tempList.size()];
        return tempList.toArray(resultArray);
    }
    // End
}

