package com.library;

import java.util.UUID;

interface MemberInterface {
    UUID getId();

    String getInfo();

    boolean borrowItem(LibraryItem libraryItem);

    void returnItem(LibraryItem libraryItem);
}
