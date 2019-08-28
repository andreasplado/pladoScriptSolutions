package ap.woodcutting.script.task;

import ap.woodcutting.script.FirstScript;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;

public class Banking extends Task {

    @Override
    public boolean validate() {
        return Inventory.isFull() && !FirstScript.powercutting;
    }

    @Override
    public int execute() {
        if (!Bank.isOpen()) {
            Bank.open();
            return 1000;
        }

        Bank.depositAll(FirstScript.tree.getLogName());
        return 1000;
    }
}