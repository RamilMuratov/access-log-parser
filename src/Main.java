import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
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
        }
    }
}
