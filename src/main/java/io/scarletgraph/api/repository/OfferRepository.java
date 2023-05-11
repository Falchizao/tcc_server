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

    @Query(nativeQuery = true, value = "select offer.* from offer inner join offer_candidates oc on oc.offer_id = offer.id where oc.candidates_id =:candidate_id")
    List<Offer> findAllByCandidate(Long candidate_id);

    @Query(nativeQuery = true, value = "select * from offer where tb_user =:company_id")
    List<Offer> findByUser(Long company_id);

    @Query(nativeQuery = true, value = "select * from offer order by id desc limit 4 ")
    List<Offer> findRecommendedAll();

    @Query(nativeQuery = true, value = "select * from offer where remote=:remote and hours > 6 and requirements ilike CONCAT('%',:label,'%') OR location ilike CONCAT('%',:label,'%') OR content ilike CONCAT('%',:label,'%') OR title ilike CONCAT('%',:label,'%')")
    List<Offer> filterFulltimeOffer(String label, Boolean remote);

    @Query(nativeQuery = true, value = "select * from offer where remote=:remote and hours <= 6 and requirements ilike CONCAT('%',:label,'%') OR location ilike CONCAT('%',:label,'%') OR content ilike CONCAT('%',:label,'%') OR title ilike CONCAT('%',:label,'%')")
    List<Offer> filterHalfTimeOffer(String label, Boolean remote);
}