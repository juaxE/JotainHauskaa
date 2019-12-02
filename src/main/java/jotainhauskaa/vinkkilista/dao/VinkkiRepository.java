package jotainhauskaa.vinkkilista.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public interface VinkkiRepository extends JpaRepository<KirjaVinkki, Long> {
    List<KirjaVinkki> findByOtsikkoContainingIgnoreCase(String haku);
}

