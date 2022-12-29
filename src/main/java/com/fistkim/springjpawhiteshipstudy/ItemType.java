package com.fistkim.springjpawhiteshipstudy;

public enum ItemType {
    ALBUM;

    public static String getName(ItemType itemType){
        return itemType.name().toUpperCase();
    }
}
