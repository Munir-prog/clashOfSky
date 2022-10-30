package com.mprog.service.clan;

import com.mprog.database.model.Clan;

public class ClanServiceImpl implements ClanService {

    private final static ClanServiceImpl instance = new ClanServiceImpl();

    private final Clan clan;

    private ClanServiceImpl() {
        clan = new Clan(1, "Russia", 0);
    }

    @Override
    public Clan getClan(long clanId) {
        return clan;
    }

    public static ClanServiceImpl getInstance() {
        return instance;
    }
}
