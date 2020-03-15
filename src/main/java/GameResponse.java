import com.fasterxml.jackson.annotation.JsonProperty;

public class GameResponse {
    @JsonProperty("code")
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
