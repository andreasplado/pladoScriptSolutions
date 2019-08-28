package ap.woodcutting.script.data;

import org.rspeer.runetek.api.movement.position.Area;

public enum Location {
    LUMBRIDGE_TREE_AREA(Area.rectangular(3170, 3257, 3181, 3247), Tree.TREE),
    LUMBRIDGE_OAK_AREA(Area.rectangular(3200, 3247, 3207, 3237), Tree.TREE, Tree.OAK),
    DRAYNOR_WILLOW_AREA(Area.rectangular(3080, 3238, 3094, 3222), Tree.WILLOW)
    ;

    private Area treeArea;
    private Tree[] trees;

    Location(Area treeArea, Tree... trees) {
        this.treeArea = treeArea;
        this.trees = trees;
    }

    public Area getTreeArea() {
        return treeArea;
    }

    public Tree[] getTrees() {
        return trees;
    }
}
