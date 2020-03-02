package menu;


/**
 * Interface of adding new Element to Menu.
 */
public interface IMenu extends IViewMenu {

    /**
     * Procedure adding new Element to Menu.
     *
     * @param point IMenu.
     */
    void addChild(IMenu point);

}
