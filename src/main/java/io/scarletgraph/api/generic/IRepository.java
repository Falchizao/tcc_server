package io.scarletgraph.api.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.UUID;

public interface IRepository<T extends IModel> extends JpaRepository<T, UUID>, JpaSpecificationExecutor<T> {
}
