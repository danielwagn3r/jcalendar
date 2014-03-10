/*
 *  Copyright (C) 2006 Kai Toedter
 *  kai@toedter.com
 *  www.toedter.com
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.toedter.calendar;

import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;

/**
 * All date editors that should be used by a JDateChooser have to implement this
 * interface.
 * 
 * @author Kai Toedter
 * @version $LastChangedRevision: 17 $ $LastChangedDate: 2004-12-05 18:09:04
 *          +0100 (So, 05 Dez 2004) $
 */
public interface IDateEditor {

	/**
	 * 
	 * Returns the date.
	 * 
	 * @return the date
	 */
	public Date getDate();

	/**
	 * Sets the date. This should be implemented as a bound property, firing the
	 * "date" property.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date);

	/**
	 * Sets the date format string, e.g. "MM/dd/yy"
	 * 
	 * @param dateFormatString
	 */
	public void setDateFormatString(String dateFormatString);

	/**
	 * Returns tha date format string.
	 * 
	 * @return the date format string
	 */
	public String getDateFormatString();

	/**
	 * Returns the UI component, e.g. the actual JTextField implementing the
	 * editor.
	 * 
	 * @return the UI component
	 */
	public JComponent getUiComponent();

	/**
	 * Sets the locale. Usually this should have impact on the current date
	 * format string.
	 * 
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale);

	/**
	 * Enables or disables the UI compoment.
	 * 
	 * @param enabled
	 *            true, if the UI component should be enabled.
	 */
	public void setEnabled(boolean enabled);

	/**
	 * Adds a property change listener that should be added to the implementing
	 * UI component. The UI component should fire a "date" property if the date
	 * changes.
	 * 
	 * @param listener
	 *            the property change listener.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Removes a property change listener.
	 * 
	 * @param listener
	 *            the property change listener.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);
}
