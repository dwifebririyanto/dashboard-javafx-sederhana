package com.aplikasi.sederhana.projectuas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class anggotaController implements Initializable {
    @FXML
    private TableColumn<DataAnggota, String> colhp;

    @FXML
    private TableColumn<DataAnggota, String> coljk;

    @FXML
    private TableColumn<DataAnggota, String> colnama;

    @FXML
    private TableColumn<DataAnggota, Integer> colnim;

    @FXML
    private TableColumn<DataAnggota, String> colprodi;

    @FXML
    private Button edit_btn;

    @FXML
    private Button hapus_btn;

    @FXML
    private TextField hptxt;

    @FXML
    private TextField jktxt;

    @FXML
    private TextField namatxt;

    @FXML
    private TextField nimtxt;

    @FXML
    private TextField proditxt;

    @FXML
    private Button tambah_btn;
    @FXML
    private TableView table;

    @FXML
    private Button clear;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();

    }

    public ObservableList<DataAnggota> getDataAnggotaList(){
        ObservableList<DataAnggota> DataAnggotaList = FXCollections.observableArrayList();
        Connection conn = koneksiDb.getConnection();
        String query = "SELECT * FROM data_anggota";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            DataAnggota dataAnggota;
            while (rs.next()){
                dataAnggota = new DataAnggota(rs.getInt("nimAnggota"), rs.getString("namaAnggota"), rs.getString("jkAnggota"), rs.getString("hpAnggota"), rs.getString("prodiAnggota"));
                DataAnggotaList.add(dataAnggota);
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        return DataAnggotaList;
    }

    private void loadData() {

        ObservableList<DataAnggota> list = getDataAnggotaList();

        colnim.setCellValueFactory(new PropertyValueFactory<DataAnggota, Integer>("nimAnggota"));
        colnama.setCellValueFactory(new PropertyValueFactory<DataAnggota, String >("namaAnggota"));
        coljk.setCellValueFactory(new PropertyValueFactory<DataAnggota, String >("jkAnggota"));
        colhp.setCellValueFactory(new PropertyValueFactory<DataAnggota, String>("hpAnggota"));
        colprodi.setCellValueFactory(new PropertyValueFactory<DataAnggota, String>("prodiAnggota"));

        table.setItems(list);
    }

    public void editdata(){
        String query = "UPDATE data_anggota SET namaAnggota = '" + namatxt.getText() +"', jkAnggota = '" + jktxt.getText() +"', hpAnggota = '" +hptxt.getText() +"', prodiAnggota ='"+ proditxt.getText() + "'WHERE nimAnggota = "+ nimtxt.getText()+"";
        executeQuery(query);
        loadData();
        cleartext();
    }
    public void tambahdata(){
        String query = "INSERT INTO data_anggota VALUES (" + nimtxt.getText() + ",'" + namatxt.getText() +"', '" + jktxt.getText() +"','" +hptxt.getText() +"','"+ proditxt.getText() + "')";
        executeQuery(query);
        loadData();
        cleartext();
    }
    public void cleartext(){
        nimtxt.setText(null);
        namatxt.setText(null);
        jktxt.setText(null);
        hptxt.setText(null);
        proditxt.setText(null);
    }

    public void hapusdata(){
        String query = "DELETE FROM data_anggota WHERE nimAnggota = " + nimtxt.getText() +"";
        executeQuery(query);
        loadData();
        cleartext();
    }

    private void executeQuery(String query) {
        Connection conn = koneksiDb.getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
