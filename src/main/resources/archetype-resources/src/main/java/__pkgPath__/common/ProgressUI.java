#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.common;

/**
 * Provides functionality for tasks to display their status.
 */
public interface ProgressUI {

    /**
     * Disables the UI and shows a progress indicator.
     */
    public void startProgress();

    /**
     * Enables the UI and removes the progress indicator.
     */
    public void stopProgress();

}
