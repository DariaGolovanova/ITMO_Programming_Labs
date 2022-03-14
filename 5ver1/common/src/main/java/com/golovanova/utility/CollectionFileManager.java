package com.golovanova.utility;

import com.golovanova.adapter.ZonedDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.golovanova.model.Worker;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

public class CollectionFileManager {
    private final File file;
    private final Gson gson;
    private final CollectionInfo collectionInfo;

    public CollectionFileManager(File file, CollectionInfo collectionInfo) {
        this.file = file;
        this.collectionInfo = collectionInfo;

        this.gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
                .enableComplexMapKeySerialization()
                .create();
    }

    public void writeCollection(Collection<?> collection) {
        if (file == null || !file.isFile() || !file.exists() || !file.canWrite()) {
            System.err.println("Cannot use this file!");
            return;
        }

        try (PrintWriter collectionFileWriter = new PrintWriter(file)) {
            collectionFileWriter.write(gson.toJson(collection));
            collectionInfo.updateSaveTime(LocalDateTime.now());
            System.out.println("Collection successfully saved to file!");
        } catch (IOException exception) {
            System.err.println("The boot file is a directory/cannot be opened!");
        }
    }

    public List<Worker> readCollection() {
        if (file == null) {
            System.err.println("File is null!");
            return new ArrayList<>();
        }

        if (!file.isFile() || !file.exists() || !file.canRead()) {
            System.err.println("File is corrupted!");
            return new ArrayList<>();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            Type collectionType = new TypeToken<List<Worker>>() {
            }.getType();

            ArrayList<Worker> collection = gson.fromJson(reader.readLine().trim(), collectionType);
            System.out.println("Collection is downloaded!");

            CollectionInfo collectionInfo = new CollectionInfo(LocalDateTime.now());
            collectionInfo.updateSaveTime(LocalDateTime.now());

            Worker.updateIdSequence(collection);

            return collection;
        } catch (FileNotFoundException exception) {
            System.err.println("The boot file was not found!");
        } catch (NoSuchElementException exception) {
            System.err.println("The boot file is empty!");
        } catch (JsonParseException | NullPointerException exception) {
            System.err.println("The required collection was not found in the boot file!" + exception);
        } catch (IllegalStateException | IOException exception) {
            System.err.println("Unexpected error!");
            System.exit(0);
        }


        return new ArrayList<>();
    }
}
