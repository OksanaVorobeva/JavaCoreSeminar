package seminar4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    private static final String CORRECT_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private static final String EXTRA_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n1 2 3 4";
    private static final String EXTRA_COL_STRING = "1 3 1 2 1\n2 3 2 2 1\n5 6 7 1 1\n3 3 1 0 1";
    private static final String NO_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1";
    private static final String NO_COL_STRING = "1 3 1 2\n2 3 2 \n5 6 7 1\n3 3 1";
    private static final String HAS_CHAR_STRING = "1 3 1 2\n2 3 2 2\n5 6 7  1\n3 3 1 A";

    private static final int MATRIX_ROWS = 4;
    private static final int MATRIX_COLS = 4;

    public static void main(String[] args) {

        try {
            //final String[][] matrix = stringToMatrix(HAS_CHAR_STRING);
            //final String[][] matrix = stringToMatrix(CORRECT_STRING);
            //final String[][] matrix = stringToMatrix(NO_COL_STRING);
            final String[][] matrix = stringToMatrix(NO_ROW_STRING);
            System.out.println(Arrays.deepToString(matrix));
            System.out.println("Half sum = " + calcMatrix(matrix));
        } catch (NumberIsNotNumberException exception) {
            System.out.println("A NumberIsNotNumberException is thrown " + exception.getMessage());
        } catch (RowMismatchException | ColumnMismatchException superExceptionName) {
            System.out.println("A RowMismatchException successor is thrown" + superExceptionName.getMessage());
        }
    }

    // Разработайте исключения-наследники так чтобы они информировали пользователя в формате ожидание/реальность

    private static final class RowMismatchException extends RuntimeException {
        RowMismatchException(int expected, int current, String value) {
            super(String.format("Rows exception: expected %d rows. Received %d rows `%s` string", expected, current, value));
        }
    }

    //Напишите два наследника класса Exception:ошибка преобразования строки и ошибка преобразования столбца

    private static final class ColumnMismatchException extends RuntimeException {
        ColumnMismatchException(String massage) {
            super("Columns exception: " + massage);
        }
    }

    private static final class NumberIsNotNumberException extends RuntimeException {
        NumberIsNotNumberException(String massage) {
            super("Not a number found" + massage);
        }
    }

    private static float calcMatrix(String[][] matrix) {
        float result = 0;
        int len = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                    len++;
                } catch (NumberIsNotNumberException e) {
                    throw new NumberFormatException(matrix[i][j]);
                }
            }
        }
        return result / len;
    }

    //Для проверки напишите программу преобразующую квадратный массив целых чисел 5x5
    //в сумму чисел в этом массиве при этом программа должна выбросить исключения
    //если строк или столбцов в исходном массиве окажеться5

    private static  String[][] stringToMatrix(String value) {
        String[] rows = value.split("\n");
        if (rows.length != MATRIX_ROWS)
            throw new RowMismatchException(MATRIX_ROWS, rows.length, value);
        String[][] result = new String[MATRIX_ROWS][];
        for (int i = 0; i < result.length; i++) {
            result[i] = rows[i].split(" ");
            if (result[i].length != MATRIX_COLS)
                throw new ColumnMismatchException(result[i].length + "\n" + value);
        }
        return result;
    }


}






