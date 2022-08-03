//package com.wil.web;
//
//import com.wil.config.google.LoginUser;
//import com.wil.config.google.dto.SessionUser;
//import com.wil.service.posts.PostsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpSession;
//
//@RequiredArgsConstructor
//@Controller
//public class IndexController {
//
//    private final PostsService postsService;
//    private final HttpSession httpSession;
//
//    @GetMapping("/")
//    public String index(Model model, @LoginUser SessionUser user){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Access-Control-Allow-Origin", "*");
//        ResponseEntity<String> response = new ResponseEntity<String>("hello",headers, HttpStatus.OK);
//
//        if(user != null) {
//            model.addAttribute("userName", user.getName());
//            model.addAttribute("userImg", user.getPicture());
//        }
//        return "index";
//    }
//}
