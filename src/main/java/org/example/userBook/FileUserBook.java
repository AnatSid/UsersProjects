package org.example.userBook;

import org.example.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component("userBookToFile")
@Primary
public class FileUserBook implements UserBook {
    private final String filePath;

    public FileUserBook(@Value("${file.path}") String filePath) {
        this.filePath = filePath;
    }

    //    "UsersRecordsFile"
    private void saveUserToFile(User user) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.toString());
            writer.newLine();
        }
    }

    private List<User> loadUsersFromFile() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUserFromString(line);
                users.add(user);
            }
        }
        return users;
    }

    private void deleteUserFromFile(Integer userId) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUserFromString(line);
                if (!user.getId().equals(userId)) {
                    lines.add(line);
                }
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public User getUserByIdFromFile(int userId) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUserFromString(line);
                if (user.getId() == userId) {
                    return user;
                }
            }
        }
        return null;
    }

    private User parseUserFromString(String line) {
        String[] parts = line.split("\\|");
        String name = parts[0];
        String surName = parts[1];
        int age = Integer.parseInt(parts[2]);
        int id = Integer.parseInt(parts[3]);
        return new User(name, surName, age, id);
    }

    private boolean isUserExist(int userId) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUserFromString(line);
                if (user.getId().equals(userId)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addUser(User user) {
        try {
            if (!isUserExist(user.getId())) {
                saveUserToFile(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return loadUsersFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public User getUserById(Integer userId) {
        try {
            return getUserByIdFromFile(userId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getLastAddedUser() {
        List<User> users;
        try {
            users = loadUsersFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users.stream()
                .max(Comparator.comparing(User::getId))
                .orElse(null);
    }

    @Override
    public void removeUserById(Integer userId) {
        try {
            deleteUserFromFile(userId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
