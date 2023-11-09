package seminar2;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // int[] arrayNumber = creatArray();
        //  System.out.println(Arrays.toString(arrayNumber));
        //System.out.printf("Максимально число %d\n", searchMax(arrayNumber));
        //System.out.printf("Минимальное число %d", searchMin(arrayNumber));
        //printArray(task_2(10));
        // System.out.println(task_3(arrayNumber));
        // int[] newArray=task_4(arrayNumber,5);
        // System.out.println(Arrays.toString(newArray));
       // int[] arr={1,2,3,4,5};
        //System.out.println(Arrays.toString(arr));
        //shifter(arr,2);
       // System.out.println(Arrays.toString(arr));
       // shifter(arr,-2);
       // System.out.println(Arrays.toString(arr));
        int[] arr={0,1,1,0};
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    // /Написать метод которому можно передать в качестве аргкмента массив состоящий строго из единиц
    //и нулей Метод должен заменить еденицы в массиве на нули а нули на единицы и не содержать
    // ветвлений Написать как можно больше вариантов метода

    private static  void  change(int[] a){
        for (int i = 0; i < a.length; i++) {
            //a[i]=1-a[i];
           // a[i]=(a[i]-1)*-1;
            a[i]=(a[i]+1)%2;
        }
    }
// Написать метод принимающий на вход массив чисел и параметр n Метод должен осуществить циклический (последний
// элемент при сдвиге становиться первым) сдвиг всех элементов массива на n позиций

    private  static void  shifter(int[] a,int n){
        n %=a.length;
        int shift=a.length+n;
        shift %= a.length;
        for (int i = 0; i <shift ; i++) {
            int temp=a[a.length-1];
            System.arraycopy(a,0,a,1,a.length-1);
            a[0]=temp;
        }
    }
    // Написать метод"Шифр Цезаря" с булевым параметром зашифрования/расшифрования и числовым ключом

    private static String caesar(String in,int key,boolean encrypt){
        if (in==null||in.isEmpty()){
            return  null;
        }
        final  int len=in.length();
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            out[i] = (char) (in.charAt(i)+((encrypt)?key:-key));
        }
        return new String(out);
    }

//    Задать одномерный массив. Написать методы поиска в нём
//    минимального и максимального элемента;

//    public static int[] creatArray() {
//        Random random = new Random();
//        int[] arrayNumber = new int[10];
//        for (int i = 0; i < arrayNumber.length; i++) {
//            arrayNumber[i] = random.nextInt(1, 15);
//        }
//        return arrayNumber;
//    }
//
//    public static int searchMax(int[] arrayNumber) {
//        int max = arrayNumber[0];
//        for (int i = 1; i < arrayNumber.length; i++) {
//            if (max < arrayNumber[i]) {
//                max = arrayNumber[i];
//            }
//        }
//        return max;
//    }
//
//    public static int searchMin(int[] arrayNumber) {
//        int min = arrayNumber[0];
//        for (int i = 1; i < arrayNumber.length; i++) {
//            if (min > arrayNumber[i]) {
//                min = arrayNumber[i];
//            }
//        }
//        return min;
//    }
//
//    //    Задача: Создать квадратный целочисленный массив (количество строк и
////            столбцов одинаковое), заполнить его диагональные элементы единицами,
////    используя цикл(ы)
//    public static int[][] task_2(int size) {
//        int[][] numberArray = new int[size][size];
//        for (int i = 0, j = numberArray.length - 1; i < size; i++, j--) {
//            numberArray[i][i] = 1;
//            numberArray[i][j] = 1;
//        }
//        return numberArray;
//    }
//
//    public static void printArray(int[][] numberArray) {
////        for (int i = 0; i < numberArray.length; i++) {
////            for (int j = 0; j < numberArray.length; j++) {
////                System.out.print(numberArray[i][j]);
////            }
////            System.out.println();
////        }
//        for (int[] row : numberArray) {
//            System.out.println(Arrays.toString(row));
//        }
//    }
//    //    Задача: Написать метод, в который передается не пустой одномерный
////    целочисленный массив, метод должен вернуть true если в массиве есть
////    место, в котором сумма левой и правой части массива равны. Примеры:
////    checkBalance([1, 1, 1, || 2, 1]) → true,
////    checkBalance([2, 1, 1, 2, 1]) → false,
////    checkBalance([10, || 1, 2, 3, 4]) → true.
////    Абстрактная граница показана символами ||, эти символы в массив не
////    входят.
//    public static boolean task_3(int[] numberArray) {
//        int sum = Arrays.stream(numberArray).sum();
//        int sumLeft = 0;
//        // проходим по массиву ещё раз и собираем сумму на каждой итерации (правую часть массива)
//        int rightSum = 0;
//        for (int i = 0; i < numberArray.length; i++) {
//            // добавляем текущее значение в сумму правой части
//            rightSum += numberArray[i];
//            // вычитаем из суммы всего массива, сумму текущей правой части,
//            // и если они равны, значит баланс найден.
//            if (rightSum == sum - rightSum) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static  int[] task_4(int[] numberArray,int number){
//        int[] newArray = new int[numberArray.length+1];
//        newArray[numberArray.length]=number;
//        System.arraycopy(numberArray,0,newArray, 0,numberArray.length);
//
//        return newArray;
//    }


}











