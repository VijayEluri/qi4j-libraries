/*  Copyright 2009 Tonny Kohar.
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
package org.qi4j.library.swing.envisage.detail;

import javax.swing.JPanel;

/**
 * Abstract Base class for DetailPane
 * 
 * @author Tonny Kohar (tonny.kohar@gmail.com)
 */
public abstract class DetailPane extends JPanel
{
    public abstract void setDescriptor(Object objectDescriptor);

}