package ap.woodcutting.script.data;

public enum Tree {
    TREE(1, "Tree", "Logs"),
    OAK(15, "Oak", "Oak logs"),
    WILLOW(30, "Willow", "Willow logs"),
    MAPLE(45, "Maple", "Maple logs"),
    YEW(60, "Yew", "Yew logs"),
    MAGIC(75, "Magic", "Magic logs")
    ;

    private int level;
    private String treeName;
    private String logName;

    Tree(int level, String treeName, String logName) {
        this.level = level;
        this.treeName = treeName;
        this.logName = logName;
    }

    public int getLevel() {
        return level;
    }

    public String getTreeName() {
        return treeName;
    }

    public String getLogName() {
        return logName;
    }
}
