/*
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
 */
package org.apache.olingo.commons.api.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * An element with instance annotations.
 */
public abstract class Annotatable {

  private static final List<Annotation> NO_ANNOTATIONS = new ArrayList<>();
  private List<Annotation> annotations = NO_ANNOTATIONS;

  public void addAnnotation(final Annotation annotation) {
    if (annotation == null) {
      return;
    }
    if (annotations == NO_ANNOTATIONS) {
      this.annotations = new ArrayList<>();
    }
    annotations.add(annotation);
  }

  public void addAnnotations(final Iterable<Annotation> annotations) {

    if (annotations == null) {
      return;
    }

    if (this.annotations == NO_ANNOTATIONS) {
      this.annotations = new ArrayList<>();
    }

    for (Annotation annotation : annotations) {
      this.annotations.add(annotation);
    }
  }

  public boolean annotationsEquals(Object other) {
    if (other instanceof Annotatable) {
      Annotatable that = (Annotatable) other;
      return this.annotations.equals(that.annotations);
    } else {
      return false;
    }
  }

  public int getAnnotationsHashCode() {
    return this.annotations.hashCode();
  }

  public Iterable<Annotation> getAnnotationsIterable() {
    return this.annotations;
  }

  public List<Annotation> getAnnotationsListClone() {
    return new ArrayList<>(this.annotations);
  }

}
