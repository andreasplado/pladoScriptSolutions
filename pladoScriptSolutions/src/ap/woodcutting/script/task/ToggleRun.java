package ap.woodcutting.script.task;

import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.script.task.Task;

public class ToggleRun extends Task {
    @Override
    public boolean validate() {
        return !Movement.isRunEnabled() && Movement.getRunEnergy() > 4;
    }

    @Override
    public int execute() {
        Movement.toggleRun(true);
        return 1000;
    }
}