package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.OfferDTO.OfferResquest;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.OfferRepository;
import io.scarletgraph.api.repository.UserRepository;
import io.scarletgraph.api.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OfferCRUDService {

    private final OfferRepository offerRepository;
    private final UserCRUDService userCRUDService;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final Utils utils;


    public OfferCRUDService(UserRepository userRepository, OfferRepository offerRepository, UserCRUDService userCRUDService, Utils utils) {
        this.offerRepository = offerRepository;
        this.utils = utils;
        this.userRepository = userRepository;
        this.userCRUDService = userCRUDService;
        this.mapper = new ModelMapper();
    }

    public List<Offer> getOfferByemployer(String employerName) {
        try{
            Optional<UserDTO> employer = userCRUDService.getByUsername(employerName);

            return offerRepository.findOfferByEmployerId(employer.get().getId());
        } catch (Exception e){
            throw new ResourceNotFound("Error fetching offers by employer!");
        }
    }

    public Optional<Offer> getById(Long id) {
        Optional<Offer> offer = offerRepository.findById(id);

        if(offer.isEmpty()) {
            throw new ResourceNotFound("Error fetching offer!");
        }

        return offer;
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    public List<Offer> filterOffer(String label, Boolean type, Boolean remote) {

        try {
            if(type) {
                return offerRepository.filterFulltimeOffer(label, remote);
            } else {
                return offerRepository.filterHalfTimeOffer(label, remote);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResourceNotFound("Error fetching offer!");
        }

    }

    public List<Offer> findRecommendedAll() {
        return offerRepository.findRecommendedAll();
    }

    public List<Offer> findAllByCandidate(String username) {

        User user = userRepository.findUserByUsername(username);

        return offerRepository.findAllByCandidate(user.getId());
    }

    public List<Offer> findAllByCompany(String username) {

        User user = userRepository.findUserByUsername(username);

        return offerRepository.findByUser(user.getId());
    }

    public void applyToOffer(Long offerID, String employer_name) {
        User user = userRepository.findUserByUsername(employer_name);
        Optional<Offer> offer = offerRepository.findById(offerID);

        if(offer.isEmpty()) {
            throw new ResourceNotFound("Offer not found in system!");
        }

        try{
            List<User> users = offer.get().getCandidates();
            users.add(user);
            offer.get().setCandidates(users);
            offerRepository.save(offer.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Long id) {
        Optional<Offer> offer = offerRepository.findById(id);

        if(offer.isEmpty()){
            throw new ResourceNotFound("Offer by id not found!");
        }
        log.info("Deleting offer...");

        offerRepository.delete(offer.get());
    }

    public List<Offer> findAllBylabel(final String label) {
        return offerRepository.findAllByLabel(label);
    }

    public Optional<Offer> findById(Long id) {
        Optional<Offer> offer = offerRepository.findById(id);

        if(offer.isEmpty()) {
            throw new ResourceNotFound("Offer not found in system!");
        }

        return offer;
    }


    public void add(OfferResquest request, String employer_username) {
        log.info("creating offer....");

        User employer = userRepository.findUserByUsername(employer_username);

        Offer offer = new Offer();
        offer.setHours(request.getHours());
        offer.setSalary(request.getSalary());
        offer.setTitle(request.getTitle());
        offer.setContent(request.getContent());
        offer.setEmployer(employer);
        offer.setLocation(request.getLocation());
        offer.setCreatedDate(utils.getDate());
        offer.setRemote(request.getRemote());
        offer.setRequirements(request.getRequirements());
        log.info("Saving offer....");
        offerRepository.save(offer);
        log.info("Offer save with success....");
    }
}