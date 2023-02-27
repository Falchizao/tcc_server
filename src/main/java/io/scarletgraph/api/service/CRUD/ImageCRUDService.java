package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.Profile;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImageCRUDService  {

    private final ProfileCRUDService profileCRUDService;
    private final UserRepository userRepository;

    public ImageCRUDService(UserRepository userRepository, ProfileCRUDService profileCRUDService) {
        this.userRepository = userRepository;
        this.profileCRUDService = profileCRUDService;
    }

    public void updateProfilePicture(byte[] data, String username) {
        log.info("Updating Profile picture image...");

        User user = userRepository.findUserByUsername(username);

        if (user != null){
            throw new ResourceNotFound("User by id not found!");
        }else{
            try{
                Profile profile = profileCRUDService.getProfileByUser(user.getId());
                profile.setProfile_picture(data);

                profileCRUDService.add(profile);
            } catch (Exception e) {
                log.info("Error while updating profile picture...");
            }
        }
    }

    public void updateBanner(byte[] data, HttpServletRequest servletRequest) {
        log.info("Updating Banner image...");

        User user = userRepository.findUserByUsername(servletRequest.getUserPrincipal().getName());

        if (user == null){
            throw new ResourceNotFound("User by id not found!");
        }else{
            try{
                Profile profile= profileCRUDService.getProfileByUser(user.getId());
                profile.setProfile_banner(data);

                profileCRUDService.add(profile);
            } catch (Exception e) {
                log.info("Error while updating profile banner...");
            }
        }

    }
}