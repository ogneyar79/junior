package menu;

import java.util.ArrayList;
import java.util.List;


public class SimpleMenu implements IMenu, IViewMenu, ITouchMenu {

    /**
     * field name of element menu.
     */
    private final String name;

    /**
     * String menu.
     */
    private final String fullString;

    /**
     * action that we going to make after pushing element of menu.
     */
    private final ActionMenu actionMenu;

    /**
     * list of keeping different elements of menu.
     */
    List<SimpleMenu> listMenu = new ArrayList<>();

    /**
     * default constructor.
     *
     * @param name
     * @param fullString
     * @param actionMenu
     */
    public SimpleMenu(String name, String fullString, ActionMenu actionMenu) {
        this.name = name;
        this.fullString = fullString;
        this.actionMenu = actionMenu;
    }

    /**
     * Procedure adding new Element to Menu.
     *
     * @param point IMenu.
     */
    @Override
    public void addChild(IMenu point) {
        this.listMenu.add((SimpleMenu) point);
    }


    /**
     * Procedure show view menu that user see.
     */
    @Override
    public void showPoint() {
        System.out.println(this.fullString);
    }

    /**
     * Function that realize that happened after simple pushing of button and transfer management of Menu.
     *
     * @param touch
     * @return
     */
    @Override
    public IMenu pushPoint(boolean touch) {
        if (touch) {
            for (IMenu child : this.listMenu) {
                child.showPoint();
            }
        }
        return this;
    }

    /**
     * Function that realize selection of element menu and transfer management of Menu.
     *
     * @param name
     * @return
     */
    @Override
    public IMenu selectPoint(String name) {
        IViewMenu point = this;
        for (SimpleMenu child : this.listMenu) {
            if (child.name.equals(name)) {
                point = child;
                point.showPoint();
            }
        }
        return (IMenu) point;
    }


    public String getName() {
        return name;
    }

    public List<SimpleMenu> getListMenu() {
        return listMenu;
    }

}
