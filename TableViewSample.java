/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_interface;

    import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import p7_interface.TableViewSample.Gun.MedicalBox;
 
public class TableViewSample extends Application {
 
    private TableView table = new TableView();

    private final ObservableList<Inventory> data =
        FXCollections.observableArrayList(
            new Gun(true, "1", "freeforall",20.11,false),
            new MedicalBox(true, "red", "freeforall",20.11,false)
            
        );
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(1100);
        stage.setHeight(700);
 
        final Label label = new Label("Equipment");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn firstNameCol = new TableColumn("Equipment Charged");
        firstNameCol.setMinWidth(200);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Inventory, Boolean>("Equipment Charged"));
        TableColumn secondNameCol = new TableColumn("Equipment ID");
        secondNameCol.setMinWidth(100);
        secondNameCol.setCellValueFactory(
                new PropertyValueFactory<Inventory, String>("Equipment Charged"));
        TableColumn thirdNameCol = new TableColumn("Settings");
        thirdNameCol.setMinWidth(200);
        thirdNameCol.setCellValueFactory(
                new PropertyValueFactory<Inventory, String>("Settings"));
        TableColumn forthNameCol = new TableColumn("Date of charge");
        forthNameCol.setMinWidth(200);
        forthNameCol.setCellValueFactory(
                new PropertyValueFactory<Inventory, Double>("Date of charge"));
        TableColumn maintainCol = new TableColumn("Send to maintanance");
        maintainCol.setMinWidth(200);
        maintainCol.setCellValueFactory(
                new PropertyValueFactory<Inventory, Boolean>("Send to maintanance"));
        //maintainCol.setVisible(false);
        
        table.getColumns().addAll(firstNameCol, secondNameCol, thirdNameCol, forthNameCol, maintainCol);
 
        final VBox vbox = new VBox();
        //vbox.setVgrow(table, Priority.ALWAYS);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
    
    public static class Gun extends Inventory{
 
        private final SimpleBooleanProperty equipmentCharged;
        private final SimpleStringProperty equipmentId;
        private final SimpleStringProperty settings;
        private final SimpleDoubleProperty dateOfCharge;
        private final SimpleBooleanProperty sendToMaintainance;
 
        private Gun(Boolean chargeStatus, String ID, String settings, double date, boolean maintanance) {
            this.equipmentCharged = new SimpleBooleanProperty(chargeStatus);
            this.equipmentId = new SimpleStringProperty(ID);
            this.settings = new SimpleStringProperty(settings);
            this.dateOfCharge = new SimpleDoubleProperty(date);
            this.sendToMaintainance = new SimpleBooleanProperty(maintanance);
        }
        
          public static class MedicalBox extends Inventory{
 
        private final SimpleBooleanProperty equipmentCharged;
        private final SimpleStringProperty equipmentId;
        private final SimpleStringProperty settings;
        private final SimpleDoubleProperty dateOfCharge;
        private final SimpleBooleanProperty sendToMaintainance;
 
        private MedicalBox(Boolean chargeStatus, String ID, String settings, double date, boolean maintanance) {
            this.equipmentCharged = new SimpleBooleanProperty(chargeStatus);
            this.equipmentId = new SimpleStringProperty(ID);
            this.settings = new SimpleStringProperty(settings);
            this.dateOfCharge = new SimpleDoubleProperty(date);
            this.sendToMaintainance = new SimpleBooleanProperty(maintanance);
        }
 
      /* public Boolean getChargeStatus() {
            return chargeStatus.get();
        }
 
        public void setChargeStatus(Boolean chargeStatus) {
            chargeStatus.set(chargeStatus);
        }*/
 
        public String getID() {
            return equipmentId.get();
        }
 
        public void setID(String ID) {
            equipmentId.set(ID);
        }
 
        public String getsettings() {
            return settings.get();
        }
 
       /* public void setsettings(String settings) {
            settings.set(settings);
        }*/
    }
    }
} 


