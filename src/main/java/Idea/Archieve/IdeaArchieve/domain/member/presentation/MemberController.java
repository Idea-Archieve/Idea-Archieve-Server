package Idea.Archieve.IdeaArchieve.domain.member.presentation;


import Idea.Archieve.IdeaArchieve.domain.member.presentation.dto.request.ChangePasswordRequest;
import Idea.Archieve.IdeaArchieve.domain.member.presentation.dto.response.MyPageResponse;
import Idea.Archieve.IdeaArchieve.domain.member.presentation.dto.response.MyPostResponse;
import Idea.Archieve.IdeaArchieve.domain.member.service.ChangePasswordService;
import Idea.Archieve.IdeaArchieve.domain.member.service.MyPageService;
import Idea.Archieve.IdeaArchieve.domain.member.service.ViewMyPostService;
import Idea.Archieve.IdeaArchieve.domain.member.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final ChangePasswordService changePasswordService;
    private final MyPageService myPageService;
    private final WithdrawService withdrawService;
    private final ViewMyPostService viewMyPostService;

    @PatchMapping
    public ResponseEntity<Void> editPassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest){
        changePasswordService.execute(changePasswordRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<MyPageResponse> viewMyPage(){
        MyPageResponse myPageResponse = myPageService.execute();
        return ResponseEntity.ok().body(myPageResponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> withdraw(@RequestParam String email,@RequestParam String password){
        withdrawService.execute(email,password);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/myPost")
    public ResponseEntity<List<MyPostResponse>> viewMyPost(){
        List<MyPostResponse> myPostResponses = viewMyPostService.execute();
        return ResponseEntity.ok().body(myPostResponses);
    }
}
