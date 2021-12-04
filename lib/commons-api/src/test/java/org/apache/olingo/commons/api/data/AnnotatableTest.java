package org.apache.olingo.commons.api.data;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void getListClone() {
        List<Annotation> annotations = new ArrayList<Annotation>();
        annotations.add(createAnnotation("a", "b"));
        annotations.add(createAnnotation("b", "c"));
        annotations.add(createAnnotation("d", "e"));

        AnnotatableTestClass test = new AnnotatableTestClass();
        test.addAnnotations(annotations);
        assertEquals(3, test.sizeOfAnnotations());
        assertEquals(3, countAnnotations(test));

        List<Annotation> clone = test.getAnnotationsListClone();
        assertNotNull(clone);
        assertEquals(annotations.size(), clone.size());
    }
}