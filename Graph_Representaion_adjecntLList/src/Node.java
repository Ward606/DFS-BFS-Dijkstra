public class Node implements Comparable<Node> {
    int n;
    String name;
    boolean visited;
    private float distance = Float.MAX_VALUE;
    Node(int n, String name){
        this.n = n;
        this.name = name;
        visited = false;
    }
    void visit(){
        visited = true;
    }
    void unvisit(){
        visited = false;
    }
    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Node node) {
        return Float.compare(this.distance,node.getDistance());
    }
}
