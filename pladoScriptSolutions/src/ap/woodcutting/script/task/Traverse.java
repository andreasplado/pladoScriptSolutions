package ap.woodcutting.script.task;

import ap.woodcutting.script.FirstScript;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

public class Traverse extends Task {

    @Override
    public boolean validate() {
        return !FirstScript.locations.getTreeArea().contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Movement.walkTo(FirstScript.locations.getTreeArea().getCenter());
        return 1000;
    }
}
