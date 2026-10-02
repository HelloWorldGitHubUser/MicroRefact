package buildingblocks.jpa;
 import org.springframework.data.domain.AuditorAware;
import java.util.Optional;
public class JpaAuditorAwareImpl implements AuditorAware<Long>{


@Override
public Optional<Long> getCurrentAuditor(){
    // Fetch the current user ID from the security context or other sources
    // Replace with actual logic
    return Optional.of(1L);
}


}