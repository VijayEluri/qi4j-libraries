/*  Copyright 2008 Edward Yakop.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
* implied.
*
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.qi4j.library.swing.envisage.school.infrastructure.mail;

import org.qi4j.bootstrap.Assembler;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.library.swing.envisage.school.infrastructure.mail.composites.MailComposite;
import org.qi4j.library.swing.envisage.school.infrastructure.mail.composites.MailServiceComposite;
import static org.qi4j.api.common.Visibility.application;

/**
 * @author edward.yakop@gmail.com
 * @since 0.5
 */
public class MailServiceAssembler implements Assembler
{
    public void assemble( ModuleAssembly aModuleAssembly )
        throws AssemblyException
    {
        aModuleAssembly.addComposites(
            MailComposite.class
        ).visibleIn( application );

        aModuleAssembly.addServices(
            MailServiceComposite.class
        ).visibleIn( application );
    }
}