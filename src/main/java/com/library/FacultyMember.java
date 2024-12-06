package com.library;

import java.util.UUID;

class FacultyMember extends Member {
    public FacultyMember(UUID id, String name) {
        super(id, name);
    }

    @Override
    public int getMemberLimit() {
        return 5;
    }
}
