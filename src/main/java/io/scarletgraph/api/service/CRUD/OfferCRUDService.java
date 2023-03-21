package io.scarletgraph.api.service.CRUD;


import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.OfferDTO.OfferResquest;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.OfferRepository;
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
    private final ModelMapper mapper;
    private final Utils utils;


    public OfferCRUDService(OfferRepository offerRepository, UserCRUDService userCRUDService, Utils utils) {
        this.offerRepository = offerRepository;
        this.utils = utils;
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

        Optional<UserDTO> employer = userCRUDService.getByUsername(employer_username);

        Offer offer = new Offer();
        offer.setHours(request.getHours());
        offer.setSalary(request.getSalary());
        offer.setTitle(request.getTitle());
        offer.setContent(request.getContent());
        offer.setEmployer(mapper.map(employer, User.class));
        offer.setCreatedDate(utils.getDate());

        log.info("Saving offer....");
        offerRepository.save(offer);
    }
}