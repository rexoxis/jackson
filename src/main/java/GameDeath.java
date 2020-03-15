import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDeath {
    @JsonProperty("time_event")
    private int timeEvent;

    @JsonProperty("is_range_valid")
    private boolean isRangeValid;

    @JsonProperty("description")
    private String description;


    public GameDeath() {
    }

    public GameDeath(int timeEvent, boolean isRangeValid, String description) {
        this.timeEvent = timeEvent;
        this.isRangeValid = isRangeValid;
        this.description = description;
    }

    public int getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(int timeEvent) {
        this.timeEvent = timeEvent;
    }

    public boolean isRangeValid() {
        return isRangeValid;
    }

    public void setRangeValid(boolean rangeValid) {
        isRangeValid = rangeValid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
