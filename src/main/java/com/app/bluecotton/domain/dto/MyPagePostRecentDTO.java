package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.member.MemberVO;
import com.app.bluecotton.domain.vo.post.PostRecentVO;
import com.app.bluecotton.domain.vo.post.PostVO;
import com.app.bluecotton.domain.vo.som.SomVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPagePostRecentDTO {
//    SELECT TBPR.ID, TBPR.POST_RECENT_CREATE_AT, TBP.POST_TITLE, TBS.SOM_CATEGORY
    private Long id;
    private String postTitle;
    private String somCategory;
    private Date postRecentCreateAt;
    private Long postId;

    public MyPagePostRecentDTO(PostRecentVO postRecentVO, PostVO postVO, SomVO somVO, MemberVO memberVO){
        this.id = postRecentVO.getId();
        this.postTitle = postVO.getPostTitle();
        this.somCategory = somVO.getSomCategory();
        this.postRecentCreateAt = postRecentVO.getPostRecentCreateAt();
        this.postId = postRecentVO.getPostId();
    }
}
