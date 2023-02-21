package Idea.Archieve.IdeaArchieve.domain.comment.presentation;

import Idea.Archieve.IdeaArchieve.domain.comment.presentation.dto.request.ModifyCommentRequest;
import Idea.Archieve.IdeaArchieve.domain.comment.presentation.dto.request.WriteCommentRequest;
import Idea.Archieve.IdeaArchieve.domain.comment.service.DeleteCommentService;
import Idea.Archieve.IdeaArchieve.domain.comment.service.ModifyCommentService;
import Idea.Archieve.IdeaArchieve.domain.comment.service.WriteCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class CommentController {

    private final WriteCommentService writeCommentService;
    private final ModifyCommentService modifyCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping("/comment/{postId}")
    public ResponseEntity<Void> writeComment(@PathVariable Long postId, @RequestBody @Valid WriteCommentRequest request) {
        writeCommentService.execute(postId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/comment/{commentId}")
    public ResponseEntity<Void> modifyComment(@PathVariable Long commentId, @RequestBody @Valid ModifyCommentRequest request) {
        modifyCommentService.execute(commentId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<Void> DeleteComment(@PathVariable Long commentId) {
        deleteCommentService.execute(commentId);
        return ResponseEntity.ok().build();
    }

}
