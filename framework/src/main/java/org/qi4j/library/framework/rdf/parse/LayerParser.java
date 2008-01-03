/*
 * Copyright 2006 Niclas Hedhman.
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
package org.qi4j.library.framework.rdf.parse;

import java.util.Map;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.qi4j.composite.Composite;
import org.qi4j.library.framework.rdf.Qi4jRdf;
import org.qi4j.spi.structure.LayerModel;
import org.qi4j.spi.structure.ModuleModel;

public final class LayerParser
{
    private final ParseContext context;

    public LayerParser( ParseContext context )
    {
        this.context = context;
    }

    public Value parseModel( LayerModel layerModel )
    {
        URI layer = context.createLayerUri( layerModel );

        ModuleParser parser = context.getParserFactory().newModuleParser();
        for( ModuleModel moduleModel : layerModel.getModuleModels() )
        {
            URI module = parser.parseModel( layerModel, moduleModel );
            context.addRelationship( layer, Qi4jRdf.RELATIONSHIP_MODULE, module );
        }

        Map<Class<? extends Composite>, ModuleModel> publicComposites = layerModel.getPublicCompositeMap();
        for( Map.Entry<Class<? extends Composite>, ModuleModel> entry : publicComposites.entrySet() )
        {
            Class publicComposite = entry.getKey();
            ModuleModel moduleModel = entry.getValue();
            URI composite = context.createCompositeUri( layerModel, moduleModel, publicComposite );
            context.addRelationship( layer, Qi4jRdf.RELATIONSHIP_PUBLIC_COMPOSITE, composite );
        }
        return layer;
    }
}