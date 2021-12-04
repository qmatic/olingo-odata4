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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AnnotatableTest {

    private static class AnnotatableTestClass extends Annotatable { }

    private static int countAnnotations(Annotatable annotatable) {
        int count = 0;
        for (Annotation annotation : annotatable.getAnnotationsIterable()) {
            count++;
        }
        return count;
    }

    private static Annotation createAnnotation(String term, String value) {
        Annotation a = new Annotation();
        a.setTerm(term);
        a.setValue(ValueType.PRIMITIVE, value);
        return a;
    }

    @Test
    public void initializeIsZero() {
        AnnotatableTestClass test = new AnnotatableTestClass();
        assertEquals(0, test.sizeOfAnnotations());
        assertEquals(0, countAnnotations(test));
    }

    @Test
    public void addOneAnnotation() {
        AnnotatableTestClass test = new AnnotatableTestClass();
        test.addAnnotation(createAnnotation("a", "b"));
        assertEquals(1, test.sizeOfAnnotations());
        assertEquals(1, countAnnotations(test));
    }

    @Test
    public void addTwoAnnotations() {
        AnnotatableTestClass test = new AnnotatableTestClass();
        test.addAnnotation(createAnnotation("a", "b"));
        test.addAnnotation(createAnnotation("b", "c"));
        assertEquals(2, test.sizeOfAnnotations());
        assertEquals(2, countAnnotations(test));
    }

    @Test
    public void addMultipleAnnotations() {
        List<Annotation> annotations = new ArrayList<Annotation>();
        annotations.add(createAnnotation("a", "b"));
        annotations.add(createAnnotation("b", "c"));
        annotations.add(createAnnotation("d", "e"));

        AnnotatableTestClass test = new AnnotatableTestClass();
        test.addAnnotations(annotations);
        assertEquals(3, test.sizeOfAnnotations());
        assertEquals(3, countAnnotations(test));
    }

    @Test
    public void testAnnotationsHashCode() {
        AnnotatableTestClass test = new AnnotatableTestClass();
        int hash = test.getAnnotationsHashCode();
        test.addAnnotation(createAnnotation("a", "b"));
        int hash2 = test.getAnnotationsHashCode();
        assertNotEquals(hash, hash2);
        test.addAnnotation(createAnnotation("b", "c"));
        int hash3 = test.getAnnotationsHashCode();
        assertNotEquals(hash2, hash3);
        assertEquals(2, test.sizeOfAnnotations());
        assertEquals(2, countAnnotations(test));
    }
}