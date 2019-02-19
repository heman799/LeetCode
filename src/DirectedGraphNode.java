import java.util.ArrayList;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    //constructor
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}