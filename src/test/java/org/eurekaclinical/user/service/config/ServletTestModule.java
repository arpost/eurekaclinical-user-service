/*-
 * #%L
 * Eureka! Clinical User Services
 * %%
 * Copyright (C) 2016 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.eurekaclinical.user.service.config;

import org.eurekaclinical.user.common.test.UserRoleAdderFilter;
import org.eurekaclinical.common.config.AbstractTestJerseyServletModuleWithPersist;

/**
 * Configure Guice for testing.
 * 
 * @author miaoai
 * 
 */
class ServletTestModule extends AbstractTestJerseyServletModuleWithPersist {
	
	private static final String PACKAGE_NAMES = "org.eurekaclinical.user.service.resource;org.eurekaclinical.user.common.json";

	ServletTestModule() {
		super(PACKAGE_NAMES);
	}
	
	@Override
	protected void configureServlets() {
		super.configureServlets();
		filter(getContainerPath()).through(UserRoleAdderFilter.class);
	}

}
