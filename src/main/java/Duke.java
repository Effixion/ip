import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        // Deals with interactions with the user
        // Most likely will be using Scanner
        // Returns messages/error messages to the user
        ui = new Ui();

        // Deals with loading tasks from the file and
        // saving them in the file
        storage = new Storage(filePath);

        // Loading the tasks in the file to the taskList
        tasks = new TaskList(storage.load());
    }

    public void run() {

        // Deals with reading user commands
        Parser parser = new Parser(tasks, storage, ui);

        // Greets the user
        System.out.println(ui.getWelcome());

        // Awaiting input
        Scanner input = new Scanner(System.in);
        while (true) {
            String s = input.nextLine();
            try {
                System.out.println(parser.readInputString(s));
                if (s.equals("bye")) {
                    break;
                }
            } catch (InvalidDescriptionException | InvalidCommandException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }
}
