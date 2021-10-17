#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.common;

/**
 * Implements a component that can be used to display messages.
 */
public interface MessageDisplay {

    /**
     * Clears the message log
     */
    public void clearMessages();

    /**
     * Adds a message to the main log.
     * 
     * @param message
     *            Message.
     */
    public void addMessage(String message);

}
