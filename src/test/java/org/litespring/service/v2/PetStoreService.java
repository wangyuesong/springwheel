package org.litespring.service.v2;

import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;

public class PetStoreService {
    private AccountDao accountDao;
    private ItemDao itemDao;
    private String petstoreName;
    private int version;

    public Object getAccountDao() {
        return this.accountDao;
    }

    public Object getItemDao() {
        return this.itemDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public String getPetstoreName() {
        return petstoreName;
    }

    public void setPetstoreName(String petstoreName) {
        this.petstoreName = petstoreName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
