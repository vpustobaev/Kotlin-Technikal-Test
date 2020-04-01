import org.example.converter.UserConverter
import org.example.converter.github.GitHubActorConverter
import org.example.converter.github.GitHubEventConverter
import org.example.converter.github.GitHubRepoConverter
import org.example.converter.github.GitHubUserConverter
import org.example.resource.EasterEggResource
import org.example.resource.GitHubResource
import org.example.resource.HealthResource
import org.example.resource.UserResource
import org.example.service.user.MemoryBasedUserService
import org.example.service.GitHubService
import javax.ws.rs.core.Application

class JerseyApplication : Application() {
    override fun getSingletons(): MutableSet<Any> {
        return mutableSetOf(
            UserResource(MemoryBasedUserService(), UserConverter()), HealthResource(), EasterEggResource(),
            GitHubResource(GitHubService(), GitHubEventConverter(GitHubActorConverter(), GitHubRepoConverter()),
                GitHubUserConverter()
            )
        )
    }
}