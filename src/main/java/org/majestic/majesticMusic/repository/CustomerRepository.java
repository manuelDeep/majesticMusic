package org.majestic.majesticMusic.repository;

import org.majestic.majesticMusic.entity.TbCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<TbCustomer, Integer>  {
}
