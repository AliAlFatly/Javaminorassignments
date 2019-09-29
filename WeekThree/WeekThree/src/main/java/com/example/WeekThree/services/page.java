package com.example.WeekThree.services;

import java.util.ArrayList;

public class page<T> {
    private ArrayList<T> pageResources;
    private int size;
    private int page;

    public page(ArrayList<T> data, int size, int page){
        pageResources = data;
        this.size = size;
        this.page = page;
    }

    public int TotalPages(){
        return (int) Math.ceil((double) pageResources.size() / size);
    }

    public ArrayList<T> getContent(){
        if (pageResources.size() > 0){
            ArrayList<T> content = new ArrayList<>();
            for (int i = page*size-size; i < page*size; i++ ){
                if (i >= pageResources.size()){
                    return content;
                }
                content.add(pageResources.get(i));
            }
            return content;
        }
        return null;
    }



}
