package ru.job4j.tracker;


abstract class BaseAction implements IUserAktion {


    public BaseAction(String name, int key) {

    }

    abstract void start();

    public class CopyBaseAction extends BaseAction {
        String name;
        int key;

        public CopyBaseAction(String name, int key) {
            super(name, key);
        }

        public String info() {
            return String.format("%s. %s", this.key(), " ");
        }

        public void start() {

        }

        public void execute(IInput input, Tracker tracker) {

        }

        public int key() {
            return key;
        }

    }

    public static void main(String[] args) {

        BaseAction b = new BaseAction("7", 7) {
            @Override
            public String info() {

                return String.format("%s. %s", this.key(), " ");

            }

            @Override
            void start() {

            }

            @Override
            public int key() {
                return 0;
            }

            @Override
            public void execute(IInput input, Tracker tracker) {

            }
        };
        b.info();

    }

}