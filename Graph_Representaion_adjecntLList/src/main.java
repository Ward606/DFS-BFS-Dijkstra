import java.util.HashMap;

public class main {
    public static void main(String[] args) {


      /*  Graph graph = new Graph(true);
        Node zero = new Node(0, "0");
        Node one = new Node(1, "1");
        Node two = new Node(2, "2");
        Node three = new Node(3, "3");
        Node four = new Node(4, "4");
        Node five = new Node(5, "5");
        Node six = new Node(6, "6");
        Node seven = new Node(7, "7");
        Node eight = new Node(8, "8");

        graph.addEdge(one,zero);
        graph.addEdge(three,one);
        graph.addEdge(two,seven);
        graph.addEdge(two,four);
        graph.addEdge(five,two);
        graph.addEdge(five,zero);
        graph.addEdge(six,five);
        graph.addEdge(six,three);
        graph.addEdge(six,eight);
        graph.addEdge(seven,five);
        graph.addEdge(seven,six);
        graph.addEdge(seven,eight);

        graph.dfsTravers(seven);
        */
        Graph graph = new Graph(false);
        Node a = new Node(0, "a");
        Node b = new Node(1, "b");
        Node c = new Node(2, "c");
        Node d = new Node(3, "d");
        Node e = new Node(4, "e");
        Node f = new Node(5, "f");
        Node g = new Node(6, "g");

        graph.addEdge(a,b,4);
        graph.addEdge(a,c,1);
        graph.addEdge(a,d,1);
        graph.addEdge(b,e,1);
        graph.addEdge(b,f,1);
        graph.addEdge(b,g,1);
        graph.addEdge(c,g,5);

        /* DFTravesal throw all the nodes
        graph.DFTraversal(a);
        System.out.println();*/

        /*DFS
        graph.DFSearch(a,g);
        System.out.println();
        */

        /*BFTravesal throw all the nodes
        graph.BFTraversal(a);
        System.out.println();
        */
         /*BFS
        graph.BFSearch(a,g);
        System.out.println();
        */

        /* Dijkstra Traversal throw all the nodes
        graph.DijkstraTraversal(a);
        */

         /* Dijkstra search
        graph.DijkstraSearch(a,g);
            */



    }
}
