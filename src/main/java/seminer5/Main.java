package seminer5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private  static  final Random rnd=new Random();
    private static final  int CHAR_BOUND_L =65;
    private static final  int CHAR_BOUND_H =90;
    private static final  int FILES_AMOUNT =10;
    private static final  int WORDS_AMOUNT =5;
    private static final  int WORDS_LENGTH =10;
    private static final  String WORDS_TO_SEARCH ="geekbrains";



    public static void main(String[] args) {
        String[] fileNames= new String[FILES_AMOUNT];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "file" + i + ".txt";
        }
//создать пару тройку текстовых файлов
        /*try {
            for (int i = 0; i < fileNames.length; i++) {
                if (i<2){
                    writeFileContents(fileNames[i], 100);
                }else{
                    writeFileContents(fileNames[i],WORDS_AMOUNT );
                }
                System.out.println("First task results are in file_0 and file_1");
            }
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }*/
//Написать метод осуществляющий конкатенацию переданных ей к качестве параметров
        //файлов
        /*try {
            concatenate(fileNames[0],fileNames[1], "FILE_OUT.txt");
            System.out.println("Second task result is in FILE_OUT");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }*/

        //Написать метод поиска слова внутри файла
      /*  try {
            System.out.println("Check result in file_2 for third task is" + isInFile(fileNames[2],WORDS_TO_SEARCH));
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }*/

        //Создать массив из 9 цифр и записать его в файл используя поток вывода
        /*int[] ar0={1,2,3,4,5,6,7,8,0,9,7,6,5,4,3};
        final  int DIGIT_BOUND=48;
        FileOutputStream fos = new FileOutputStream("save.out");
        fos.write("[");
        for (int i = 0; i < ar0.length; i++) {
            fos.write(DIGIT_BOUND+ar0[i]);
            if (i<ar0.length-1) fos.write(",");)
        }
        fos.write("]");
        fos.flush();
        fos.close();*/

        //Создать массив целых чисел и заполнить его информацией из файла записаного в предыдущем задании

        /*int[] ar00 =new int[15];
        final  int DIGIT_BOUND=48;
        FileInputStream fis = new FileInputStream("save.out");
        fis.read();
        for (int i = 0; i < ar00.length; i++) {
            ar00[i]=fis.read()-DIGIT_BOUND;
            fis.read();
        }
        fis.close();
        System.out.println(Arrays.toString(ar00));*/

        //Написать программу заменяющую указанный символ в текстовом файле
        //на пробел сохроняющую получившийся текс в новый файл

       /* FileInputStream fis=new FileInputStream("Main.java");
        int i;
        char what =",";
        char to="!";
        FileOutputStream fos = new FileOutputStream("Main.java.new");
        while ((i=fis.read())!=-1){
            if (i==what){
                fos.write(to);
            }else {
                fos.write(i);
            }
        }
        fos.close();*/

        //Написать программу читающую и выводящую в содержимое текущей папки

       /* int count=0;
        File path = new File(new File(".").getPath());
        File[] dir = path.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory()) continue;
            System.out.println(dir[i]);
        }
*/
        //Написать функцию добавляющую префикс к каждому из набора файлов
        //название которых переданы ей в качестве параметров через пробел

     /*   String[] a={"Main.java","a.txt"};
        for (String fileName: a) {
            Path file =Path.of(fileName);
            if (Files.exists(file)){
                Files.move(file, Paths.get("pre_"+file),REPLACE_EXISTING);
            }else {
                System.out.println("No file with name ",fileName);
            }
        }*/

    }
    //Создать пару-тройку текстовых файлов Для упрощения чтобы не разбираться
    //с кодировкой внутри файлов следует писать текст только латинскими буквами

    private static String generateSymbols(int amount){
        StringBuilder sequence=new StringBuilder();
        for (int i = 0; i < amount; i++) {
            sequence.append((char)(CHAR_BOUND_L+rnd.nextInt(CHAR_BOUND_H-CHAR_BOUND_L)));

        }
        return sequence.toString();
    }
    private static void writeFileContents(String fileName, int length) throws IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(generateSymbols(length).getBytes());
        fos.flush();
        fos.close();
    }

    //Написать метод осуществляющий конкатенацию переданных ей к качестве параметров
    //файлов

    private  static  void concatenate (String file_in1,String file_in2,String file_out) throws IOException{
        FileOutputStream fos = new FileOutputStream(file_out);
        int ch;
        FileInputStream fis = new FileInputStream(file_in1);
        while ((ch = fis.read())!=-1){
            fos.write(ch);
        }
        fis.close();
        fis=new FileInputStream(file_in2);
        while ((ch=fis.read())!=-1){
            fos.write(ch);
        }
        fis.close();

        fos.flush();
        fos.close();
    }

    //Написать метод поиска слова внутри файла

    public static  boolean isInFile(String fileName, String search) throws  IOException{
        FileInputStream fis = new FileInputStream(fileName);
        byte[] searchSequence=search.getBytes();
        int ch;
        int i=0;
        while ((ch=fis.read())!=-1){
            if(ch==searchSequence[i]){
                i++;
            }else {
                i=0;
                if ((ch == searchSequence[i])){
                    i++;
                }
            }
            if (i==searchSequence.length){
                fis.close();
                return  true;
            }
        }
        fis.close();
        return  false;
    }
}
