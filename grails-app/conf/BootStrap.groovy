import io.gatm.auth.User

class BootStrap {

    def bootStrapService

    def init = { servletContext ->
        new User(email:"mimhaj@gatm.io", password:"testing").save()
        bootStrapService.registerCustomJSONMarshallers()
    }

    def destroy = {
    }
}
