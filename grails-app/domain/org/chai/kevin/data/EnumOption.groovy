package org.chai.kevin.data;

/* 
 * Copyright (c) 2011, Clinton Health Access Initiative.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.util.Map

import org.chai.kevin.util.DataUtils

@i18nfields.I18nFields
//@EqualsAndHashCode(includes=['code', 'enume'])
public class EnumOption {

	// deprecated
	Long id;
	
	String code
	String value
	
	String names
	String descriptions
	String orders
	
	// TODO flag to deactivate option in survey, 
	// think about how to make that better
	// enum and enum options should not be directly linked to a survey
	Boolean inactive = false

	static belongsTo = [enume: Enum]

	static i18nFields = ['names', 'descriptions', 'orders']
	
	static mapping = {
		table 'dhsst_enum_option'
		
		code index: 'Option_Index'
		enume column: 'enume', index: 'Option_Index'
		cache true
	}
	
	static constraints =  {
		code (nullable: false, blank: false, unique: ['code', 'enume'])
		value (nullable: false, blank: false)
		names (nullable: true)
		descriptions (nullable: true)
		orders (nullable: true)
	}

	Map cachedOrderMap 
	
	static transients = ['cachedOrderMap', 'order']

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((enume == null) ? 0 : enume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.is(obj))
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EnumOption))
			return false;
		EnumOption other = (EnumOption) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (enume == null) {
			if (other.enume != null)
				return false;
		} else if (!enume.equals(other.enume))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EnumOption[getId()=" + getId() + ", getCode()=" + getCode() + ", getEnume()=" + getEnume() + "]";
	}
	
}
