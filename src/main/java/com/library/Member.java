package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

abstract class Member implements MemberInterface {
    private UUID id;
    private String name;
    private List<LibraryItem> borrowedItems;

    public Member(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getInfo() {
        return "ID: " + id + ". Name: " + name;
    }

    @Override
    public void returnItem(LibraryItem libraryItem) {
        if (borrowedItems.size() > 0) {
            borrowedItems.remove(libraryItem);
        } else {
            System.out.println("You don't have any borrowed items");
        }
    }

    @Override
    public boolean borrowItem(LibraryItem libraryItem) {
        if (libraryItem.isAvailable() && borrowedItems.size() < getMemberLimit()) {
            borrowedItems.add(libraryItem);
            libraryItem.borrowItem();
            return true;
        }
        return false;
    }

    abstract int getMemberLimit();
}
