package ru.job4j.profession;

/**
 * Класс Project (project for engineer).
 *
 * @author Sirotkin.
 */
public class Project {

    /**
     * projectName value of field for class Project (The name that project by engineer make).
     */
    private String projectName;

    /**
     * method for getting arguments.
     */
    public String getProjectName() {
        return this.projectName;
    }


    public Project(String projectName) {

        this.projectName = projectName;
    }

    Project bridge = new Project("bridge");
}
