package sample.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coins_num",
        "time"
})

public class InfoModel {

    @JsonProperty("coins_num")
    private int coinsNum;
    @JsonProperty("time")
    private int time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coins_num")
    public int getCoinsNum() {
        return coinsNum;
    }

    @JsonProperty("coins_num")
    public void setCoinsNum(int coinsNum) {
        this.coinsNum = coinsNum;
    }

    @JsonProperty("time")
    public int getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(int time) {
        this.time = time;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Info{" +
                "coinsNum=" + coinsNum +
                ", time=" + time +
                ", additionalProperties=" + additionalProperties +
                '}' + "\n";
    }
}
