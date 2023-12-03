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
package ${pkgName}.app;

import java.io.IOException;

import ${pkgName}.common.BootstrapBean;
import ${pkgName}.common.Preferences;
import ${pkgName}.controls.ExceptionAlert;
import ${pkgName}.controls.NodeControllerPair;
import org.fuin.fxcdibootstrap.FxCdiApplication;
import org.fuin.fxcdibootstrap.FxCdiApplicationLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import javafx.application.Application.Parameters;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Dimension2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main application.
 */
@ApplicationScoped
public class ${mainName} extends FxCdiApplication {

	private static final Logger LOG = LoggerFactory.getLogger(${mainName}.class);

	@Inject
	private Instance<FXMLLoader> loaderInstance;

	@Inject
	private BootstrapBean bootstrapBean;

	@Override
	public void start(final Stage primaryStage, final Parameters parameters) throws IOException {

		LOG.info("Start application");

		final NodeControllerPair<${mainName}Controller> ncw = NodeControllerPair.load(loaderInstance,
				${mainName}Controller.class);

		// Catch all exceptions in UI thread
		Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {

			final Logger log = LoggerFactory.getLogger(${mainName}.class);
			log.error("Uncaught Exception in " + thread, throwable);

			if (Platform.isFxApplicationThread()) {
				new ExceptionAlert(throwable).showAndWait();
			} else {
				Platform.runLater(() -> new ExceptionAlert(throwable).showAndWait());
			}

		});

		// Set bootstrap information
		bootstrapBean.setParameters(parameters);

		// Start UI
		final Dimension2D dimension = FxUtils.screenAdjustedDimension(1400, 800);
		final Parent parent = ncw.getParent();
		final Scene scene = new Scene(parent, dimension.getWidth(), dimension.getHeight());
		primaryStage.setScene(scene);
		primaryStage.setTitle(ncw.getController().getTitle());
		primaryStage.getIcons().addAll(new Image("/images/${hyphenName}-128x128.png"),
				new Image("/images/${hyphenName}-64x64.png"), new Image("/images/${hyphenName}-48x48.png"),
				new Image("/images/${hyphenName}-32x32.png"), new Image("/images/${hyphenName}-16x16.png"));
		primaryStage.show();

	}

	/**
	 * Main method for starting the application.
	 * 
	 * @param args Arguments that are provided to the custom FX application.
	 */
	public static void main(final String[] args) {
		Preferences.init();
		FxCdiApplicationLoader.launch(FxCdiApplicationLoader.class, args);
	}

}
