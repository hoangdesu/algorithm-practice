import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class CreateTemplateFolder {
    public static void main(String[] args) throws IOException {
        String folderName = "SampleProblemFolder";
        if (args.length > 0)
            folderName = String.join(" ", args);
        
        if (new File(folderName.trim()).exists()) {
            System.out.println("Error. Folder exists!");
            return;
        }

        new File("./" + folderName.trim()).mkdirs();
        System.out.printf("Created template folder \"%s\"\n", folderName);

        copyFile("TemplateSolution.java", folderName + "/Solution.java");
    }

    public static void copyFile(String sourcePath, String destinationPath) {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied template Solution.java file");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}