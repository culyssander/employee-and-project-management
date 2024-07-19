package com.culysoft.usermodule.service;

import com.culysoft.usermodule.client.CompanyFeignClient;
import com.culysoft.usermodule.dto.UserDto;
import com.culysoft.usermodule.dto.UserRegister;
import com.culysoft.usermodule.dto.client.CompanyOutput;
import com.culysoft.usermodule.dto.client.CompanyRegister;
import com.culysoft.usermodule.exception.CompanyBadRequestException;
import com.culysoft.usermodule.exception.UserAlreadyExistsException;
import com.culysoft.usermodule.exception.UserBusinessException;
import com.culysoft.usermodule.exception.UserNotFoundException;
import com.culysoft.usermodule.models.Role;
import com.culysoft.usermodule.models.User;
import com.culysoft.usermodule.repository.RoleRepository;
import com.culysoft.usermodule.repository.UserRepository;
import com.culysoft.usermodule.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private CompanyFeignClient companyFeignClient;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;
    private JWTUtil jwtUtil;

    private static final String SUPER_ADMIN_USER_ROLE = "SUPER-ADMIN";
    private static final String ANONYMOUS = "ANONYMOUS";

    public List<User> findAll() {
        User loggedUser = loggedUser();
        return userRepository.findByCompanyId(loggedUser.getCompanyId());
    }

    public UserDto register (UserRegister userRegister) {

        if (userRepository.existsByEmail(userRegister.getEmail()))
            throw new UserAlreadyExistsException("User already exists");

        CompanyOutput company;

        try {
            CompanyRegister companyRegister = new CompanyRegister(userRegister.getCompanyName());
            company = companyFeignClient.registry(companyRegister, ANONYMOUS);
        } catch (CompanyBadRequestException e) {
            throw new CompanyBadRequestException(e.getMessage());
        }

        Role role = roleRepository.save(Role.builder()
                        .id(UUID.randomUUID().toString())
                        .name(SUPER_ADMIN_USER_ROLE)
                        .companyId(company.getId())
                        .build());

        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email(userRegister.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRegister.getPassword()))
                .status(true)
                .role(role)
                .companyId(company.getId())
                .createdAt(OffsetDateTime.now())
                .build();

        user = userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    public User loggedUser() throws UserBusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];
        String email = jwtUtil.extractUsername(token);
        return findByEmail("email");
    }
}
