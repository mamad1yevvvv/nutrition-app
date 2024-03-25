package com.example.nutritionapp.user;

import com.example.nutritionapp.email.EmailCodeRepository;
import com.example.nutritionapp.email.EmailCodeService;
import com.example.nutritionapp.email.OTPRepository;
import com.example.nutritionapp.email.entity.OTP;
import com.example.nutritionapp.exception.EmailAlreadyExistException;
import com.example.nutritionapp.exception.InvalidEmailAddressException;
import com.example.nutritionapp.exception.PasswordNotMatchException;
import com.example.nutritionapp.user.dto.*;
import com.example.nutritionapp.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Getter
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailCodeRepository emailRepository;
    private final EmailCodeService emailService;
    private final OTPRepository otpRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findUserByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));
    }
    

    public UserResponseDto signIn(UserSignInDto signInDto) {
        String password = signInDto.getPassword();
        User user = repository
                .findUserByEmail(signInDto.getEmail())
                .orElseThrow(
                        () -> new BadCredentialsException("Email or password incorrect")
                );

        if( !passwordEncoder.matches( password, user.getPassword() ) )
        {
            throw new BadCredentialsException( "Email or password doesn't match" );
        }
        return modelMapper.map(user , UserResponseDto.class);
    }
    @Transactional
    public UserResponseDto signUp(UserCreateDto userCreateDto) {
        String password = userCreateDto.getPassword();
        String confirmPassword = userCreateDto.getConfirmPassword();
        String email = userCreateDto.getEmail();

        if (!emailService.isValid(userCreateDto.getEmail())){
            throw new InvalidEmailAddressException("%s is not valid ".formatted(email));
        }
        if (repository.findUserByEmail(email).isPresent()){
            throw new EmailAlreadyExistException("User with email %s already exist".formatted(email));
        }
        if (!password.equals(confirmPassword)){
            throw new PasswordNotMatchException("Password and confirm password not matched!");
        }

        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        emailService.sendEmail(email);

        OTP otp = modelMapper.map(userCreateDto, OTP.class);
        otpRepository.save(otp);

        return modelMapper.map(userCreateDto, UserResponseDto.class);
    }
    @Transactional
    public void forgotPassword(String email) {
        repository
                .findUserByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Email not found"));
        emailService.sendEmail(email);
    }


    public UserResponseDto forgotPasswordNewPassword(ForgotPasswordDto forgotPasswordDto) {
        String password = forgotPasswordDto.getPassword();
        String confirmPassword = forgotPasswordDto.getConfirmPassword();
        String email = forgotPasswordDto.getEmail();

        if (!password.equals(confirmPassword)){
            throw new PasswordNotMatchException("Password and confirm password not matched!");
        }

        User user = repository.findUserByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("User not found"));

        user.setPassword(passwordEncoder.encode(forgotPasswordDto.getPassword()));

        repository.save(user);

        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto updateUser(UserPatchDto updateDto, Long id) {

        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        user.setName(updateDto.getName());

        User saved = repository.save(user);

        return getModelMapper().map(saved , UserResponseDto.class);
    }
}
