package DataStructures;

import User.Buddy;

import java.util.*;

public abstract class BuddyLand { //will implement a Graph structure with buddy as a vertex
    private static Map<Buddy, TreeSet<Buddy>> connections = new HashMap<>(); //stores every vertex of the graph and its edges

    public static Map<Buddy, TreeSet<Buddy>> getConnections(){
        return connections;
    }

    public static void addBuddy(Buddy buddy){ //adds a vertex to the adjacencyList
        connections.putIfAbsent(buddy, new TreeSet<>(Buddy::compareTo));
    }
    public static void addConnection(Buddy buddy1, Buddy buddy2){ //adds an undirected edge between two vertices(buddies)
        if(!buddy1.equals(buddy2)) {
            if(connections.containsKey(buddy1) && connections.containsKey(buddy2)) {
                connections.get(buddy1).add(buddy2);
                connections.get(buddy2).add(buddy1);
            }
        }
        }


    public static void removeConnection(Buddy buddy1, Buddy buddy2){ //removes the undirected edge between the two vertices(buddies)
        if(connections.containsKey(buddy1)) connections.get(buddy1).remove(buddy2);
        if(connections.containsKey(buddy2)) connections.get(buddy2).remove(buddy1);
    }
    public static List<Buddy> getBuddyMatchesByName(Buddy buddy, String name){
        /*
        The buddy argument is the buddy whose connections we are searching,
        the method checks if the name provided matches with any of the adjacent
        vertices  first or last name and adds them to
        a list(There may be multiple people with the same first or last name).
         */

        TreeSet<Buddy> buddyConnections = connections.get(buddy);
        List<Buddy> nameMatches = new ArrayList<>();
        for(Buddy b : buddyConnections){
            if(name.equals(b.getFirstName()) || name.equals(b.getLastName())) nameMatches.add(b);
        }
        return nameMatches;
    }
    public static int getBuddiesNumber(Buddy buddy){ //returns the number of edges(connections) of a particular vertex(buddy)
        return connections.get(buddy).size();
    }
}

