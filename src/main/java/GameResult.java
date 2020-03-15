import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameResult {
    @JsonProperty("response")
    private GameResponse response;

    @JsonProperty("map_id")
    private String mapid;

    @JsonProperty("deaths")
    private List<GameDeath> deathList;

    public GameResult() {
    }

    public GameResponse getResponse() {
        return response;
    }

    public void setResponse(GameResponse response) {
        this.response = response;
    }

    public String getMapid() {
        return mapid;
    }

    public void setMapid(String mapid) {
        this.mapid = mapid;
    }

    public List<GameDeath> getDeathList() {
        return deathList;
    }

    public void setDeathList(List<GameDeath> deathList) {
        this.deathList = deathList;
    }
}
