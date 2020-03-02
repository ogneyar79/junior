package menu;


/**
 * interface for realisation after pushing elements of menu.
 */
public interface ITouchMenu {

    /**
     * function that realize that happened after simple pushing of button and transfer management of Menu.
     *
     * @param touch
     * @return
     */
    IMenu pushPoint(boolean touch);

    /**
     * Function that realize selection of element menu and transfer management of Menu.
     *
     * @param name
     * @return
     */
    IViewMenu selectPoint(String name);
}
