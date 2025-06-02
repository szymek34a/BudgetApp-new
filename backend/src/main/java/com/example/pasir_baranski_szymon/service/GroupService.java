package com.example.pasir_baranski_szymon.service;

import com.example.pasir_baranski_szymon.dto.GroupDTO;
import com.example.pasir_baranski_szymon.model.Debt;
import com.example.pasir_baranski_szymon.model.Group;
import com.example.pasir_baranski_szymon.model.Membership;
import com.example.pasir_baranski_szymon.model.User;
import com.example.pasir_baranski_szymon.repository.DebtRepository;
import com.example.pasir_baranski_szymon.repository.GroupRepository;
import com.example.pasir_baranski_szymon.repository.MembershipRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final MembershipRepository membershipRepository;
    private final MembershipService membershipService;
    private final DebtRepository debtRepository;

    public GroupService(GroupRepository groupRepository, MembershipRepository membershipRepository, MembershipService membershipService, DebtRepository debtRepository) {
        this.groupRepository = groupRepository;
        this.membershipRepository = membershipRepository;
        this.membershipService = membershipService;
        this.debtRepository = debtRepository;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @MutationMapping
    public Group createGroup(GroupDTO groupDTO) {
        User owner = membershipService.getCurrentUser();
        Group group = new Group();
        group.setName(groupDTO.getName());
        group.setOwner(owner);
        Group savedGroup = groupRepository.save(group);
        Membership membership = new Membership();
        membership.setUser(owner);
        membership.setGroup(savedGroup);
        membershipRepository.save(membership);
        return savedGroup;
    }

    public void deleteGroup(Long id) {
//        if (!groupRepository.existsById(id)) {
//            throw new EntityNotFoundException("Grupa o ID " + id + " nie istnieje.");
//        }
//        List<Debt> debts = debtRepository.findByGroupId(id);
//        debtRepository.deleteAll(debts);
//        groupRepository.deleteById(id);
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grupa o ID " + id + " nie istnieje."));
        debtRepository.deleteAll(debtRepository.findByGroupId(id));
        membershipRepository.deleteAll(membershipRepository.findByGroupId(id));

        groupRepository.delete(group);
    }
}
