package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

class EditItemIuAct implements IUserAktion {

    public int key() {
        return 2;
    }

    @Override
    public void execute(IInput input, Tracker tracker) {

        String id = input.ask("Please enter the item id.");
        String name = input.ask("Please enter the item name");
        String description = input.ask("Please enter the item description");
        Long create = 123L;
        Item item = new Item(name, description, create);
        item.setId(id);
        tracker.update(item);

    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the Item.");
    }
}

public class MenuTracker {

    private IInput input;

    private Tracker tracker;

    private List<IUserAktion> aktions = new ArrayList<>(6);

    public List<IUserAktion> getAktions() {
        return aktions;
    }

    public MenuTracker(IInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

    }

    public void fillActionInit() {

        this.aktions.add(new AddItemIuAct());
        this.aktions.add(new ShowItemsIuAct());
        this.aktions.add(new EditItemIuAct());
        this.aktions.add(new DeleteItemIuAct());
        this.aktions.add(new FindItemByIdIuAct());
        this.aktions.add(new FindItemsByNameIuAct());
        this.aktions.add(new ExitIuAct());

    }

    public void select(int key) {
        this.aktions.get(key).execute(input, tracker);
    }

    public void show() {
        for (int i = 0; i < aktions.size(); i++) {
            if (aktions.get(i) != null) {
                System.out.println(this.aktions.get(i).info());
            }
        }
    }

    private class AddItemIuAct implements IUserAktion {
        public int key() {
            return 0;
        }

        @Override
        public void execute(IInput input, Tracker tracker) {
            String name = input.ask("Please enter the name:");
            String description = input.ask("Please enter the Description:");
            Long create = 123L;
            tracker.add(new Item(name, description, create));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Item.");
        }
    }

    private static class ShowItemsIuAct implements IUserAktion {

        public int key() {
            return 1;
        }

        public void execute(IInput input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getName(), item.getId()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }

    }

    private class DeleteItemIuAct implements IUserAktion {
        public int key() {
            return 3;
        }

        public void execute(IInput input, Tracker tracker) {
            String id = input.ask("Please enter the item id.");
            Item item = new Item();
            item.setId(id);
            tracker.delete(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    private class FindItemByIdIuAct implements IUserAktion {
        public int key() {
            return 4;
        }

        public void execute(IInput input, Tracker tracker) {
            String id = input.ask("Please enter the item id.");
            tracker.findById(id);
            System.out.println(String.format("%s. %s. %s", tracker.findById(id).getName(), tracker.findById(id).getDescription(), tracker.findById(id).getCreator()));

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item via id.");

        }
    }

    private class FindItemsByNameIuAct implements IUserAktion {
        public int key() {
            return 5;
        }

        public void execute(IInput input, Tracker tracker) {
            String name = input.ask("Please enter The Item's name.");
            tracker.findByName(name);
            List<Item> result = tracker.findByName(name);
            for (Item resalt : result) {
                System.out.println(String.format("%s. %s. %s. %s", resalt.getId(), resalt.getName(), resalt.getDescription(), resalt.getCreator()));

            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item via name.");

        }
    }

    private class ExitIuAct implements IUserAktion {
        public int key() {
            return 6;
        }

        public void execute(IInput input, Tracker tracker) {

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit.");
        }
    }
}





