package simbirsoft.helpers;

import io.qameta.allure.Allure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Attach {
    public static void attachCSVFile() {
        File csvFile = new File("src/test/resources/transactions.csv");
        try {
            String content = new String(Files.readAllBytes(Paths.get(csvFile.getPath())));
            Allure.addAttachment("transactions.csv", "text/csv", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





