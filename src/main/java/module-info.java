module com.example.addressapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens ch.makery.address.view to javafx.fxml;

    exports ch.makery.address;
}
