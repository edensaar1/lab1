import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private ArrayList<User> users = UsersApp.loadUsers();

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean valid = UsersApp.validateLogin(username, password, users);

        if (valid) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/welcome.fxml"));
                Scene welcomeScene = new Scene(loader.load());

                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(welcomeScene);
                stage.setTitle("Welcome");
            } catch (Exception e) {
                errorLabel.setText("Error loading welcome screen");
            }
        } else {
            errorLabel.setText("Invalid username or password");
        }
    }
}
