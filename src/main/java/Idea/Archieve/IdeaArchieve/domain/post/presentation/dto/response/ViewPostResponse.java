package Idea.Archieve.IdeaArchieve.domain.post.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewPostResponse {

    private String title;
    private String content;
    private String category;
    private String name;
}
