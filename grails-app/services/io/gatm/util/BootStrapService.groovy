package io.gatm.util

import grails.converters.JSON
import org.grails.datastore.mapping.validation.ValidationErrors

/**
 * Boot strapping stuff at startup.
 *
 * @author Minhaj
 */
class BootStrapService {

    def messageSource

    def registerCustomJSONMarshallers () {

        /**
         * Custom marshaller to not expose extra properties when returning errors.
         * This marshaller convert response into: e.g
         * <pre>
         *     {
         *      "errors": [
         *          "Sorry, it looks like someone is already signed up with this email.",
         *          "Property [password] of class [class io.gatm.auth.User] cannot be null"
         *      ]
         *     }
         * </pre>
         *
         */
JSON.registerObjectMarshaller(ValidationErrors) { validationErrors ->
    def errors = [] //add all errors into this list
    validationErrors.target.errors.allErrors.each { error ->
        errors.add(messageSource.getMessage(error, null)) //get messages from properties file.
    }

    //return map with errors list
    return ["errors":errors]
}
    }
}
