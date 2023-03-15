package com.company;

public class Toys {
    int id;
    String name;
    int toyDrop;

    Toys(int id, String name, int toyDrop) {

        this.id = id;
        this.name = name;
        this.toyDrop = toyDrop;
    }

   public void setDrop(int toyDrop){
        this.toyDrop = toyDrop;
    }
}
