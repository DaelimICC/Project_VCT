//package com.daelim.icc.vctserver.auth.controller
//
//import com.daelim.icc.vctserver.auth.dto.UserDTO
//import com.daelim.icc.vctserver.auth.repository.UserRepository
//import com.daelim.icc.vctserver.constdata.SHA256
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("user")
//class UserController {
//
//    @Autowired
//    private lateinit var repository: UserRepository;
//
//    private val sha256 = SHA256();
//
//    @PostMapping("")
//    fun registration(@RequestBody userdto: UserDTO): String {
//        userdto.userPwd = sha256.encrypt(userdto.userPwd);
//        val user = userdto.initUserRegistration();
//        repository.save(user);
//
//        return "success";
//    }
//
//    @GetMapping("")
//    fun login(): String {
//        return "success";
//    }
//}