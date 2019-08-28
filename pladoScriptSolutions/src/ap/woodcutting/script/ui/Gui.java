package ap.woodcutting.script.ui;

import ap.woodcutting.script.FirstScript;
import ap.woodcutting.script.data.Location;
import ap.woodcutting.script.data.Tree;
import net.miginfocom.swing.MigLayout;
import org.rspeer.runetek.api.Game;
import org.rspeer.script.task.Task;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class Gui extends Task {

    private boolean validate = true;

    private JCheckBox powercutCheckBox;
    private JComboBox treesComboBox;
    private JComboBox locationsComboBox;
    private JButton startBtn;

    private JFrame frame;

    public Gui() {
        frame = new JFrame("RspeerTutorial settings");
        frame.setLayout(new MigLayout());
        frame.setPreferredSize(new Dimension(200, 200));

        powercutCheckBox = new JCheckBox("Powercutting?");
        locationsComboBox = new JComboBox(Location.values());
        treesComboBox = new JComboBox(Tree.values());
        startBtn = new JButton("Start");

        frame.add(powercutCheckBox, "wrap, growx");
        frame.add(locationsComboBox, "wrap, growx");
        frame.add(treesComboBox, "wrap, growx");
        frame.add(startBtn, "growx");

        locationsComboBox.addItemListener(this::locationsSelectionHandler);
        startBtn.addActionListener(x -> startBtnHandler());

        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(Game.getCanvas());
        frame.pack();

        frame.setVisible(true);
    }

    @Override
    public boolean validate() {
        return validate;
    }

    @Override
    public int execute() {
        return 1000;
    }

    private void locationsSelectionHandler(ItemEvent e) {
        Location selection = (Location) e.getItem();
        treesComboBox.setModel(new DefaultComboBoxModel(selection.getTrees()));
    }

    private void startBtnHandler() {
        FirstScript.powercutting = powercutCheckBox.isSelected();
        FirstScript.tree = (Tree) treesComboBox.getSelectedItem();
        FirstScript.locations = (Location) locationsComboBox.getSelectedItem();
        validate = false;
        frame.setVisible(false);
    }
}
