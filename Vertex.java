package sjsu.NguyenSwe.cs146.project3.graphMaze;

/**
 * Created by Philip on 11/30/2016.
 */
/******* Vertex Class *******/

public class Vertex{
    public boolean wasVisited;
    public char label;

    public Vertex(char l){
        label = l;
        wasVisited = false;
    }
}//end vertex class

