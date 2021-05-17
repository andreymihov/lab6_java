package sample.models;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "info"
})
public class JSON_DATAModel implements Serializable {
    @JsonProperty("data")
    private List<DatumModel> data = null;
    @JsonProperty("info")
    private InfoModel info;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public List<DatumModel> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<DatumModel> data) {
        this.data = data;
    }

    @JsonProperty("info")
    public InfoModel getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(InfoModel info) {
        this.info = info;
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
        return "JSON_DATA{" +
                "data=" + data +
                ", info=" + info +
                ", additionalProperties=" + additionalProperties +
                '}' + "\n";
    }

    public DatumModel filterByName(String name){
        DatumModel datumModel = new DatumModel();
        for (int i = 0; i < data.size(); i++){
            if(data.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                return data.get(i);
            }
            datumModel = data.get(i);
        }
        return datumModel;
    }
}
