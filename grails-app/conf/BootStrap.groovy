import io.gatm.auth.User

class BootStrap {

    def init = { servletContext ->
        new User(email:"mimhaj@gatm.io", password:"testing").save()
    }
    def destroy = {
    }
}
