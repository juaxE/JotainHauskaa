package jotainhauskaa.vinkkilista.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public interface VinkkiRepository extends JpaRepository<KirjaVinkki, Long> {
}

