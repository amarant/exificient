/*
 * Copyright (C) 2007-2011 Siemens AG
 *
 * This program and its interfaces are free software;
 * you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.siemens.ct.exi.grammars.event;

import javax.xml.namespace.QName;

import com.siemens.ct.exi.context.QNameContext;
import com.siemens.ct.exi.grammars.grammar.Grammar;

/**
 * 
 * @author Daniel.Peintner.EXT@siemens.com
 * @author Joerg.Heuer@siemens.com
 * 
 * @version 0.9
 */

public class StartElement extends AbstractEvent {

	private static final long serialVersionUID = -874684674312937990L;

	protected final QName qname;
	protected final QNameContext qnameContext;

	private Grammar rule;

	public StartElement(QNameContext qnc) {
		super(EventType.START_ELEMENT);
		this.qnameContext = qnc;
		this.qname = qnameContext.getQName();
	}
	
	public QNameContext getQNameContext() {
		return this.qnameContext;	
	}

	public QName getQName() {
		return this.qname;
	}
	public void setRule(Grammar rule) {
		this.rule = rule;
	}

	public Grammar getRule() {
		return rule;
	}

	public String toString() {
		return super.toString() + "(" + qname.toString() + ")";
	}

	@Override
	public int hashCode() {
		return qname.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof StartElement) {
			StartElement otherSE = (StartElement) obj;
			if (qname.equals(otherSE.qname)) {
				return rule.equals(otherSE.rule);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}