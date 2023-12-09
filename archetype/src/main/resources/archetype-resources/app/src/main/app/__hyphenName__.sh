#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
${symbol_pound}!/bin/bash
export GDK_SCALE=2
jre/bin/java -classpath *:lib/* ${pkgName}.app.${mainName}
