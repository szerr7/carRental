package carRental.repositories;

import carRental.domain.RentalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalHistoryRepository extends JpaRepository<RentalHistory,Long> {
    RentalHistory findByCarId(String id);
}
