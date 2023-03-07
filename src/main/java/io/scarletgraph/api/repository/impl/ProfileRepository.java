package io.scarletgraph.api.repository.impl;

import io.scarletgraph.api.domain.Profile;
import io.scarletgraph.api.generic.IRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface ProfileRepository extends IRepository<Profile> {

    @Query(nativeQuery = true, value = "SELECT profile.* FROM profile INNER JOIN tb_user us on obj.id = us.profile_id where us.id=:id")
    Optional<Profile> findProfileByUserId(Long id);
}
