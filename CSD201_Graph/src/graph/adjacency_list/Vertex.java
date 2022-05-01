/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.adjacency_list;

import java.util.TreeSet;

/**
 *
 * @author dangp
 */
public class Vertex implements Comparable{
    String name;
    TreeSet<Edge> adjList;
    int num = 0;
    
    public Vertex(){
        name = null;
        adjList = new TreeSet<>();
    }
    
    public Vertex(String n){
        name = n;
        adjList = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(TreeSet<Edge> adjList) {
        this.adjList = adjList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    @Override
    public int compareTo(Object o){
        return name.compareTo(((Vertex)o).name);
    }
    
    @Override
    public String toString(){
        return name;
    }
}
