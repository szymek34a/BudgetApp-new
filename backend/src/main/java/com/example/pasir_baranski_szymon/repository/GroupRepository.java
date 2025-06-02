package com.example.pasir_baranski_szymon.repository;

import com.example.pasir_baranski_szymon.model.Group;
import com.example.pasir_baranski_szymon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByMemberships_User(User user);
}
