//package com.groupe4.projet_avis.securityconfiguration;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.AllArgsConstructor;
//
//@RestController
//@RequestMapping(path = "api/registration", name = "app_")
//@AllArgsConstructor
//public class RegistrationController {
//    private final RegistrationService registrationService;
//
//    @PostMapping(name = "user_create")
//    public String register(@RequestBody RegistrationDto request) {
//        return registrationService.register(request);
//    }
//
//    @GetMapping(path = "confirm", name = "token_confirm")
//    public String confirm(@RequestParam("token") String token) {
//        return registrationService.confirmToken(token);
//    }
//}