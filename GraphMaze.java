package sjsu.NguyenSwe.cs146.project3.graphMaze;

/**
 * Created by Philip on 11/30/2016.
 */
import java.util.List;
import java.util.Random;

/**
 * Created by Philip on 11/27/2016.
 * Modified by Aye on 11/29/2016.
 */
public class GraphMaze{
    /******* Properties *******/
    private final int MAX_VERTS = 4;//this is tempory to test stuff
    private Vertex vertexList[];// list of vertices
    private char adjMat[][]; // adjacecy matrix
    private int nVerts;// number of vertices
    private Queue theQueue;//for bfs search
    private int size; //the maze's size(which will be square)
    private Vertex[] vertList; //list of vertices
    private List[] adjList; //The way to recognize edges
    private Random rng; //Random Number Generator



    /******* GraphMaze Constructor *******/
    public GraphMaze(int newSize){
        size = newSize;
        adjList = new List[size];
        vertList = new Vertex[size];
    }//end constructor


    double myRandom(){
        return rng.nextDouble(); //number between 0 and 1
    }

    /***overloaded constructor***/
    public GraphMaze() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new char[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        //System.out.println("in Graph nVerts is: " + nVerts);
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
                adjMat[j][k] = '0';//will change to the maze structure
        theQueue = new Queue();

    }

    //just for test purpose
    public void printVertic(){
        for (int i =0; i<MAX_VERTS; i ++)
            System.out.print(vertexList[i].label);
    }


    //just for test purpose
    public void displayVertexList()
    {
        printVertic();
    }


    //addVertex to Queue or Stack
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);

    }

    //furture maze printing with all wall attached
    public void print(char [][]array)
    {

        System.out.printf("\nThe populated array is: \n");

        for(int i=0;i<MAX_VERTS;i++)
        {
            System.out.println("0");

            for(int j=0;j<MAX_VERTS;j++)
            {
                System.out.printf("%c\t",adjMat[i][j]);
            }
        }
    }


    //just print maze
    public void displayMaze(){
        print(adjMat);
    }

    //connecting rooms of maze
    public void addEdge(int start, int end) {

        adjMat[start][end] = '#';
        adjMat[end][start] = '#';

    }

    // This will need modification with 123
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // Breath Fast search
    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            System.out.println();
            System.out.println("this in bfs: v1: " + v1);
            // until it has no unvisited neighbor
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        // queue is empty
        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;

    }// end bfs()

    // returns an unvisited vertex adj to v
    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;
        return -1;

    }

}
