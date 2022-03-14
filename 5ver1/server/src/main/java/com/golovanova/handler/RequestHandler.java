package com.golovanova.handler;

import com.golovanova.commands.*;
import com.golovanova.dto.CommandMessage;
import com.golovanova.dto.PayloadCommandMessage;
import com.golovanova.dto.SimpleCommandMessage;
import com.golovanova.dto.StringCommandMessage;
import com.golovanova.exception.ScriptRecursionException;
import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.CommandType;
import com.golovanova.model.Worker;
import com.golovanova.net.ClientRequest;
import com.golovanova.net.ServerResponse;
import com.golovanova.net.Sender;
import com.golovanova.utility.CollectionFileManager;
import com.golovanova.utility.CollectionInfo;
import com.golovanova.utility.RecursionChecker;

import java.io.IOException;
import java.util.List;

public class RequestHandler {
    private final Sender sender;
    private final List<Worker> workers;
    private final CollectionInfo collectionInfo;
    private final RecursionChecker recursionChecker;
    private final CollectionFileManager collectionFileManager;


    public RequestHandler(List<Worker> workers, CollectionInfo collectionInfo, CollectionFileManager collectionFileManager) {
        this.collectionFileManager = collectionFileManager;
        this.sender = new Sender();

        this.workers = workers;
        this.collectionInfo = collectionInfo;
        this.recursionChecker = new RecursionChecker();
    }

    public void handle(ClientRequest clientRequest) throws IOException, ScriptRecursionException {
        CommandMessage commandMessage = clientRequest.getCommandMessage();

        if (commandMessage instanceof SimpleCommandMessage) {
            SimpleCommandMessage simpleMessage = (SimpleCommandMessage) commandMessage;
            CommandType commandType = simpleMessage.getCommandType();

            switch (commandType) {
                case help -> {
                    String result = new HelpCommand().execute();
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }
                case info -> {
                    String result = new InfoCommand().execute(collectionInfo);
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }

                case average_of_salary -> {
                    double result = new AverageOfSalaryCommand().execute(workers);
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }
                case remove_head -> {
                    Worker result = new RemoveHeadCommand().execute(workers);
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }
                case show -> {
                    String result = new ShowCommand().execute(workers);
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }
                case clear -> {
                    List<Worker> result = new ClearCommand().execute(workers);
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }
            }
        }

        if (commandMessage instanceof StringCommandMessage) {
            StringCommandMessage stringMessage = (StringCommandMessage) commandMessage;
            CommandType commandType = stringMessage.getCommandType();

            switch (commandType) {
                case filter_by_organization -> {
                    String result = new FilterByOrganizationCommand().execute(workers, stringMessage.getArgument());
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }

                case execute_script -> {
                    if(recursionChecker.checkRecursionIsPresent(stringMessage.getArgument())) {
                        throw new ScriptRecursionException("Recursion in file: " + stringMessage.getArgument());
                    }

                    new ExecuteScriptCommand().execute(stringMessage.getArgument(), workers, collectionInfo);
                    String result = "script executed";
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }

                case remove_any_by_organization -> {
                    List<Worker> result = new RemoveAnyByOrganizationCommand().execute(workers, stringMessage.getArgument());
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }

                case remove_by_id -> {
                    List<Worker> result = new RemoveByIdCommand().execute(workers, Integer.parseInt(stringMessage.getArgument()));
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);
                }

                case remove_lower -> {
                    try {
                        List<Worker> result = new RemoveLowerCommand().execute(workers,stringMessage.getArgument());
                        ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                        sender.send(serverResponse);
                    } catch (WorkerNotFoundException exception) {
                        exception.printStackTrace();
                    }
                }

            }

        }
        if (commandMessage instanceof PayloadCommandMessage) {
            PayloadCommandMessage payloadMessage = (PayloadCommandMessage) commandMessage;
            CommandType commandType = payloadMessage.getCommandType();
            switch (commandType) {
                case add -> {
                    List<Worker> result = new AddCommand(collectionFileManager).execute(workers, payloadMessage.getPayload().getWorker());
                    ServerResponse serverResponse = new ServerResponse(clientRequest.getInetAddress(), clientRequest.getPort(), result);
                    sender.send(serverResponse);

                }

            }

        }
    }
}
