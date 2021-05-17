package sample.view;


import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.models.ConnectionModel;
import sample.models.DatumModel;
import sample.models.JSON_DATAModel;

import java.io.IOException;

public class Controller {
    @FXML
    private TableView<DatumModel> datumModelTableView;
    @FXML
    private TableColumn<DatumModel,String> datumIDCol;
    @FXML
    private TableColumn<DatumModel, String> datumSymbolCol;
    @FXML
    private TableColumn<DatumModel, String> datumNameCol;
    @FXML
    private TableColumn<DatumModel, String> datumNameIdCol;
    @FXML
    private TableColumn<DatumModel, Integer> datumRankCol;
    @FXML
    private TableColumn<DatumModel, String> datumPriceUSDCol;
    @FXML
    private TableColumn<DatumModel, String> datumPerCh24hCol;
    @FXML
    private TableColumn<DatumModel, String> datumPerCh1hCol;
    @FXML
    private TableColumn<DatumModel, String> datumPerCh7dCol;
    @FXML
    private TableColumn<DatumModel, String> datumPriceBTCCol;
    @FXML
    private TableColumn<DatumModel, String> datumMarketCapUSDCol;
    @FXML
    private TableColumn<DatumModel, Double> datumVolume24Col;
    @FXML
    private TableColumn<DatumModel, Double> datumVolume24aCol;
    @FXML
    private TableColumn<DatumModel, String> datumCsupplyCol;
    @FXML
    private TableColumn<DatumModel, String> datumTsupplyCol;
    @FXML
    private TableColumn<DatumModel, String> datumMsupplyCol;
    @FXML
    private TextField textField;

    private Main main;

    public Controller() {
    }

    @FXML
    private void initialize(){
        datumIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        datumSymbolCol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
        datumNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        datumNameIdCol.setCellValueFactory(new PropertyValueFactory<>("nameid"));
        datumRankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
        datumPriceUSDCol.setCellValueFactory(new PropertyValueFactory<>("priceUsd"));
        datumPerCh24hCol.setCellValueFactory(new PropertyValueFactory<>("percentChange24h"));
        datumPerCh1hCol.setCellValueFactory(new PropertyValueFactory<>("percentChange1h"));
        datumPerCh7dCol.setCellValueFactory(new PropertyValueFactory<>("percentChange7d"));
        datumPriceBTCCol.setCellValueFactory(new PropertyValueFactory<>("priceBtc"));
        datumMarketCapUSDCol.setCellValueFactory(new PropertyValueFactory<>("marketCapUsd"));
        datumVolume24Col.setCellValueFactory(new PropertyValueFactory<>("volume24"));
        datumVolume24aCol.setCellValueFactory(new PropertyValueFactory<>("volume24a"));
        datumCsupplyCol.setCellValueFactory(new PropertyValueFactory<>("csupply"));
        datumTsupplyCol.setCellValueFactory(new PropertyValueFactory<>("tsupply"));
        datumMsupplyCol.setCellValueFactory(new PropertyValueFactory<>("msupply"));
    }

    private ConnectionModel connectionModel = new ConnectionModel();
    private ObjectMapper mapper = new ObjectMapper();
    private String jsonData;
    public ObservableList<DatumModel> datumList = FXCollections.observableArrayList();

    public void load() throws IOException{
        connectionModel.setURL("https://api.coinlore.net/api/tickers/?start=200&limit=5");
        connectionModel.run();
        jsonData = connectionModel.getJsonIn();
        JSON_DATAModel theObject = mapper.readValue(jsonData, JSON_DATAModel.class);
        for(int i = 0; i < theObject.getData().size(); i++){
            datumList.add(theObject.getData().get(i));
        }
    }

    @FXML
    private void sortByRankDesc() throws IOException {
        datumList.clear();
        load();
        datumList.sort(DatumModel.byRankDesc);
        datumModelTableView.setItems(datumList);
    }

    @FXML
    private void sortByRankAsc() throws IOException {
        datumList.clear();
        load();
        datumList.sort(DatumModel.byRankAsc);
        datumModelTableView.setItems(datumList);
    }

    @FXML
    private void sortByPriceUSDDesc() throws IOException {
        datumList.clear();
        load();
        datumList.sort(DatumModel.byPriceUSDDesc);
        datumModelTableView.setItems(datumList);
    }

    @FXML
    private void sortByPriceUSDAsc() throws IOException {
        datumList.clear();
        load();
        datumList.sort(DatumModel.byPriceUSDAsc);
        datumModelTableView.setItems(datumList);
    }

    @FXML
    private void sortByPriceBTCDesc() throws IOException {
        datumList.clear();
        load();
        datumList.sort(DatumModel.byPriceBtcDesc);
        datumModelTableView.setItems(datumList);
    }

    @FXML
    private void sortByPriceBTCAsc() throws IOException {
        datumList.clear();
        load();
        datumList.sort(DatumModel.byPriceBtcAsc);
        datumModelTableView.setItems(datumList);
    }

    @FXML
    public void filter() throws IOException {

        FilteredList<DatumModel> filteredList = new FilteredList<>(datumList, p -> true);
        if (filteredList.isEmpty())
            load();

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(heroesModel -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (heroesModel.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<DatumModel> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(datumModelTableView.comparatorProperty());

        datumModelTableView.setItems(sortedList);

    }

    public void setMainApp(Main main) {
        this.main = main;

        datumModelTableView.setItems(main.getTheData());
    }
}


