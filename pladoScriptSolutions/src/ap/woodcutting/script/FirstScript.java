package ap.woodcutting.script;

import ap.woodcutting.script.data.Tree;
import ap.woodcutting.script.task.Traverse;
import ap.woodcutting.script.task.Woodcut;
import ap.woodcutting.script.ui.Gui;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.commons.StopWatch;
import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.event.listeners.RenderListener;
import org.rspeer.runetek.event.types.RenderEvent;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;
import ap.woodcutting.script.task.Banking;
import ap.woodcutting.script.task.Drop;
import ap.woodcutting.script.data.Location;
import org.rspeer.ui.Log;

import java.awt.*;

@ScriptMeta(developer = "AP", desc = "Woodcutting", name = "Woodcut for luck you basterd")
public class FirstScript extends TaskScript implements RenderListener {

    private static final Task[] TASKS = {new Gui(), new Banking(), new Drop(), new Traverse(), new Woodcut()};
    public static boolean powercutting = false;
    public static Tree tree = Tree.TREE;
    public static Location locations = Location.LUMBRIDGE_TREE_AREA;
    private StopWatch runtime;
    private int startExp;

    @Override
    public void onStart() {
        Log.fine("Script started.");
        runtime = StopWatch.start();
        startExp = Skills.getExperience(Skill.WOODCUTTING);
        submit(TASKS);
    }


    @Override
    public void onStop() {
        //When the script is stopped the segment of code in this method will be ran once.
        Log.severe("Stopped script.");
    }

    @Override
    public void notify(RenderEvent renderEvent) {
        Graphics g = renderEvent.getSource();

        int gainedExperience = Skills.getExperience(Skill.WOODCUTTING) - startExp;

        g.drawString("Runtime: " + runtime.toElapsedString(), 20, 20);
        g.drawString("Exp gained: " + gainedExperience, 20, 40);
        g.drawString("Exp /h: " + runtime.getHourlyRate(gainedExperience), 20, 60);
    }
}
