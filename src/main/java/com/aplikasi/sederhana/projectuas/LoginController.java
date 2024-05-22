package com.aplikasi.sederhana.projectuas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usernametxt;
    @FXML
    private PasswordField passwordtxt;
    @FXML
    private Button login_btn;
    @FXML
    private Button cancel_btn;


    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancel_btn.getScene().getWindow();
        stage.close();
    }
    public void loginButtonOnAction(ActionEvent event) throws IOException {
        App lb = new App();
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = koneksiDb.getConnection();
        try {
            st = con.prepareStatement("SELECT * FROM login WHERE username =? AND password = ?");
            st.setString(1,usernametxt.getText());
            st.setString(2,passwordtxt.getText());
            rs = st.executeQuery();
            if (rs.next()){
                login_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                Scene scene = new Scene(root,700,550);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "GAGAL LOGIN",ButtonType.OK);
                alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}