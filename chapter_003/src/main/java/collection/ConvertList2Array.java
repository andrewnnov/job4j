package collection;

import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        System.out.println(groups);
        int[][] array = new int[groups][cells];
        int row = 0;
        int cell = 0;
        int numberOfElement = 0;

        for (int k = 0; k < list.size() - 1; k++) {
            for (cell = 0; cell < groups; cell++) {
                if(numberOfElement == list.size()) {
                    break;
                }
                array[row][cell] = list.get(numberOfElement++);
            }
            row++;
            cell = 0;
        }

        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //System.out.println(list);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
