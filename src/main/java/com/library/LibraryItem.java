package com.library;

import java.time.LocalDate;

abstract class LibraryItem {
    private int id;
    protected boolean availability;
    protected LocalDate dueToDate;

    public LibraryItem(int id) {
        this.id = id;
        this.availability = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return availability;
    }

    public abstract void borrowItem();

    public void returnItem() {
        availability = true;
        dueToDate = null;
        System.out.println("Item widh ID: " + id + " has been returned and now it is available!");
    }

}
