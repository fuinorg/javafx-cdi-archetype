#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.app;

import javax.enterprise.inject.Instance;

import ${pkgName}.common.HostServicesBean;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.perdoctus.fx.FxCdiApplication;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Glue code between CDI and JavaFX.
 */
public final class ${mainName}Loader extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(${mainName}Loader.class);

    private ${mainName} fxWeldApplication;

    @SuppressWarnings("deprecation")
    @Override
    public void init() throws Exception {
        final Weld weld = new Weld();
        final WeldContainer weldContainer = weld.initialize();
        final Instance<FxCdiApplication> fxWeldApplications = weldContainer.instance().select(FxCdiApplication.class);
        final HostServicesBean hostServicesBean = weldContainer.instance().select(HostServicesBean.class).get();
        hostServicesBean.setHostServices(getHostServices());

        fxWeldApplication = (${mainName}) fxWeldApplications.get();
        LOG.info("Initializing application.");
        fxWeldApplication.init();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        LOG.info("Starting application.");
        fxWeldApplication.start(stage, getParameters());
    }

    @Override
    public void stop() throws Exception {
        LOG.info("Stopping application.");
        fxWeldApplication.stop();
    }

}
