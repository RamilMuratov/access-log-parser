import java.io.*;
import java.util.Objects;
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
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                int sch = 0; // Счетчик: общее количество строк в файле
                int min = 1024; // Самая короткая строка в файле
                int max = 0; // Самая длинная строка в файле
                double yandex = 0; //Доля Яндекс
                double google = 0; //Доля Гугл
                while ((line = reader.readLine()) != null) {

                    if (line.length() > max) {
                        max = line.length();
                    }

                    if (max >= 1024) throw new RuntimeException("Строка имеет длину 1024 символа или более");

                    if (line.length() < min) {
                        min = line.length();
                    }
                    String[] parts1 = line.split(";");
                    if (parts1.length >= 2) {
                        String fragment = parts1[1];
                        fragment = fragment.replaceAll(" ", "");
                        String[] parts2 = fragment.split("/");
                        if (parts2.length >= 2) {
                            String fragment_rs = parts2[0];
                            if (Objects.equals(fragment_rs, "YandexBot")) {
                                yandex++;
                            }
                            if (Objects.equals(fragment_rs, "Googlebot")) {
                                google++;
                            }
                        }
                    }
                        sch++;
                    }
                    System.out.println("Количество строк в файле: " + sch);
                    System.out.println("Яндекс: "+ (yandex/sch));
                    System.out.println("Гугл: "+ (google/sch));
            }
            catch (Exception ex){
                    System.out.println(ex.getMessage());
            }
        }
    }
}