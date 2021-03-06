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

import java.util.HashSet
import java.util.Set

import org.chai.kevin.Period
import org.chai.location.DataLocationType
import org.chai.kevin.util.DataUtils
import org.chai.kevin.value.RawDataElementValue

class RawDataElement extends DataElement<RawDataElementValue> {

	String info
	Source source
	
	static mapping = {
		table 'dhsst_data_raw_element'
		source column: 'source'
	}
	
	static constraints = {
		info (nullable: true)
		source (nullable: true)
	}
	
	@Override
	public Class<RawDataElementValue> getValueClass() {
		return RawDataElementValue.class;
	}

	@Override
	public String toString() {
		return "RawDataElement[getId()=" + getId() + ", getCode()=" + getCode() + "]";
	}

	@Override
	public Set<String> getSources(Period period, DataLocationType type) {
		return getSources();
	}
	
	public Set<String> getSources() {
		Set<String> result = new HashSet<String>();
		if (source != null) result.add(source.getCode());
		return result;
	}
	
}
