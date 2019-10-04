package com.data.springboot_data.error;

import java.util.Set;

public class ElementUnSupportedFieldPatchException extends RuntimeException {

    public ElementUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
