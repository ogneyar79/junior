package ru.job4j.parserjob;

public class Vacancy {

    /**
     * Id Number Vacancy.
     */
    private int id;

    /**
     * Name of Vacancy.
     */
    private String nameJob;


    /**
     * Esqribition of Vacancy.
     */
    private String EsqribishenJob;


    /**
     * link to Vacancy.
     */
    private String linkJob;

    public void setId(int id) {
        this.id = id;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public void setEsqribishenJob(String esqribishenJob) {
        EsqribishenJob = esqribishenJob;
    }

    public void setLinkJob(String linkJob) {
        this.linkJob = linkJob;
    }


    public int getId() {
        return id;
    }

    public String getNameJob() {
        return nameJob;
    }

    public String getEsqribishenJob() {
        return EsqribishenJob;
    }

    public String getLinkJob() {
        return linkJob;
    }
}
