package io.scarletgraph.api.generic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class IModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    private Long Id;

}
