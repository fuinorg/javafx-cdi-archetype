#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.app;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.inject.Singleton;

import ${pkgName}.common.Loggable;
import ${pkgName}.common.MessageDisplay;
import ${pkgName}.common.ProgressUI;
import org.slf4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Example of a child controller.
 */
@Singleton
@Loggable
public class ChildController implements Initializable {

    @FXML
    private Label labelResult;
    
    @Inject
    private Logger log;

    private ResourceBundle bundle;

    private ProgressUI progressUI;

    private MessageDisplay messageDisplay;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        bundle = resources;
        labelResult.setText("");
    }

    @FXML
    public void onExecute(ActionEvent event) {
        log.info("Execute long running task...");
        labelResult.setText(bundle.getString("waitingForResult"));
        final LongRunningTaskExample task = new LongRunningTaskExample(messageDisplay, progressUI, bundle);
        task.setOnSucceeded(e -> {
            labelResult.setText(task.getValue());
        });
        task.setOnFailed(e -> {
            final StringWriter sw = new StringWriter();
            task.getException().printStackTrace(new PrintWriter(sw));
            final String stackTrace = sw.toString();
            messageDisplay.addMessage(stackTrace);
            labelResult.setText(bundle.getString("taskFailure"));
        });
        new Thread(task).start();
    }

    /**
     * Sets the message display to use for tasks.
     * 
     * @param messageDisplay
     *            Message display provided by the root parent controller.
     */
    public void setMessageDisplay(MessageDisplay messageDisplay) {
        this.messageDisplay = messageDisplay;
    }

    /**
     * Sets the progress UI to use for tasks.
     * 
     * @param progressUI
     *            Progress UI provided by the root parent controller.
     */
    public void setProgressUI(ProgressUI progressUI) {
        this.progressUI = progressUI;
    }

}
