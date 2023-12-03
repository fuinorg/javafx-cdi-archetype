#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $delim = '.,_-/' )
#set( $empty = '' )
#set( $StringUtils = $empty.class.forName('org.codehaus.plexus.util.StringUtils') )
#set( $pkgName = $StringUtils.replace($pkgPath, "/", ".") )
/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ${pkgName}.common;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.NotNull;

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
