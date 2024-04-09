import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1; // Счетчик: количество верно указанных путей к файлу
        for (;;){
            System.out.println("Введите путь к файлу");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            if (!fileExists) {
                System.out.println("Файл не существует или введен неверный путь");
                continue;
            }
            boolean isDirectory = file.isDirectory();
            if (!isDirectory){
                System.out.println("Путь указан верно"+"\n"+count+" Верных путей");
                count++;
            }
            else
            {
                System.out.println("Файл не существует или введен неверный путь");
            }
            try (
                    FileReader fileReader = new FileReader(path)) {
                BufferedReader reader =
                        new BufferedReader(fileReader);
                String line;
                int sch = 0; // Счетчик: общее количество строк в файле
                int min = reader.readLine().length(); // Самая короткая строка в файле
                int max = 0; // Самая длинная строка в файле
                while ((line = reader.readLine()) != null) {

                    if (line.length() > max){
                        max = line.length();
                    }

                    if (max>=1024) throw new RuntimeException("Строка имеет длину 1024 символа или более");

                    if (line.length() < min){
                        min = line.length();
                    }
                    sch++;
                }
                System.out.println("Количество строк в файле: " + sch);
                System.out.println("Самая короткая строка в файле равна "+ min +" символам");
                System.out.println("Самая длинная строка в файле равна "+ max +" символам");
                //System.out.println(offer);
            }
            catch (Exception ex){ex.printStackTrace();}
        }
    }
}
