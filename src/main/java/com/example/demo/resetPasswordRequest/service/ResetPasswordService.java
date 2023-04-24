package com.example.demo.resetPasswordRequest.service;
import com.example.demo.login.repository.UserRepository;
import com.example.demo.model.ResetPasswordRequest;
import com.example.demo.model.User;
import com.example.demo.resetPasswordRequest.exception.ResetPasswordException;
import com.example.demo.resetPasswordRequest.repository.ResetPasswordRequestRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Service
public class ResetPasswordService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResetPasswordRequestRepository passwordRequestRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    public void saveRequest(String email) throws ResetPasswordException, MessagingException {
        Optional<User> user=userRepository.findByEmail(email);
        if(user.isEmpty())
        {
            throw new ResetPasswordException("The email does not exist");
        }
        else {
            ResetPasswordRequest passwordRequest = new ResetPasswordRequest();
            passwordRequest.setUser(user.get());
            String dateTime=LocalDateTime.now().toString();
            UUID requestId=UUID.nameUUIDFromBytes((user.get().getEmail()+dateTime).getBytes());
            passwordRequest.setRequestId(requestId);
            passwordRequestRepository.save(passwordRequest);
            String link="http://localhost:8090/user/reset-password?requestId="+requestId;
            String text="<p>Pentru resetarea parolei,va rugam sa accesati acest <a href=\"" + link + "\">" + "link" + "</a>.</p>";
            emailSenderService.sendEmail(email,"Reset Password",text);
        }
    }
}
