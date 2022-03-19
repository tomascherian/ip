package pac.command;

import pac.task.TaskList;
import pac.ui.Ui;
import pac.storage.Storage;

import java.io.IOException;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws IOException;

    public boolean isExit() {
        return false;
    }
}