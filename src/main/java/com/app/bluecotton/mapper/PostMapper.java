package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.post.PostMainDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper

public interface PostMapper {
    List<PostMainDTO> select(
            @Param("somCategory") String somCategory,
            @Param("orderType") String orderType,
            @Param("memberId") Long memberId
    );
}
