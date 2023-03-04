package Idea.Archieve.IdeaArchieve.domain.notice.presentation;

import Idea.Archieve.IdeaArchieve.domain.notice.presentation.dto.request.WriteNoticeRequest;
import Idea.Archieve.IdeaArchieve.domain.notice.presentation.dto.response.ViewNoticeResponse;
import Idea.Archieve.IdeaArchieve.domain.notice.service.ViewNoticeService;
import Idea.Archieve.IdeaArchieve.domain.notice.service.WriteNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminNoticeController {

    private final WriteNoticeService writeNoticeService;
    private final ViewNoticeService viewNoticeService;

    @PostMapping("/write")
    public ResponseEntity<Void> writeNotice(@RequestBody @Valid WriteNoticeRequest writeNoticeRequest){
        writeNoticeService.execute(writeNoticeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ViewNoticeResponse>> viewNotice(){
        List<ViewNoticeResponse> viewNoticeResponses = viewNoticeService.execute();
        return ResponseEntity.ok(viewNoticeResponses);
    }

}
