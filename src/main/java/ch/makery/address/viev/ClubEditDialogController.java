package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Club;

/**
 * Окно для изменения информации об адресате.
 *
 * @author Marco Jakob
 */
public class ClubEditDialogController {

    @FXML
    private TextField clubfield;
    @FXML
    private TextField clubactivityfield;
    @FXML
    private TextField childnumberfield;
    @FXML
    private TextField costfield;
    @FXML
    private TextField schoolfield;
    @FXML
    private TextField directorfield;
    @FXML
    private TextField adressfield;
    @FXML
    private TextField phoneunmberfield;


    private Stage dialogStage;
    private Club clubb;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param clubb
     */
    public void setClub(Club clubb) {
        this.clubb = clubb;

        clubfield.setText(clubb.getclub());
        clubactivityfield.setText(clubb.getclubactivity());
        childnumberfield.setText(Integer.toString(clubb.getchildnumber()));
        costfield.setText(Integer.toString(clubb.getcost()));
        schoolfield.setText(clubb.getSchool());
        directorfield.setText(clubb.getdirector());
        adressfield.setText(clubb.getadress());
        phoneunmberfield.setText(Integer.toString(clubb.getphoneunmber()));
    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            clubb.setclub(clubfield.getText());
            clubb.setclubactivity(clubactivityfield.getText());
            clubb.setchildnumber(Integer.parseInt(childnumberfield.getText()));
            clubb.setcost(Integer.parseInt(costfield.getText()));
            clubb.setSchool(schoolfield.getText());
            clubb.setdirector(directorfield.getText());
            clubb.setadress(adressfield.getText());
            clubb.setphonenumber(Integer.parseInt(phoneunmberfield.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (clubfield.getText() == null || clubfield.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (clubactivityfield.getText() == null || clubactivityfield.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (childnumberfield.getText() == null || childnumberfield.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(childnumberfield.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (costfield.getText() == null || costfield.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(costfield.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (schoolfield.getText() == null || schoolfield.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (directorfield.getText() == null || directorfield.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (adressfield.getText() == null || adressfield.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (phoneunmberfield.getText() == null || phoneunmberfield.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(phoneunmberfield.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}