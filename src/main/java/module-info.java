module io.jfxdevelop.lab5_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.jfxdevelop.lab5_1 to javafx.fxml;
    exports io.jfxdevelop.lab5_1;
}