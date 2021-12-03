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

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * An element with instance annotations.
 */
public abstract class Annotatable {

  /*
  Annotations are on many different types of objects so in large datasets
  with few annotations any lists even if empty will consume a lot of
  heap space. This class is optimized for scenarios with few or no annotations
  because it will only initialize the annotation collections when needed.
  This implementation only returns a readonly view of the annotations so that
  modification can only be done by the instance function of this class.
  The readonly list is not created on the fly since it is used heavily
  in equals and hashcode code.
  */

  private final static List<Annotation> EMPTY_ANNOTATIONS = ImmutableList.of();

  /**
   * A list of annotations that is initiated with an empty static list
   */
  private List<Annotation> annotations = EMPTY_ANNOTATIONS;

  /**
   * A list of readonly view of the annotations
   */
  private List<Annotation> immutableAnnotations = EMPTY_ANNOTATIONS;

  public void addAnnotation(final Annotation annotation) {
    synchronized (this) {
      if (this.annotations == EMPTY_ANNOTATIONS) {
        this.annotations = new ArrayList<>();
      }
      this.annotations.add(annotation);
      this.immutableAnnotations = ImmutableList.copyOf(this.annotations);
    }
  }

  public void addAllAnnotations(final Collection<Annotation> newAnnotations) {
    synchronized (this) {
      if (!newAnnotations.isEmpty()) {
        if (annotations == EMPTY_ANNOTATIONS) {
          this.annotations = new ArrayList<>();
        }
        annotations.addAll(newAnnotations);
        this.immutableAnnotations = ImmutableList.copyOf(this.annotations);
      }
    }
  }

  /**
   * Get an immutable view of all the Annotations.
   *
   * @return an immutable view of all the Annotations
   */
  public List<Annotation> getImmutableAnnotations() {
    synchronized (this) {
      return this.immutableAnnotations;
    }
  }
}
