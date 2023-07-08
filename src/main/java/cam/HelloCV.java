package src.main.java.cam;

import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.fxml.FXMLLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class HelloCV extends Application {

    public static void main(String[] args){
        System.loadLibrary("opencv_java480");
        launch(args);
//        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
//        System.out.println("mat = " + mat.dump());
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        // TODO-[FXMLの読み込みでエラーになるのでMVNでのパスを確認する
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("cam/ImageView.fxml"));
        BorderPane root = (BorderPane) loader.load();
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(null);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        final OpenCvController controller = loader.getController();
        primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                controller.setClosed();
            }
        }));
        int xPos = 200;
        int yPos = 200;
        primaryStage.setTitle("Video Processing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
