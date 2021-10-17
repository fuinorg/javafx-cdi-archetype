#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.common;

/**
 * Child controller that displays some data.
 * 
 * @param <T>
 *            Type of data.
 */
public interface ChildController<T> {

    /**
     * Sets the parent controller.
     * 
     * @param parentController
     *            Parent controller.
     */
    public void setParent(ProgressUI parentController);

    /**
     * Sets the data.
     * 
     * @param data
     *            Data to set.
     */
    public void setData(T data);

}
