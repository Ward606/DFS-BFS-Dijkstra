import java.util.*;

public class Graph {
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed ;
    // for weights
    private int numOfNOdes;
    int[] traverse;

    float nodeLink[][] ;

    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
        numOfNOdes =15;
        nodeLink = new float[numOfNOdes][numOfNOdes];
        traverse= new int[numOfNOdes];

    }

    public void addEdgeHelper(Node a, Node b){
        LinkedList<Node> temp = adjacencyMap.get(a);
        if(temp != null){
            temp.remove(b);
        }

        else temp = new LinkedList<>();
        temp.add(b);
        adjacencyMap.put(a,temp);
        nodeLink[a.n][b.n] = 1;

    }
    public void addEdgeHelper(Node a, Node b, float w){
        LinkedList<Node> temp = adjacencyMap.get(a);
        if(temp != null){
            temp.remove(b);
        }

        else temp = new LinkedList<>();
        temp.add(b);
        adjacencyMap.put(a,temp);
        nodeLink[a.n][b.n] = w;

    }

    public void addEdge(Node source, Node dest){


        if(!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source, null);
        if (!adjacencyMap.keySet().contains(dest))
            adjacencyMap.put(dest,null);

        addEdgeHelper(source,dest);

        if(!directed){
            addEdgeHelper(dest, source);
        }
    }

    public void addEdge(Node source, Node dest, float weight ){

        //HashMap<HashMap<Node,Node>,Float> weights = new HashMap<>();

        if(!adjacencyMap.keySet().contains(source)) {
            adjacencyMap.put(source, null);

        }
        if (!adjacencyMap.keySet().contains(dest)) {
            adjacencyMap.put(dest, null);

        }

        addEdgeHelper(source,dest,weight);


        if(!directed){
            addEdgeHelper(dest, source,weight);
        }

    }
    public float getWeight(Node source,Node dest){

        return nodeLink[source.n][dest.n];

    }
    public void printEdges(){
        for(Node node : adjacencyMap.keySet()){
            System.out.print("The" + node.name + " has an edge towards: ");
            if(adjacencyMap.get(node) != null){
                for (Node neighbor : adjacencyMap.get(node))
                    System.out.print(neighbor.name + ' ');
                System.out.println();
            }
            else
                System.out.println();
        }
    }
    public boolean hasEdge(Node source, Node dest){
        return  adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null
                && adjacencyMap.get(source).contains(dest);
    }

    public void resetNodesVisited(){
        for( Node node : adjacencyMap.keySet())
            node.unvisit();
    }

    public void DFTraversal(Node node) {
        node.visit();
        System.out.print(node.name + ' ');
        traverse[it] = node.n;
        it++;
        LinkedList<Node> allNeighbors = adjacencyMap.get(node);
        if (allNeighbors == null)
            return;

        for (Node neighbor : allNeighbors) {
            if (!neighbor.visited)
                DFTraversal(neighbor);
        }
       /* for (Node n : adjacencyMap.keySet()) {
            if (!n.visited) {
                dfsTravers(n);
            }
        }*/
    }
    public void DFSearch(Node root,Node dest){
        DFTraversal(root);
        for(int i =0 ; i<=dest.n; i++) {
            System.out.print(traverse[i] + "--> ");
        }
    }

    private int it;
    public void BFTraversal(Node node){

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node curentFirst = queue.removeFirst();
            if(curentFirst.visited)
                continue;
            curentFirst.visit();
            System.out.print(curentFirst.name + ' ');


           // int[] traverse= new int[numOfNOdes];
            traverse[it] = curentFirst.n;
            it++;
            LinkedList<Node> allNieghbors = adjacencyMap.get(curentFirst);
            if(allNieghbors == null)
                continue;
            for( Node nieghbor : allNieghbors){
               if(!nieghbor.visited){
                   queue.add(nieghbor);
                   //traverse[i] = nieghbor.n;
                   //i++;
               }
            }
        }
        System.out.println();
        /*
        for (Node n : adjacencyMap.keySet()) {
            if (!n.visited) {
                BFTraversal(n);
            }
        }*/


    }
    public void BFSearch(Node root,Node dest){
        BFTraversal(root);

        for(int i =0 ; i<=numOfNOdes; i++) {
            System.out.print(traverse[i]+ "--> ");
            if(dest.n == traverse[i])
                break;
        }
    }

    private float distance = 0;
    public void DijkstraTraversal(Node node){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashMap<Node,Float> nodeDistance = new HashMap<>();
        nodeDistance.put(node,distance );
        pq.add(node);
        while (!pq.isEmpty()){
            Node currentNode = pq.poll();

            if(currentNode.visited)
                continue;
            currentNode.visit();
            System.out.print(currentNode.name + ' ');
            LinkedList<Node> allNieghbors = adjacencyMap.get(currentNode);
            for (Node neighbor : allNieghbors){
                if(!neighbor.visited){
                     distance = nodeDistance.get(currentNode)+ this.getWeight(currentNode,neighbor);
                    // System.out.println(nodeDistance.get(neighbor));
                     if(distance < neighbor.getDistance()){
                            pq.remove(neighbor);
                            nodeDistance.put(neighbor,distance);
                            neighbor.setDistance(distance);
                            pq.add(neighbor);
                     }
                }
            }

        }
    }
    private float m = 333;
    public void DijkstraSearch(Node root,Node dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashMap<Node, Float> nodeDistance = new HashMap<>();
        nodeDistance.put(root, distance);
        pq.add(root);
        Node goal;
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();


            if (currentNode.visited)
                continue;
            currentNode.visit();
            String[] road = new String[numOfNOdes];
            road[0] = root.name;
            it = 1;
            road[it] = currentNode.name;
            it++;
            LinkedList<Node> allNieghbors = adjacencyMap.get(currentNode);
            for (Node neighbor : allNieghbors) {
                if (!neighbor.visited) {
                    distance = nodeDistance.get(currentNode) + this.getWeight(currentNode, neighbor);
                    // System.out.println(nodeDistance.get(neighbor));
                    if (distance < neighbor.getDistance()) {
                        // pq.remove(neighbor);
                        nodeDistance.put(neighbor, distance);
                        neighbor.setDistance(distance);
                        pq.add(neighbor);

                        if (neighbor.name == dest.name) {
                            //goal = dest;
                           // if (neighbor.getDistance() < goal.getDistance()) {
                                goal = neighbor;
                                //m = goal.getDistance();
                            for (int i = 0; i < it; i++)
                                System.out.print(road[i] + " ");
                            System.out.println(goal.name);
                            System.out.println("The cost is: " + goal.getDistance());
                                if (goal.getDistance() <= m) {
                                    m = goal.getDistance();

                                }


                        }
                    }
                }
            }

        }
        System.out.print("The path with: " + m + " cost is the best result ");
        /*for (int i = 0; i < it; i++)
            System.out.print(road[i] + " ");
        System.out.println(goal.name);
        System.out.println("The cost is: " + goal.getDistance());*/


    }
}
