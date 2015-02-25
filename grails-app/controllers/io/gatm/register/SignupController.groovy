package io.gatm.register

import io.gatm.auth.User
import static org.springframework.http.HttpStatus.*

/**
 * Registration controller.
 *
 * @author Minhaj
 */
class SignupController {

    static namespace = "v1"
    static responseFormats = ['json']

    def messageSource

    /**
     * User signup API, accept three params in form data, email, name and password.
     *
     * endpoint: /v1/signup
     *
     * @return error or http status 200
     */
    def index(User user) {

        log.debug ("Signing up: ${user}")

        user.validate()

        if(user.hasErrors()) {
            if(log.isDebugEnabled()) {
                user.errors.allErrors.each {log.error messageSource.getMessage(it, null)}
            }
            respond user.errors
        } else {
            user.save(flush: true)
            render status:OK
        }
    }

}
