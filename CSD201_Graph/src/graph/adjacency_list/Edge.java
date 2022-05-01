/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.adjacency_list;

/**
 *
 * @author dangp
 */
public class Edge implements Comparable{
    Vertex u;
    Vertex v;
    double weight;
    public Edge(Vertex u, Vertex v){
        this.u = u;
        this.v = v;
        weight = 1;
    }

    public Edge(Vertex u, Vertex v, double w) {
        this.u = u;
        this.v = v;
        this.weight = w;
    }

    public Vertex getU() {
        return u;
    }

    public void setU(Vertex u) {
        this.u = u;
    }

    public Vertex getV() {
        return v;
    }

    public void setV(Vertex v) {
        this.v = v;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Object o){
        Edge e = ((Edge)o);
        return (u.name + v.name).compareTo(e.u.name + e.v.name);
    }
    
    @Override
    public String toString(){
        return "{" + u.name + ", " + v.name + ", " + weight + "}";
    }
}
