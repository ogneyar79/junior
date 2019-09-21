package ru.job4j.parserjob;

import java.time.LocalDateTime;

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
     * link to Vacancy.
     */
    private String linkJob;

    /**
     * field of time vacancy publication.
     */
    private LocalDateTime dateTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLinkJob() {
        return linkJob;
    }

    public Vacancy(int id, String nameJob, String linkJob, LocalDateTime dateTime) {
        this.id = id;
        this.nameJob = nameJob;
        this.linkJob = linkJob;
        this.dateTime = dateTime;
    }

    public Vacancy() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (id != vacancy.id) return false;
        if (nameJob != null ? !nameJob.equals(vacancy.nameJob) : vacancy.nameJob != null) return false;
        if (linkJob != null ? !linkJob.equals(vacancy.linkJob) : vacancy.linkJob != null) return false;
        return dateTime != null ? dateTime.equals(vacancy.dateTime) : vacancy.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameJob != null ? nameJob.hashCode() : 0);
        result = 31 * result + (linkJob != null ? linkJob.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", nameJob='" + nameJob + '\'' +
                ", linkJob='" + linkJob + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
