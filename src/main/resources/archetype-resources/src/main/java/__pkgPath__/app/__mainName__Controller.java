#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.app;

import java.net.URL;
import java.util.ResourceBundle;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;

import ${pkgName}.common.Loggable;
import ${pkgName}.controls.AboutAlert;
import ${pkgName}.controls.NodeControllerPair;
import ${pkgName}.controls.StackPaneProgressUI;
import ${pkgName}.controls.TextAreaMessageDisplay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main application controller.
 */
@Singleton
@Loggable
public class ${mainName}Controller implements Initializable {

    private static final String TITLE = "title";

    @FXML
    private MenuBar menuBar;

    @FXML
    private StackPane stackPane;

    @FXML
    private TextArea textAreaMessages;

    @FXML
    private BorderPane borderPaneContent;

    @Inject
    private Instance<FXMLLoader> loaderInstance;

    private ResourceBundle bundle;

    private StackPaneProgressUI progressUI;

    private TextAreaMessageDisplay messageDisplay;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        bundle = resources;
        progressUI = new StackPaneProgressUI(stackPane);
        messageDisplay = new TextAreaMessageDisplay(textAreaMessages);
    }

    @FXML
    public void onQuit(final ActionEvent event) {
        final Scene scene = stackPane.getScene();
        final Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    public void onOpenChildController(ActionEvent event) {
        final NodeControllerPair<ChildController> childCtrlPair = NodeControllerPair.load(loaderInstance, ChildController.class);
        final ChildController childController = childCtrlPair.getController();
        childController.setProgressUI(progressUI);
        childController.setMessageDisplay(messageDisplay);
        borderPaneContent.setCenter(childCtrlPair.getParent());
        
    }
    
    @FXML
    public void onAbout(ActionEvent event) {
        new AboutAlert().showAndWait();
    }

    /**
     * Returns the title of this controller.
     * 
     * @return Title.
     */
    public String getTitle() {
        return bundle.getString(TITLE);
    }

}
