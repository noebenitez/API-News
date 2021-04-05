package com.utn.APINoticias.model;

public enum TypeNews {

    IMAGE("Image"),
    TEXT("Only text"),
    VIDEO("Video");

    private String description;

    TypeNews(String description){
        this.description = description;
    }

    public static TypeNews find(final String value){
        for(TypeNews n : values()){
            if (n.toString().equalsIgnoreCase(value))
                return n;
        }
        throw new IllegalArgumentException(String.format("Invalid TypeNews: %s", value));
    }

    public String getDescription() {
        return description;
    }
}
