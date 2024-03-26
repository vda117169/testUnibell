package com.testUnibell.testUnibell.repository;

import com.testUnibell.testUnibell.entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientInfo, Long> {

}
