package com.example.pasir_baranski_szymon.repository;

import com.example.pasir_baranski_szymon.model.Group;
import com.example.pasir_baranski_szymon.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByGroupId(Long groupId);
}
