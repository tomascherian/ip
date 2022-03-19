package pac;

import pac.command.Command;
import pac.parser.Parser;
import pac.storage.Storage;
import pac.task.TaskList;
import pac.ui.Ui;

import java.io.IOException;

public class Pac {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Pac(String filePath) {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.readTasks());
        } catch (IOException e) {
            ui.showLoadingError();
        } catch (PacException e) {
            ui.showPacError(e);
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showLogo();
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (PacException e) {
                ui.showPacError(e);
            } catch (IOException e) {
                ui.showIOError(e);
            } catch (IndexOutOfBoundsException e) {
                ui.showIndexOutOfBoundsError(e);
            } finally {
                ui.showLine();
            }
        }
        ui.closeScanner();
    }

    public static void main(String[] args) {
        new Pac("data/Pac.txt").run();
    }
}