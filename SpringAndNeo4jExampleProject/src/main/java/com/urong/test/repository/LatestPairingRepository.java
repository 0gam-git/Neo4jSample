package com.urong.test.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.urong.test.domain.LatestPairing;

public interface LatestPairingRepository extends GraphRepository<LatestPairing> {

	
}
