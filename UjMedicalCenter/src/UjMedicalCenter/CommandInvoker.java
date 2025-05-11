package UjMedicalCenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CommandInvoker {
    private Map<Integer, Command> commandMap = new HashMap<>();
    private Stack<Command> commandHistory = new Stack<>();

    public void registerCommand(int option, Command command) {
        commandMap.put(option, command);
    }

    public void executeCommand(int option) {
        Command command = commandMap.get(option);
        if (command != null) {
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("Invalid command option.");
        }
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command last = commandHistory.pop();
            last.undo();
        } else {
            System.out.println("No command to undo.");
        }
    }
}
