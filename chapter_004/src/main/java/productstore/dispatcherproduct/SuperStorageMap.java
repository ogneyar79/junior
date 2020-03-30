package productstore.dispatcherproduct;

import productstore.controlqualityheker.*;
import productstore.superstorage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuperStorageMap {

    private Map<String, SuperStorage> superStorage;
    private ArrayList<String> commands;

    private ArrayList<IControllQuality> controllQualities = new ArrayList<>(6);


    public void initControlChekerDefault() {

        controllQualities.add(new ChekerWareHouse(this));
        controllQualities.add(new ChekerShopStock(this));
        controllQualities.add(new ChekerShopDiscount(this, 300));
        controllQualities.add(new ChekerTrashBinTime(this));
    }

    public ArrayList<IControllQuality> getControllQualities() {
        return controllQualities;
    }

    public SuperStorageMap() {
        this.superStorage = new HashMap<>();
        this.commands = new ArrayList<>();
    }

    public Map<String, SuperStorage> getSuperStorage() {
        return superStorage;
    }

    public SuperStorage getMapGet(String command) {
        return this.superStorage.get(command);
    }

    static final String FIRST_STORAGE = "0";
    static final String WARE_HOUSE = "1";
    static final String SHOP = "2";
    static final String TRASH = "3";

    public void init(String key, SuperStorage storageObject) {
        this.commands.add(key);
        this.superStorage.put(key, storageObject);
    }

    public void initDefault() {
        this.init(FIRST_STORAGE, new FirstStorage(FIRST_STORAGE));
        this.init(WARE_HOUSE, new Warehouse(WARE_HOUSE));
        this.init(SHOP, new Shop(SHOP));
        this.init(TRASH, new Trash(TRASH));
    }

    public ArrayList<String> getCommands() {
        return commands;
    }


}
