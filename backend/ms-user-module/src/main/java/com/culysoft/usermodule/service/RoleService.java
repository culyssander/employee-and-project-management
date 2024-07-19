package com.culysoft.usermodule.service;

import com.culysoft.usermodule.dto.RoleDto;
import com.culysoft.usermodule.models.Role;
import com.culysoft.usermodule.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;
    private UserService userService;
    private ModelMapper modelMapper;


    public List<RoleDto> findAll() {
        return roleRepository.findByCompanyId(userService.loggedUser().getCompanyId())
                .stream().map(role -> RoleDto.builder().id(role.getId()).name(role.getName()).build()).toList();
    }

    public RoleDto save(RoleDto roleDto) {
        Role role = Role.builder()
                .id(roleDto.getId() == null ? UUID.randomUUID().toString() : roleDto.getId())
                .name(roleDto.getName())
                .companyId(userService.loggedUser().getCompanyId())
                .build();

        role = roleRepository.save(role);

        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role firstRegister(Role role) {
        return roleRepository.save(role);
    }
}
