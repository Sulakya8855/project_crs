module com.crs.project_crs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.crs.project_crs to javafx.fxml;
    exports com.crs.project_crs;
}