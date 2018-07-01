package org.litespring.service.v2;

import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;

public class PetStoreService {
    AccountDao accountDao;
    ItemDao itemDao;

    public Object getAccountDao() {
        return this.accountDao;
    }

    public Object getItemDao() {
        return this.itemDao;
    }
}
