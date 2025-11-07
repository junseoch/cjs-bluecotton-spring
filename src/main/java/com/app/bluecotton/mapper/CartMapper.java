package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.CartResponseDTO;
import com.app.bluecotton.domain.vo.shop.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CartMapper {

    void insert(CartVO cartVO);

    List<CartResponseDTO> selectByMemberId(@Param("memberId") Long memberId);

    // int 또는 Integer로 수량만 받도록 변경
    Optional<Integer> selectQuantity(@Param("memberId") Long memberId,
                                     @Param("productId") Long productId);

    public void updatePlus(CartVO cartVO);

    int updateMinus(CartVO cartVO);

    public void delete(@Param("memberId") Long memberId, @Param("productId") Long productId);
}

