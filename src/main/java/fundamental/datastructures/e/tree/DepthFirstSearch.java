package fundamental.datastructures.e.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George Fouche on 1/22/20.
 */
public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> inputArray) {
            //Added code
            inputArray.add(this.name);
            for(int i =0; i < children.size();i++){
                children.get(i).depthFirstSearch(inputArray);
            }
            return inputArray;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {

        /**
         *      A
         *     /\
         *    B C
         *   /
         *  D
         *
         */
        DepthFirstSearch.Node dfs = new DepthFirstSearch.Node("A");
        dfs.addChild("B").addChild("C");
        dfs.children.get(0).addChild("D");
        List<String> inputArray = new ArrayList<>();
        System.out.println(dfs.depthFirstSearch(inputArray));

    }
}
