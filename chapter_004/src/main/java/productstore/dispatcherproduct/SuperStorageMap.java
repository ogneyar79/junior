package productstore.dispatcherproduct;

import productstore.controlqualityheker.*;
import productstore.superstorage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuperStorageMap {

    Map<String, SuperStorage> superStorage;
    ArrayList<String> commands;

    ArrayList<IControllQuality> controllQualities = new ArrayList<>(6);


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

    static final String firstStorage = "0";
    static final String wareHouse = "1";
    static final String shop = "2";
    static final String trash = "3";

    public void init(String key, SuperStorage storageObject) {
        this.commands.add(key);
        this.superStorage.put(key, storageObject);
    }

    public void initDefault() {
        this.init(firstStorage, new FirstStorage(firstStorage));
        this.init(wareHouse, new Warehouse(wareHouse));
        this.init(shop, new Shop(shop));
        this.init(trash, new Trash(trash));
    }

    public ArrayList<String> getCommands() {
        return commands;
    }


}
