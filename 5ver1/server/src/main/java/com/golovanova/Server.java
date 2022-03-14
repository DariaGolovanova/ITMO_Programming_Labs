package com.golovanova;


import com.golovanova.model.Worker;
import com.golovanova.server.Controller;
import com.golovanova.utility.CollectionFileManager;
import com.golovanova.utility.CollectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private static Logger log = LoggerFactory.getLogger(Server.class.getName());

    public static void main(String[] args) {
        String filePath = "data.json";

        if (args.length > 0)
            filePath = args[0];

        File file = new File(filePath);
        if (file.isFile() && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("New file was created!");
            }
        }

        CollectionInfo collectionInfo = new CollectionInfo(LocalDateTime.now());
        CollectionFileManager collectionFileManager = new CollectionFileManager(file, collectionInfo);
        List<Worker> workers = collectionFileManager.readCollection();

        try {
            Thread serverThread = new Controller(workers, collectionFileManager, collectionInfo);
            System.out.println("Server starting...");
            serverThread.start();
            System.out.println("Server started");
        } catch (SocketException e) {
            System.err.println("Woah! Something is wrong with server! Catch exception: " + e);
        }
    }
}
