/*
 * Copyright 2008 Niclas Hedhman. All rights Reserved.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package org.qi4j.logging.log;

import org.qi4j.Qi4j;
import org.qi4j.composite.Composite;
import org.qi4j.injection.scope.Service;
import org.qi4j.injection.scope.Structure;
import org.qi4j.injection.scope.This;
import org.qi4j.logging.log.service.LoggingService;
import org.qi4j.logging.log.LogType;
import java.io.Serializable;

public class StandardLogConcern
    implements StandardLog
{
    @Structure private Qi4j api;
    @Service( optional = true ) private LoggingService loggingService;
    @This private Composite composite;

    public void log( LogType type, String category, String message )
    {
        if( loggingService == null )
        {
            return;
        }
        loggingService.log( type, api.dereference( composite ), category, message );
    }

    public void log( LogType type, String category, String message, Serializable param1 )
    {
        if( loggingService == null )
        {
            return;
        }
        loggingService.log( type, api.dereference( composite ), category, message, param1 );
    }

    public void log( LogType type, String category, String message, Serializable param1, Serializable param2 )
    {
        if( loggingService == null )
        {
            return;
        }
        loggingService.log( type, api.dereference( composite ), category, message, param1, param2 );
    }

    public void log( LogType type, String category, String message, Serializable... params )
    {
        if( loggingService == null )
        {
            return;
        }
        loggingService.log( type, api.dereference( composite ), category, message, params );
    }
}