import java.util.Arrays;

public class Lesson2 {

    /**
     * Вспомогательный метод для вывода на экран каждого элемента массива
     * @param someArray - Массив, элементы которого надо вывести на экран
     */
    public static void printIntArrayItems(int[] someArray){
        for (int num : someArray)
            System.out.print(num + " ");
        System.out.print("\n");
    }

    /**
     * ЗАДАНИЕ 1
     * Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
     * 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * @param nums - массив, который принимает функция и в котором в качестве значений присутствуют нули
     * @return - возвращаемое значение - массив, в котором все нули заменены на единички
     */
    public static int[] changeZeroToOne(int[] nums){
        if(nums.length > 0)
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0)
                    nums[i] = 1;
            }
        return nums;
    }

    /**
     * ЗАДАНИЕ 2
     * Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
     * значениями 0 3 6 9 12 15 18 21;
     * @param nums  Массив, размерностью 8 элементов, который надо заполнить значениями
     * @return возвращаемое значение - массив, в котором заполнены все значения
     */
    public static int[] fillArray(int[] nums){
        if(nums.length == 8)
            for(int i = 0; i < 8; i++){
                if(i == 0)
                    nums[i] = 0;
                else
                    nums[i] = nums[i-1] + 3;
            }
        return nums;
    }

    /**
     * ЗФДАНИЕ 3
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     * @param someArray - Массив, над которым будут производиться операции
     * @return возвращаемое значение - массив
     */
    public static int[] multiplyToTwo(int[] someArray){
        if(someArray.length > 0)
            for(int i = 0; i < someArray.length; i++){
                if(someArray[i] < 6)
                    someArray[i] *= 2;
            }
        return someArray;
    }


    /**
     * ЗАДАНИЕ 4
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов
     * одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     * @param depth определяет размерность двухмерного, квадратного массива
     * @return  возвращаемое значение - массив
     */
    public static int[][] fillArrayByDiagonal(int depth) {
        int[][] nums = new int[depth][depth];

        for (int i = 0; i < depth; i++) {
            nums[i][i] = 1;
            nums[i][depth-i-1] = 1;
        }
        return nums;
    }

    /**
     * ЗАДАНИЕ 5
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы
     * @param nums - массив чисел
     */
    public static void minMax(int[] nums){
        if(nums.length > 0){
            //System.out.println(Arrays.stream(nums).max());
            //System.out.println(Arrays.stream(nums).min());
            int max = 0;
            int min;

            for(int num : nums){
                if(num > max)
                    max = num;
            }
            min = max;
            for(int num : nums){
                if(num < min)
                    min = num;
            }
            System.out.println("Максимальное число в массиве - это: " + max);
            System.out.println("Минимальное число в массиве - это:  " + min);
        }
    }

    /**
     * ЗАДАНИЕ 6
     *Написать метод, в который передается не пустой одномерный целочисленный массив,
     *метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
     *массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
     * 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     * @param nums - Массив чисел
     * @param border - индекс элемента, по которому проходит граница. Все элементы массива до границы относятся
     *               к левой части. Все, что после границы - к правой, включая и сам элемент под этим индексом
     * @return Возвращаемое значени - истина (если суммы равны) или ложь (если суммы не равны)
     */
    public static boolean checkBalance(int[] nums, int border){
        int sumLeft = 0;
        int sumRight = 0;
        if(nums.length > 0 && border > 0){
            for(int i = 0; i < border; i++)
                sumLeft += nums[i];
            for(int i = border; i < nums.length; i++)
                sumRight += nums[i];
        }
        return sumLeft == sumRight;
    }

    /**
     *  ЗАДАНИЕ 7
     ***** Написать метод, которому на вход подается одномерный массив и число n (может быть
     *положительным, или отрицательным), при этом метод должен сместить все элементы массива
     *на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
     *вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
     * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     * @param nums массив чисел, над которым надо произвести сдвиг
     * @param step шаг сдвига. может быть положительным или отрицательным, но не должен быть равен 0
     * @return возвращаемое значение - массив со сдвигом элементов
     */

    public static int[] movingElements(int[] nums, int step){
        int temp = 0;
        int curr = 0;
        if(nums.length > 0 && step != 0){
            // при положительном значении шага
            if(step > 0) {
                for (int i = 1; i <= step; i++) {
                    for (int j = 0; j < nums.length; j++) {
                        if (j == 0) {
                            temp = nums[nums.length - 1];
                        }
                        curr = temp;
                        temp = nums[j];
                        nums[j] = curr;
                    }
                }
            }
            // при отрицательном значении шага
            if(step < 0) {
                for (int i = 1; i <= (step * -1); i++) {
                    for (int j = nums.length -1; j >= 0; j--) {
                        if (j == nums.length -1) {
                            temp = nums[0];
                        }
                        curr = temp;
                        temp = nums[j];
                        nums[j] = curr;
                    }
                }
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        // Выполнение Задания №1
        {
            int[] nums = changeZeroToOne(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
            System.out.println("ЗАДАНИЕ 1:");
            printIntArrayItems(nums); // 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        }

        // Выполнение Задания №2
        {
            int[] nums = fillArray(new int[8]);
            System.out.println("ЗАДАНИЕ 2:");
            printIntArrayItems(nums); // 0, 3, 6, 9, 12, 15, 18, 21
        }

        // Выполнение Задания №3
        {
            int[] nums = multiplyToTwo(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
            System.out.println("ЗАДАНИЕ 3:");
            printIntArrayItems(nums); // 2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2
        }

        // Выполнение Задания №4
        {
            int[][] nums = fillArrayByDiagonal(5);
            System.out.println("ЗАДАНИЕ 4:");
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums.length; j++){
                    System.out.print(nums[i][j] + " ");
                    if(j == nums.length - 1)
                        System.out.print("\n");
                    /*
                        1 0 0 0 1
                        0 1 0 1 0
                        0 0 1 0 0
                        0 1 0 1 0
                        1 0 0 0 1
                    */
                }
            }

        }

        // Выполнение Задания № 5
        {
            System.out.println("Задание 5:");
            minMax(new int[]{1,2,3,4,5,6,7,8,9});  // max = 9; min = 1
        }

        // Выполнение Задания № 6
        {
            System.out.println("ЗАДАНИЕ 6:");
            System.out.println(checkBalance(new int[]{1,1,1,2,1}, 3)); // true
        }

        // Выполнение Задания № 7
        {
            System.out.println("ЗАДАНИЕ 7:");
            printIntArrayItems(movingElements(new int[] {1,2,3,4,5,6},2));  // 5 6 1 2 3 4
            printIntArrayItems(movingElements(new int[] {1,2,3,4,5,6},-1));  // 2 3 4 5 6 1
            printIntArrayItems(movingElements(new int[] {1,2,3,4,5,6},0)); // 1 2 3 4 5 6
        }

    }
}
