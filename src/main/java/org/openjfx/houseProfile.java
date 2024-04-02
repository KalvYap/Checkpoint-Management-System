package org.openjfx;

import java.util.*;

public class houseProfile {

    private String houseNum;

    HashMap<String, LinkedList<String>> adjList = new HashMap<>();


    public String getName()
    {
        return houseNum;
    }

    public houseProfile(String housenum) {
        this.houseNum=housenum;
    }

    public void writeVisitor(String visitor){
        LinkedList<String> nodes = adjList.get(houseNum);
        nodes.add(visitor);
        adjList.put(houseNum,nodes);


    }

    public LinkedList<String> getVisitors(){
        return adjList.get(this.houseNum);
    }
    void addNode(String houseNum){
        adjList.put(houseNum, new LinkedList<>());
    }

    int dfs(String searchedName){
        Queue<String> visited = new LinkedList<>();
        Stack<String> s = new Stack<>();
        int countIndex=0;
        s.push(houseNum);


        //for each loop
        for(Map.Entry m: adjList.entrySet()){
            String x = s.peek();
            s.pop();
            visited.add(x);

            for(String i: adjList.get(x)){
                if(visited.contains(i)||s.contains(i)){
                    countIndex++;
                }else if (i.compareTo(searchedName)==0){
                    return countIndex;

                }
                else{
                    s.push(i);
                    countIndex++;

                }
            }
        }
        return -1;
    }





}
