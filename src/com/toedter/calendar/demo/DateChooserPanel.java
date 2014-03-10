/*
 *  DateChooserPanel.java  - A panel to demo several JDateChooser configurations.
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

package com.toedter.calendar.demo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

/**
 * A demonstration panel includeing several JDateChoosers.
 * 
 * @author Kai Toedter
 * @version $LastChangedRevision: 12 $ $LastChangedDate: 2004-10-17 22:27:20
 *          +0200 (So, 17 Okt 2004) $
 */

public class DateChooserPanel extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = -1282280858252793253L;
	private JComponent[] components;

	public DateChooserPanel() {
		setName("JDateChooser");

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		setLayout(gridbag);

		components = new JComponent[5];
		components[0] = new JDateChooser();
		components[1] = new JDateChooser(new Date());
		components[2] = new JDateChooser(null, null, null,
				new JSpinnerDateEditor());
		components[3] = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		components[4] = new DemoTable();

		addEntry("Default", components[0], gridbag);
		addEntry("Default with date set", components[1], gridbag);
		addEntry("Spinner Editor", components[2], gridbag);
		addEntry("Explicite date pattern and mask", components[3], gridbag);
		addEntry("Table with date editors", components[4], gridbag);
	}

	private void addEntry(String text, JComponent component, GridBagLayout grid) {
		JLabel label = new JLabel(text + ": ", null, JLabel.RIGHT);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.fill = GridBagConstraints.BOTH;
		grid.setConstraints(label, c);
		add(label);
		c.gridwidth = GridBagConstraints.REMAINDER;
		grid.setConstraints(component, c);
		add(component);
	}

	/**
	 * Gets the date format string.
	 * 
	 * @return Returns the dateFormatString.
	 */
	public String getDateFormatString() {
		return ((JDateChooser) components[1]).getDateFormatString();
	}

	/**
	 * Sets the date format string. E.g "MMMMM d, yyyy" will result in "July 21,
	 * 2004" if this is the selected date and locale is English.
	 * 
	 * @param dfString
	 *            The dateFormatString to set.
	 */
	public void setDateFormatString(String dfString) {
		for (int i = 0; i < 4; i++) {
			((JDateChooser) components[i]).setDateFormatString(dfString);
		}
	}

	/**
	 * Returns the date. If the JDateChooser is started with an empty date and
	 * no date is set by the user, null is returned.
	 * 
	 * @return the current date
	 */
	public Date getDate() {
		return ((JDateChooser) components[1]).getDate();
	}

	/**
	 * Sets the date. Fires the property change "date" if date != null.
	 * 
	 * @param date
	 *            the new date.
	 */
	public void setDate(Date date) {
		for (int i = 0; i < 4; i++) {
			((JDateChooser) components[i]).setDate(date);
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("date")) {
			setDate((Date) evt.getNewValue());
		}
	}

	public Locale getLocale() {
		return ((JDateChooser) components[0]).getLocale();
	}

	public void setLocale(Locale locale) {
		for (int i = 0; i < 4; i++) {
			((JDateChooser) components[i]).setLocale(locale);
		}
	}

}
