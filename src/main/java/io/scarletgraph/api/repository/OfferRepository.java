package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.generic.IRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends IRepository<Offer> {

    List<Offer> findOfferByEmployerId(Long id);

    Optional<Offer> findById(Long id);


    @Query(nativeQuery = true, value = "select * from offer where content like '%:label%'")
    List<Offer> findAllByLabel(String label);



}