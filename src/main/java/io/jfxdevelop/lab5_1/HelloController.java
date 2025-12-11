package io.jfxdevelop.lab5_1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Pane gamePanel;

    @FXML
    private Rectangle Square;

    // размер шага перемещения
    private static final double STEP = 10.0;

    // максимальные координаты для ограничения движения
    private double maxX;
    private double maxY;

    @FXML
    public void initialize() {
        // обработчик клавиш для всей панели
        gamePanel.setOnKeyPressed(this::handleKeyPress);

        // Фокусируем панель, чтобы она получала события клавиатуры
        gamePanel.setFocusTraversable(true);
        gamePanel.requestFocus();

        // Границы для перемещения
        maxX = gamePanel.getWidth() - Square.getWidth();
        maxY = gamePanel.getHeight() - Square.getHeight();

        // Изменения размеров панели
        gamePanel.widthProperty().addListener((obs, oldVal, newVal) -> {
            maxX = newVal.doubleValue() - Square.getWidth();
        });
        gamePanel.heightProperty().addListener((obs, oldVal, newVal) -> {
            maxY = newVal.doubleValue() - Square.getHeight();
        });
    }

    private void handleKeyPress(KeyEvent event) {
        double currentX = Square.getX();
        double currentY = Square.getY();

        switch (event.getCode()) {
            case W:
                Square.setY(Math.max(0, currentY - STEP));
                break;
            case A:
                Square.setX(Math.max(0, currentX - STEP));
                break;
            case S:
                Square.setY(Math.min(maxY, currentY + STEP));
                break;
            case D:
                Square.setX(Math.min(maxX, currentX + STEP));
                break;
        }
    }
}