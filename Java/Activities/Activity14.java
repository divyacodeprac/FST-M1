package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activity14 {

    public static void main(String[] args) throws IOException {
        File f = new File("src/main/java/activities/input.txt");
        f.createNewFile();

        FileWriter writer = new FileWriter("src/main/java/activities/input.txt");
        writer.write("Sample test data for testing");
        writer.close();

        File file =FileUtils.getFile("src/main/java/activities/input.txt");
        System.out.println("Data in file ------" + FileUtils.readFileToString(file,"UTF-8"));

        File dir = new File("resources");
        FileUtils.copyFileToDirectory(file,dir);

        File newFile =FileUtils.getFile(dir,"input.txt");
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        System.out.println("Data in new file  " +newFileData);
    }
}
