package Idea.Archive.IdeaArchive.domain.post.service;

import Idea.Archive.IdeaArchive.domain.post.exception.NotExistPostException;
import Idea.Archive.IdeaArchive.domain.post.presentation.dto.response.ViewByCategoryResponse;
import Idea.Archive.IdeaArchive.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterPostService {

    private final PostRepository postRepository;


    public List<ViewByCategoryResponse> execute(String searchKeyword, String category) {
        List<ViewByCategoryResponse> posts;
        if(category.isEmpty()) {
            posts = postRepository.findByTitleContaining(searchKeyword);
        }else {
            posts = postRepository.findByTitleContainingAndCategory(searchKeyword, category);
        }
        if (posts.isEmpty()) {
            throw new NotExistPostException("게시글이 존재하지 않습니다.");
        }
        return posts;
    }
}
