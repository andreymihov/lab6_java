package sample.models;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "symbol",
        "name",
        "nameid",
        "rank",
        "price_usd",
        "percent_change_24h",
        "percent_change_1h",
        "percent_change_7d",
        "price_btc",
        "market_cap_usd",
        "volume24",
        "volume24a",
        "csupply",
        "tsupply",
        "msupply"
})
public class DatumModel implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameid")
    private String nameid;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("price_usd")
    private String priceUsd;
    @JsonProperty("percent_change_24h")
    private String percentChange24h;
    @JsonProperty("percent_change_1h")
    private String percentChange1h;
    @JsonProperty("percent_change_7d")
    private String percentChange7d;
    @JsonProperty("price_btc")
    private String priceBtc;
    @JsonProperty("market_cap_usd")
    private String marketCapUsd;
    @JsonProperty("volume24")
    private double volume24;
    @JsonProperty("volume24a")
    private double volume24a;
    @JsonProperty("csupply")
    private String csupply;
    @JsonProperty("tsupply")
    private String tsupply;
    @JsonProperty("msupply")
    private String msupply;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DatumModel()  {
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameid")
    public String getNameid() {
        return nameid;
    }

    @JsonProperty("nameid")
    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    @JsonProperty("rank")
    public int getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(int rank) {
        this.rank = rank;
    }

    @JsonProperty("price_usd")
    public String getPriceUsd() {
        return priceUsd;
    }

    @JsonProperty("price_usd")
    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    @JsonProperty("percent_change_24h")
    public String getPercentChange24h() {
        return percentChange24h;
    }

    @JsonProperty("percent_change_24h")
    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    @JsonProperty("percent_change_1h")
    public String getPercentChange1h() {
        return percentChange1h;
    }

    @JsonProperty("percent_change_1h")
    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    @JsonProperty("percent_change_7d")
    public String getPercentChange7d() {
        return percentChange7d;
    }

    @JsonProperty("percent_change_7d")
    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    @JsonProperty("price_btc")
    public String getPriceBtc() {
        return priceBtc;
    }

    @JsonProperty("price_btc")
    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    @JsonProperty("market_cap_usd")
    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    @JsonProperty("market_cap_usd")
    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    @JsonProperty("volume24")
    public double getVolume24() {
        return volume24;
    }

    @JsonProperty("volume24")
    public void setVolume24(double volume24) {
        this.volume24 = volume24;
    }

    @JsonProperty("volume24a")
    public double getVolume24a() {
        return volume24a;
    }

    @JsonProperty("volume24a")
    public void setVolume24a(double volume24a) {
        this.volume24a = volume24a;
    }

    @JsonProperty("csupply")
    public String getCsupply() {
        return csupply;
    }

    @JsonProperty("csupply")
    public void setCsupply(String csupply) {
        this.csupply = csupply;
    }

    @JsonProperty("tsupply")
    public String getTsupply() {
        return tsupply;
    }

    @JsonProperty("tsupply")
    public void setTsupply(String tsupply) {
        this.tsupply = tsupply;
    }

    @JsonProperty("msupply")
    public String getMsupply() {
        return msupply;
    }

    @JsonProperty("msupply")
    public void setMsupply(String msupply) {
        this.msupply = msupply;
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
        return "Datum{" +
                "id='" + id + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", nameid='" + nameid + '\'' +
                ", rank=" + rank +
                ", priceUsd='" + priceUsd + '\'' +
                ", percentChange24h='" + percentChange24h + '\'' +
                ", percentChange1h='" + percentChange1h + '\'' +
                ", percentChange7d='" + percentChange7d + '\'' +
                ", priceBtc='" + priceBtc + '\'' +
                ", marketCapUsd='" + marketCapUsd + '\'' +
                ", volume24=" + volume24 +
                ", volume24a=" + volume24a +
                ", csupply='" + csupply + '\'' +
                ", tsupply='" + tsupply + '\'' +
                ", msupply='" + msupply + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}' + "\n";
    }

    public static Comparator<DatumModel> byRankDesc = (o1, o2) -> Integer.compare(o1.getRank(), o2.getRank());
    public static Comparator<DatumModel> byRankAsc = (o2, o1) -> Integer.compare(o1.getRank(), o2.getRank());
    public static Comparator<DatumModel> byPriceUSDDesc = Comparator.comparing(o -> o.getPriceUsd());
    public static Comparator<DatumModel> byPriceUSDAsc = (o1, o2) -> o2.getPriceUsd().compareTo(o1.getPriceUsd());
    public static Comparator<DatumModel> byPriceBtcDesc = Comparator.comparing(o -> o.getPriceBtc());
    public static Comparator<DatumModel> byPriceBtcAsc = (o1, o2) -> o2.getPriceUsd().compareTo(o1.getPriceBtc());
}
