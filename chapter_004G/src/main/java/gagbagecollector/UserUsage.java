package gagbagecollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserUsage {

    private static final Logger log = LoggerFactory.getLogger(UserUsage.class);

    public static class UserG {
        final int id;

        public UserG(int id) {
            this.id = id;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.err.println(System.err.format("destroy object user id" + this.toString()));
            System.err.println(" FINALIZE");
        }

        @Override
        public String toString() {
            return "UserG{" +
                    "id=" + id +
                    '}';
        }
    }

    public static void main(String[] args) {
        info();
        UserG userG = new UserG(11);
        UserG userGone = new UserG(11);
        CreateObjectThenNull();
      info();
    }

    public static void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.err.println(" Heap inizialisation on [ MB]");

        System.err.println(" Used MEMORY" + " " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.err.println("Free MEMORY" + " " + runtime.freeMemory() / mb);
        System.err.println("TOTAL MEMORY" + " " + runtime.totalMemory() / mb);
        System.err.println(" MAX MEMORY " + " " + runtime.maxMemory() / mb);
    }

    public static void CreateObjectThenNull() {
        for (int i = 0; i < 1000000; i++) {
            UserG userG = new UserG(i);
          info();
            System.err.println(" USER.ID " + "" + userG.id);
        }
    }
}
