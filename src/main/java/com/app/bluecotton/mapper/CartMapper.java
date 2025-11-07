package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.CartResponseDTO;
import com.app.bluecotton.domain.vo.shop.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CartMapper {

    //장바구니에 상품 담기
    public void insert(CartVO cartVO);

    //장바구니 목록
    public List<CartResponseDTO> selectByMemberId(@Param("memberId") Long memberId);

    //장바구니 상품 수량 조회
    public Optional<CartVO> selectQuantity(@Param("memberId") Long memberId, @Param("productId") Long productId);

    //장바구니 수량 수정(+)
    public void updatePlus(CartVO cartVO);

    //장바구니 수정(-)
    public void updateMinus(CartVO cartVO);

    //장바구니에 있는 상품 삭제
    public void delete(@Param("memberId") Long memberId, @Param("productId") Long productId);

}
