package com.library;

import java.util.UUID;

class StudentMember extends Member {
    public StudentMember(UUID id, String name) {
        super(id, name);
    }

    @Override
    public int getMemberLimit() {
        return 3;
    }
}
