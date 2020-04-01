import org.example.api.GitHubApi
import org.example.util.Deserializer
import org.example.converter.UserConverter
import org.example.resources.EasterEggResource
import org.example.resources.GitHubResource
import org.example.resources.HealthResource
import org.example.resources.UserResource
import org.example.service.UserService
import javax.ws.rs.core.Application

class JerseyApplication : Application() {
    override fun getSingletons(): MutableSet<Any> {
        return mutableSetOf(
            UserResource(UserService(), UserConverter()), HealthResource(), EasterEggResource(), GitHubResource(
                GitHubApi(), Deserializer()
            )
        )
    }
}