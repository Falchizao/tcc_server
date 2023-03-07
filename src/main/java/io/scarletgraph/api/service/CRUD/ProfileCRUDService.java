package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.Profile;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.impl.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProfileCRUDService {

    private final ProfileRepository profileRespository;


    public ProfileCRUDService(ProfileRepository profileRespository) {
        this.profileRespository = profileRespository;
    }


    public Profile getProfileByUser(Long id) {
        try{
            Optional<Profile> profile = profileRespository.findProfileByUserId(id);
            if(profile.isEmpty()){
                throw new ResourceNotFound("Profile not found by user!");
            }
            return profile.get();
        } catch (Exception e){
            throw new ResourceNotFound("Error fetching profile!");
        }
    }

    public void add (Profile profile){
        log.info("Saving profile....");
        profileRespository.save(profile);
    }
}
