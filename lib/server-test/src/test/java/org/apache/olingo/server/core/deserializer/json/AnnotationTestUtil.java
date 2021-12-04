package org.apache.olingo.server.core.deserializer.json;

import org.apache.olingo.commons.api.data.Annotatable;
import org.apache.olingo.commons.api.data.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for helping tests using annotations and Annotatable.
 */
class AnnotationTestUtil {

    public static List<Annotation> createAnnotationsList(Annotatable annotatable) {
        List<Annotation> annotations = new ArrayList<>();
        for (Annotation annotation : annotatable.getAnnotationsIterable()) {
            annotations.add(annotation);
        }
        return annotations;
    }

}
