package org.example.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
@Primary
public class FileIdGenerator implements UserIdGenerator {

    private int id;
    private final String filePath;

    public FileIdGenerator(@Value("${file.path.id}") String filePath) {
        this.filePath = filePath;
        this.id = loadIdFromFile(filePath);
    }

    private void saveIdToFile(int id) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(id));
        }
    }

    private int loadIdFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                id = Integer.parseInt(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public int getNextId() {
        id++;
        try {
            saveIdToFile(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
