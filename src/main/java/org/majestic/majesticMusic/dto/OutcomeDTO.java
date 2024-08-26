package org.majestic.majesticMusic.dto;

public class OutcomeDTO {
    private boolean outcome;
    private String description;

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
