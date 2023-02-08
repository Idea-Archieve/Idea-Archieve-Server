package Idea.Archieve.IdeaArchieve.domain.presentation;

import Idea.Archieve.IdeaArchieve.domain.Entity.Board;
import Idea.Archieve.IdeaArchieve.domain.presentation.dto.request.WriteBoard;
import Idea.Archieve.IdeaArchieve.domain.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("write")
    public void WriteBoard(WriteBoard writeBoard) {
        boardService.WriteBoard(writeBoard);
    }

    @GetMapping
    public List<Board> ViewBoard() {
        return boardService.ViewBoard();
    }

    @GetMapping("/{boardId}")
    public Board ViewBoardById(@PathVariable Long boardId) {
        return boardService.ViewBoardById(boardId);
    }
}
