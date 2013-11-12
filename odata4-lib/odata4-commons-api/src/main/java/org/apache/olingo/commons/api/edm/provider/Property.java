/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.olingo.commons.api.edm.provider;

import org.apache.olingo.commons.api.edm.helper.FullQualifiedName;

//TODO: Finish
public class Property {

  private String name;
  // Can be simple or complex
  private FullQualifiedName type;
  private boolean isCollection;
  // Facets
  private String defaultValue;
  private Boolean nullable;
  private Integer maxLength;
  private Integer precision;
  private Integer scale;
  private Boolean isUnicode;

  public String getName() {
    return name;
  }

  public Property setName(final String name) {
    this.name = name;
    return this;
  }

  public FullQualifiedName getType() {
    return type;
  }

  public Property setType(final FullQualifiedName type) {
    this.type = type;
    return this;
  }

  public boolean isCollection() {
    return isCollection;
  }

  public Property setCollection(final boolean isCollection) {
    this.isCollection = isCollection;
    return this;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public Property setDefaultValue(final String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  public Boolean getNullable() {
    return nullable;
  }

  public Property setNullable(final Boolean nullable) {
    this.nullable = nullable;
    return this;
  }

  public Integer getMaxLength() {
    return maxLength;
  }

  public Property setMaxLength(final Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

  public Integer getPrecision() {
    return precision;
  }

  public Property setPrecision(final Integer precision) {
    this.precision = precision;
    return this;
  }

  public Integer getScale() {
    return scale;
  }

  public Property setScale(final Integer scale) {
    this.scale = scale;
    return this;
  }

  public Boolean getIsUnicode() {
    return isUnicode;
  }

  public Property setIsUnicode(final Boolean isUnicode) {
    this.isUnicode = isUnicode;
    return this;
  }

}
