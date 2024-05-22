package com.aplikasi.sederhana.projectuas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Filter;

public class editBukuController implements Initializable {
    @FXML
    private TableColumn<DataBuku, String> colgenre;

    @FXML
    private TableColumn<DataBuku, Integer> colid;

    @FXML
    private TableColumn<DataBuku, String> coljudul;

    @FXML
    private TableColumn<DataBuku, String> colpenulis;

    @FXML
    private TableColumn<DataBuku, String> coltahun;
    @FXML
    private TableView table;

    @FXML
    private Button edit_btn;

    @FXML
    private TextField genretxt;

    @FXML
    private Button hapus_btn;

    @FXML
    private TextField idtxt;

    @FXML
    private TextField judultxt;

    @FXML
    private TextField penulistxt;

    @FXML
    private TextField tahuntxt;

    @FXML
    private Button tambah_btn;

    @FXML
    private Button clear_btn;



    @FXML
    private void tombolButtonOnAction(ActionEvent event) {
        if(event.getSource() == tambah_btn){
            tambahdata();
        } else if (event.getSource() == edit_btn) {
            editdata();
        } else if(event.getSource() == hapus_btn) {
            hapusdata();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
    public ObservableList<DataBuku> getDataBukuList(){
        ObservableList<DataBuku> DataBukuList = FXCollections.observableArrayList();
       // ObservableList<DataBuku> DataBukuList = fetchDataFromDatabase();
        Connection conn = koneksiDb.getConnection();
        String query = "SELECT * FROM data_buku ORDER BY judulBuku";

        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            DataBuku dataBuku;
            while (rs.next()){
                dataBuku = new DataBuku(rs.getInt("idBuku"), rs.getString("judulBuku"), rs.getString("genreBuku"), rs.getString("penulisBuku"), rs.getString("tahunBuku"));
                DataBukuList.add(dataBuku);
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        return DataBukuList;
    }

    private void loadData() {

        ObservableList<DataBuku> list = getDataBukuList();

        colid.setCellValueFactory(new PropertyValueFactory<DataBuku, Integer>("idBuku"));
        coljudul.setCellValueFactory(new PropertyValueFactory<DataBuku, String >("JudulBuku"));
        colgenre.setCellValueFactory(new PropertyValueFactory<DataBuku, String >("GenreBuku"));
        colpenulis.setCellValueFactory(new PropertyValueFactory<DataBuku, String>("PenulisBuku"));
        coltahun.setCellValueFactory(new PropertyValueFactory<DataBuku, String>("TahunBuku"));

        table.setItems(list);
    }

    public void cleartext(){
        idtxt.setText(null);
        judultxt.setText(null);
        genretxt.setText(null);
        penulistxt.setText(null);
        tahuntxt.setText(null);
    }
    public void editdata(){
        String query = "UPDATE data_buku SET judulBuku = '" + judultxt.getText() +"', genreBuku = '" + genretxt.getText() +"', penulisBuku = '" +penulistxt.getText() +"', tahunBuku ='"+ tahuntxt.getText() + "'WHERE idBuku = "+ idtxt.getText()+"";
        executeQuery(query);
        loadData();
        cleartext();
    }
    public void tambahdata(){
        String query = "INSERT INTO data_buku VALUES (" + idtxt.getText() + ",'" + judultxt.getText() +"', '" + genretxt.getText() +"','" +penulistxt.getText() +"','"+ tahuntxt.getText() + "')";
        executeQuery(query);
        loadData();
        cleartext();
    }

    public void hapusdata(){
        String query = "DELETE FROM data_buku WHERE idBuku = " + idtxt.getText() +"";
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
