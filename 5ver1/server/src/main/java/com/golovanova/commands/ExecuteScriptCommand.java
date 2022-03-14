package com.golovanova.commands;

import com.golovanova.data.DataSource;
import com.golovanova.data.LinesDataSource;
import com.golovanova.CommandType;
import com.golovanova.utility.CollectionInfo;
import com.golovanova.model.Worker;
import com.golovanova.utility.CommandDecoder;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExecuteScriptCommand extends AbstractCommand implements Serializable {
    private Stack<String> fileNames = new Stack<>();
    static final long SerialVersionUID = -4862926644813433707L;

    public ExecuteScriptCommand() {
        super(CommandType.execute_script);
    }

    public void execute(String filename, List<Worker> workers, CollectionInfo collectionInfo) {
        try {
            File file = new File(filename);
            if (!file.canRead())
                file.setReadable(true);


            List<String> strings = Files.readAllLines(file.toPath());
            LinesDataSource dataSource = new LinesDataSource(strings);

            while (!dataSource.endOfData()) {
                String line = dataSource.nextLine();
                choseCommand(line, dataSource, workers, collectionInfo);
            }
        } catch (Exception e) {
            System.err.println("File cannot be read!");
        }

    }

    public void choseCommand(String line,
                             DataSource dataSource,
                             List<Worker> workers,
                             CollectionInfo collectionInfo) {


        ArrayList<CommandType> history = new ArrayList<>();
        CommandType commandType = CommandDecoder.decode(line);
        history.add(commandType);

        switch (commandType) {
//            case help:
//                new HelpCommand().execute();
//                break;
//            case info:
//                new InfoCommand().execute(workers, collectionInfo);
//                break;
//            case history:
//                new HistoryCommand().execute(history, commandType);
//                break;
//            case remove_by_id:
//                new RemoveByIdCommand().execute(workers, Integer.parseInt(line.split(" ")[1]));
//                break;
//            case add:
//                new AddCommand(dataSource,commandType).execute(workers);
//                break;
//            case average_of_salary:
//                new AverageOfSalaryCommand(commandType).execute(workers);
//                break;
//            case clear:
//                new ClearCommand(commandType).execute(workers);
//                break;
//            case execute_script:
//                //System.out.println("Recursion is prohibited.");
//                new ExecuteScriptCommand(commandType).execute(line.split(" ")[1], workers, collectionInfo, fileManager);
//                break;
//            case exit:
//                new ExitCommand(commandType).execute();
//                break;
//            case remove_any_by_organization:
//                new RemoveAnyByOrganizationCommand(commandType).execute(workers, line.split(" ")[1]);
//                break;
//            case remove_head:
//                new RemoveHeadCommand(commandType).execute(workers);
//                break;
//            case remove_lower:
//                try {
//                    new RemoveLowerCommand(commandType).execute(line.split(" ")[1], workers);
//                } catch (WorkerNotFoundException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case filter_by_organization:
//                new FilterByOrganizationCommand(commandType).execute(workers, line.split(" ")[1]);
//                break;
//            case save:
//                new SaveCommand(commandType).execute(workers, fileManager, collectionInfo);
//                break;
//            case show:
//                new ShowCommand(commandType).execute(workers);
//                break;
//            case update:
//                try {
//                    new UpdateCommand(dataSource,commandType).execute(workers);
//                } catch (WorkerNotFoundException e) {
//                    System.err.println("This worker does not exists!");
//                }
//                break;
            default:
                System.err.println("No such command. Try again!");
        }
    }
}
