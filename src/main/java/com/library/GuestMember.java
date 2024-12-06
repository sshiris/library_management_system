package com.library;

import java.util.UUID;

class GuestMember extends Member {
    public GuestMember(UUID id, String name) {
        super(id, name);
    }

    @Override
    public int getMemberLimit() {
        return 1;
    }
}
