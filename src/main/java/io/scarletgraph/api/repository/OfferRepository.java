package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.generic.IRepository;
import java.util.List;
import java.util.Optional;

public interface OfferRepository extends IRepository<Offer> {

    List<Offer> findOfferByUserOrderById(User user);

    Optional<Offer> findById(Long id);

}