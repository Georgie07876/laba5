package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ch.makery.address.MainApp;
import ch.makery.address.model.Club;

public class ClubOverviewController {
    @FXML
    private TableView<Club> ClubTable;
    @FXML
    private TableColumn<Club, String> SchoolColumn;
    @FXML
    private TableColumn<Club, String> clubColumn;
    @FXML
    private TableColumn<Club, String> directorColumn;
    @FXML
    private TableColumn<Club, Number> phonenumberColumn;

    @FXML
    private Label SchoolLabel;
    @FXML
    private Label clubLabel;
    @FXML
    private Label directorLabel;
    @FXML
    private Label phonenumberLabel;
    @FXML
    private Label adressLabel;
    @FXML
    private Label clubactivityLabel;
    @FXML
    private Label childnumberLabel;
    @FXML
    private Label costlabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ClubOverviewController() {
    }

    private void showClubDetails(Club club) {
        if (club != null) {
            // Заполняем метки информацией из объекта person.
            SchoolLabel.setText(club.getSchool());
            clubLabel.setText(club.getclub());
            directorLabel.setText(club.getdirector());
            phonenumberLabel.setText(Integer.toString(club.getphoneunmber()));
            adressLabel.setText(club.getadress());
            clubactivityLabel.setText(club.getclubactivity());
            childnumberLabel.setText(Integer.toString(club.getchildnumber()));
            costlabel.setText(Integer.toString(club.getcost()));

            // TODO: Нам нужен способ для перевода дня рождения в тип String!
            // birthdayLabel.setText(...);
        } else {
            // Если Person = null, то убираем весь текст.
            SchoolLabel.setText("");
            clubLabel.setText("");
            directorLabel.setText("");
            phonenumberLabel.setText("");
            adressLabel.setText("");
            clubactivityLabel.setText("");
            childnumberLabel.setText("");
            costlabel.setText("");
        }
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the Club table with the two columns.
        SchoolColumn.setCellValueFactory(cellData -> cellData.getValue().SchoolProperty());
        clubColumn.setCellValueFactory(cellData -> cellData.getValue().clubProperty());
        directorColumn.setCellValueFactory(cellData -> cellData.getValue().directorProperty());
        phonenumberColumn.setCellValueFactory(cellData -> cellData.getValue().phonenumberProperty());


        showClubDetails(null);

        ClubTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClubDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        ClubTable.setItems(mainApp.getClubData());
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке удаления.
     */
    @FXML
    private void handleDeleteClub() {
        int selectedIndex = ClubTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ClubTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке New...
     * Открывает диалоговое окно с дополнительной информацией нового адресата.
     */
    @FXML
    private void handleNewClub() {
        Club tempClub = new Club();
        boolean okClicked = mainApp.showClubEditDialog(tempClub);
        if (okClicked) {
            mainApp.getClubData().add(tempClub);
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопка Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */
    @FXML
    private void handleEditClub() {
        Club selectedClub = ClubTable.getSelectionModel().getSelectedItem();
        if (selectedClub != null) {
            boolean okClicked = mainApp.showClubEditDialog(selectedClub);
            if (okClicked) {
                showClubDetails(selectedClub);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}