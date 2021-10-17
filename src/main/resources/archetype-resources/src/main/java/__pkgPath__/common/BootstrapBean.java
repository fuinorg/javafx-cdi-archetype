#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.common;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.NotNull;

import javafx.application.Application.Parameters;

/**
 * CDI bean that contains information extracted during the application bootstrap process.
 */
@ApplicationScoped
public class BootstrapBean {

    private Parameters parameters;

    /**
     * Returns the parameters.
     * 
     * @return Parameters.
     */
    @NotNull
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters to a new value.
     * 
     * @param parameters
     *            Parameters.
     */
    public void setParameters(@NotNull final Parameters parameters) {
        this.parameters = parameters;
    }

}
