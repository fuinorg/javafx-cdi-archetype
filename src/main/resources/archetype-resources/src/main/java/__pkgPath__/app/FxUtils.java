#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
package ${pkgName}.app;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * Utilities for the package.
 */
final class FxUtils {

    private FxUtils() {
    }

    /**
     * Adjusts the width/height if the primary screen is smaller than the requested size.
     * 
     * @param width
     *            Requested width.
     * @param height
     *            Requested height.
     * 
     * @return Wither requested values or adjusted to screen size.
     */
    public static Dimension2D screenAdjustedDimension(final double width, final double height) {
        final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double resultHeight = height;
        if (screenBounds.getHeight() > 100 && screenBounds.getHeight() < resultHeight) {
            resultHeight = screenBounds.getHeight() - 100;
        }
        double resultWidth = width;
        if (screenBounds.getWidth() > 100 && screenBounds.getWidth() < resultWidth) {
            resultWidth = screenBounds.getWidth() - 100;
        }
        return new Dimension2D(resultWidth, resultHeight);
    }

}
