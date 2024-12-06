package com.library;

interface MemberInterface {
    String getId();

    String getInfo();

    void borrowItem(LibraryItem libraryItem);

    void returnItem(LibraryItem libraryItem);
}
