import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //        CCC---Для сохранения лога используйте экземпляр класса StringBuilder
    public static StringBuilder log = new StringBuilder();
//        Для сохранения лога используйте экземпляр класса StringBuilder ---CCC

    public static void main(String[] args) {
	/*
	Установку программы необходимо производить из Java кода с использованием класса File.
	Процесс будет состоять из следующих этапов:
    В папке Games создайте несколько директорий: src, res, savegames, temp.
    В каталоге src создайте две директории: main, test.
    В подкаталоге main создайте два файла: Main.java, Utils.java.
    В каталог res создайте три директории: drawables, vectors, icons.
    В директории temp создайте файл temp.txt.
Файл temp.txt будет использован для записиси в него информации об успешноном или неуспешном создании файлов и директорий.

Реализация
Для работы с файлом или директорией необходимо создать для них свой экземпляр класса File,
передав в конструктор адрес к файлу или директории. Создать директорию можно с помощью метода mkdir(),
который возвращает true или false в зависимости от того, была ли директория создана успешно.

Для создания файла можно использовать метод createNewFile(), который так же возвращает boolean.
Обратите внимание, что этот метод пробрасывает IOException. Необходимо обернуть его в блок try-catch.

Для сохранения лога используйте экземпляр класса StringBuilder.
Добавляйте в него всю информацию о создании файлов и каталогов.
Далее возьмите из него текст и запишите его в файл temp.txt с помощью класса FileWriter.

В результате выполнения программы,
на жестком диске комьютера в папке Games должны появиться вышеуказанные файлы и директории.
Файл temp.txt должен содержать информацию о том, что все файлы были созданы успешно.
	 */

//        CCC---В папке Games создайте несколько директорий: src, res, savegames, temp.
        File dirGames = new File("Games");
        dirGames.mkdir();
        File fileSrc = createDir(dirGames, "src");
        File fileRes = createDir(dirGames, "res");
        File fileSavegames = createDir(dirGames, "savegames");
        File fileTemp = createDir(dirGames, "temp");
////        В папке Games создайте несколько директорий: src, res, savegames, temp.---CCC
////        CCC---В директории temp создайте файл temp.txt.
        File fileTempTxt = createFile(fileTemp, "temp.txt");
////        В директории temp создайте файл temp.txt.---CCC
////        CCC---В каталоге src создайте две директории: main, test.
        File fileTest = createDir(fileSrc, "test");
        File fileMain = createDir(fileSrc, "main");
////        В каталоге src создайте две директории: main, test.---CCC
////        CCC---В подкаталоге main создайте два файла: Main.java, Utils.java
        File fileMainJava = createFile(fileMain, "Main.java");
        File fileUtilsJava = createFile(fileMain, "Utils.java");
//        В подкаталоге main создайте два файла: Main.java, Utils.java---CCC
//       CCC---В каталогe res создайте три директории: drawables, vectors, icons
        File filedrawables = createDir(fileRes, "drawables");
        File filevectors = createDir(fileRes, "vectors");
        File fileicons = createDir(fileRes, "icons");
//      В каталогe res создайте три директории: drawables, vectors, icons---CCC
//      CCC---Далее возьмите из него текст и запишите его в файл temp.txt с помощью класса FileWriter
        try {
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTempTxt));
           bufferedWriter.write(log.toString());
           bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(log.toString());


    }

    public static File createFile(File dir, String nameFiles) {
        File file = null;
        try {
            file = new File(dir.getPath() + "//"+ nameFiles);
            file.createNewFile();
            log.append(file.getName() +  "\n");
            System.out.println(file.getName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }
    public static File createDir(File dir, String nameFiles) {
        File dirResult = null;
        dirResult = new File(dir.getPath() + "//"+  nameFiles);
        if(dirResult.mkdir()){
            log.append(dirResult.getName() +  "\n");
            System.out.println(dirResult.getName());
        }
        return dirResult;
    }
}
