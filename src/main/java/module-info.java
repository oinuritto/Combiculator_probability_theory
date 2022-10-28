module ru.itis.oinuritto.combinatorics {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens ru.itis.oinuritto.combinatorics to javafx.fxml;
    exports ru.itis.oinuritto.combinatorics;
    exports ru.itis.oinuritto.combinatorics.Controllers;
    opens ru.itis.oinuritto.combinatorics.Controllers to javafx.fxml;
    exports ru.itis.oinuritto.combinatorics.utils;
    opens ru.itis.oinuritto.combinatorics.utils to javafx.fxml;
}