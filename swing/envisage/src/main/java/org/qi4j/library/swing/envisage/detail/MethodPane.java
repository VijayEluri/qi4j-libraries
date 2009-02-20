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

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import org.qi4j.library.swing.envisage.model.descriptor.EntityDetailDescriptor;
import org.qi4j.library.swing.envisage.model.descriptor.CompositeMethodDetailDescriptor;
import org.qi4j.library.swing.envisage.model.descriptor.ServiceDetailDescriptor;
import org.qi4j.spi.entity.EntityDescriptor;

/**
 * @author Tonny Kohar (tonny.kohar@gmail.com)
 */
public class MethodPane extends DetailPane
{
    //protected ResourceBundle bundle = ResourceBundle.getBundle( this.getClass().getName() );

    private JPanel contentPane;
    private JList methodList;
    private JPanel infoPane;

    private DefaultListModel listModel;

    public MethodPane()
    {
        this.setLayout( new BorderLayout() );
        this.add( contentPane, BorderLayout.CENTER );

        listModel = new DefaultListModel();
        methodList.setModel( listModel );
    }

    protected void clear()
    {
        listModel.clear();
    }

    public void setDescriptor( Object objectDesciptor )
    {
        clear();

        // TODO
        if( objectDesciptor instanceof ServiceDetailDescriptor )
        {
            ServiceDetailDescriptor descriptor = ( (ServiceDetailDescriptor) objectDesciptor );
        }
        else if( objectDesciptor instanceof EntityDetailDescriptor )
        {
            EntityDetailDescriptor descriptor = ( (EntityDetailDescriptor) objectDesciptor );
            reload( descriptor.methods() );
        }
    }

    private void reload( Iterable<CompositeMethodDetailDescriptor> iter )
    {
        for( CompositeMethodDetailDescriptor descriptor : iter )
        {
            listModel.addElement( descriptor );
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
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
        contentPane = new JPanel();
        contentPane.setLayout( new BorderLayout( 0, 0 ) );
        final JSplitPane splitPane1 = new JSplitPane();
        contentPane.add( splitPane1, BorderLayout.CENTER );
        final JScrollPane scrollPane1 = new JScrollPane();
        splitPane1.setLeftComponent( scrollPane1 );
        methodList = new JList();
        scrollPane1.setViewportView( methodList );
        infoPane = new JPanel();
        infoPane.setLayout( new GridBagLayout() );
        splitPane1.setRightComponent( infoPane );
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return contentPane;
    }
}