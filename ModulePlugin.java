/*
 * Copyright (C) 2015 hsd.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package charger;

import charger.exception.CGException;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 * Provides a plug in capability for external modules, such as the MMAT analysis
 * package. The module is assumed to have complete access to charger and in general 
 * will need to be compiled with all the charger packages in the class path.
 * 
 * To make your plugin accessible to Charger, you create a module plugin boot class,
 * one that controls the rest of your plugin operation,
 * subject to the following constraints:
 * <ul>
 * <li>It must be a class that is NOT inside any other package; 
 * i.e., it should appear at the top level of the jar file, or in the top level
 * of some folder on the class path.
 * (Your plugin's actual code package can be positioned anywhere you want.)
 * </li>
 * <li>
 * The plugin must be named xxxxModulePlugin (e.g., ABCModulePlugin) and
 * appear in the top level of a class path element as ABCModulePlugin.class.
 * </li>
 * <li>
 * It must implement all the methods of this interface.
 * </li>
 * </ul>
 * Once you've done all that, the name (see getName below) will appear on the
 * tools menu. When selected, Charger will invoke the startup method of your
 * boot class. After that, it's up to you!
 * @author hsd
 */
public interface ModulePlugin {
    
    public class ModuleException  {
        
    }
    
    /** Return the simple name of this module. */
    abstract public String getName( );
    
    /** Get the accelerator combination needed for the menu item */
    abstract public KeyStroke getKeyStroke();
    
    /** Return any other information about the module, such as copyright, purpose, etc. */
    abstract public String getInfo();
    
    /** Launch this module, attaching it to Charger. */
    abstract public void startup();
    
    /** Perform whatever cleanup and finalizing necessary. */
    abstract public void shutdown();
}
