package background;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Scenery {
    private Set<Action> actions;
    private Set<Action> actGroup;
    int id;

    public Scenery(int id, HashSet<Action> actions) {
        this.id = id;
        this.actions = actions;
        actGroup = new HashSet<Action>();
    }

//    public Scenery(String m) {
//        this.background = m;
//    }

//    public void setScenery(String m, HashSet<Action> a) {
//        this.background = m;
//        this.actions = a;
//    }

//    public String getScenery() {
//        return this.background;
//    }

//    public HashSet<Action> getSetOfActions() {
//        return this.actions;
//    }

    public void actionGroup() throws Exception {
        Boolean validId = false;
        Set<Action> sol = new HashSet<Action>();
        for (Action act : actions) {
            if (act.getId() == id) {
                sol.add(act);
                validId = true;
            }
        }
        if (validId) {
            actGroup = sol;
        } else {
            throw new Exception("Invalid scenary id");
        }
    }

    public Set<Action> getActions() {
        return actions;
    }

    public Set<Action> getActGroup() {
        return actGroup;
    }

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
    
    
}
