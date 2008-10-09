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
package org.qi4j.library.swing.visualizer.detailPanel.internal.form.layer;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.qi4j.library.swing.visualizer.detailPanel.internal.common.CollectionUtils;
import org.qi4j.library.swing.visualizer.detailPanel.internal.form.common.ListListModel;
import static org.qi4j.library.swing.visualizer.detailPanel.internal.form.common.ListListModel.EMPTY_MODEL;
import org.qi4j.library.swing.visualizer.detailPanel.internal.form.common.context.Qi4jContextForm;
import org.qi4j.library.swing.visualizer.model.LayerDetailDescriptor;
import org.qi4j.spi.structure.LayerDescriptor;

/**
 * @author edward.yakop@gmail.com
 * @since 0.5
 */
public class LayerDescriptorForm
{
    private LayerDetailDescriptor layerDescriptor;

    private JComponent layerSeparator;

    private JTextField layerName;
    private JList dependsOn;
    private JList usedBy;

    private JTabbedPane tabbedPane;
    private ProvidesQi4jContextModel providersModel;
    private Qi4jContextForm provides;
    private AccessiblesQi4jContextModel accessiblesModel;
    private Qi4jContextForm accessibles;

    private JPanel layerForm;

    public LayerDescriptorForm()
    {
        $$$setupUI$$$();

        tabbedPane.addChangeListener( new ChangeListener()
        {
            public void stateChanged( ChangeEvent e )
            {
                updateSelectedTabPanelComponent();
            }
        } );
    }

    private void updateSelectedTabPanelComponent()
    {
        int selectedIndex = tabbedPane.getSelectedIndex();
        switch( selectedIndex )
        {
        case 0:
            providersModel.updateModel( layerDescriptor );
            provides.refreshView();
            break;
        case 1:
            accessiblesModel.updateModel( layerDescriptor );
            accessibles.refreshView();
            break;
        }
    }

    @SuppressWarnings( "unchecked" )
    public final void updateModel( LayerDetailDescriptor aDescriptor )
    {
        layerDescriptor = aDescriptor;

        String layerNameStr = null;
        ListListModel dependsOnModel = EMPTY_MODEL;
        ListListModel usedLayerModel = EMPTY_MODEL;

        if( aDescriptor != null )
        {
            LayerDescriptor descriptor = aDescriptor.descriptor();
            layerNameStr = descriptor.name();

            Iterable<LayerDetailDescriptor> usedLayers = aDescriptor.usedLayers();
            dependsOnModel = new ListListModel( CollectionUtils.toList( usedLayers ) );

            usedLayerModel = new ListListModel( aDescriptor.usedBy() );
        }
        else
        {
            providersModel.updateModel( null );
        }

        layerName.setText( layerNameStr );
        dependsOn.setModel( dependsOnModel );
        usedBy.setModel( usedLayerModel );

        updateSelectedTabPanelComponent();
    }

    private void createUIComponents()
    {
        DefaultComponentFactory cmpFactory = DefaultComponentFactory.getInstance();
        layerSeparator = cmpFactory.createSeparator( "Layer" );

        providersModel = new ProvidesQi4jContextModel();
        provides = new Qi4jContextForm( providersModel );

        accessiblesModel = new AccessiblesQi4jContextModel();
        accessibles = new Qi4jContextForm( accessiblesModel );
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        createUIComponents();
        layerForm = new JPanel();
        layerForm.setLayout( new FormLayout( "fill:max(d;4px):noGrow,fill:83px:noGrow,left:4dlu:noGrow,fill:max(p;80dlu):noGrow,left:4dlu:noGrow,fill:83px:noGrow,left:4dlu:noGrow,fill:max(p;80dlu):noGrow,left:5dlu:noGrow,fill:d:grow,left:max(d;4px):noGrow", "center:p:noGrow,center:max(d;4px):noGrow,center:p:noGrow,top:4dlu:noGrow,center:50px:noGrow,top:4dlu:noGrow,fill:p:grow" ) );
        ( (FormLayout) layerForm.getLayout() ).setColumnGroups( new int[][]{ new int[]{ 2, 6 }, new int[]{ 4, 8 }, new int[]{ 3, 5, 7, 9 } } );
        final JLabel label1 = new JLabel();
        label1.setText( "Name" );
        CellConstraints cc = new CellConstraints();
        layerForm.add( label1, cc.xy( 2, 3 ) );
        layerName = new JTextField();
        layerName.setEditable( false );
        layerForm.add( layerName, cc.xy( 4, 3, CellConstraints.FILL, CellConstraints.DEFAULT ) );
        final JLabel label2 = new JLabel();
        label2.setText( "Depends on" );
        layerForm.add( label2, cc.xy( 2, 5 ) );
        dependsOn = new JList();
        layerForm.add( dependsOn, cc.xy( 4, 5, CellConstraints.DEFAULT, CellConstraints.FILL ) );
        layerForm.add( layerSeparator, cc.xyw( 2, 1, 9 ) );
        tabbedPane = new JTabbedPane();
        layerForm.add( tabbedPane, cc.xyw( 2, 7, 9 ) );
        final JPanel panel1 = new JPanel();
        panel1.setLayout( new FormLayout( "fill:p:grow", "fill:p:grow" ) );
        tabbedPane.addTab( "Provides", panel1 );
        panel1.add( provides.$$$getRootComponent$$$(), cc.xy( 1, 1 ) );
        final JPanel panel2 = new JPanel();
        panel2.setLayout( new FormLayout( "fill:d:grow", "fill:d:grow" ) );
        tabbedPane.addTab( "Accessibles", panel2 );
        panel2.add( accessibles.$$$getRootComponent$$$(), cc.xy( 1, 1 ) );
        final JLabel label3 = new JLabel();
        label3.setText( "Used by" );
        layerForm.add( label3, cc.xy( 6, 5 ) );
        usedBy = new JList();
        layerForm.add( usedBy, cc.xy( 8, 5, CellConstraints.DEFAULT, CellConstraints.FILL ) );
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return layerForm;
    }
}