package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.CartResponseDTO;
import com.app.bluecotton.domain.vo.shop.CartVO;
import com.app.bluecotton.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CartDAO {

    private final CartMapper cartMapper;

    //장바구니에 상품 추가
    public void add(CartVO  cartVO) {
        cartMapper.insert(cartVO);
    }

    // 상품 조회
    public List<CartResponseDTO> selectAllCart(Long  memberId) {
        return cartMapper.selectByMemberId(memberId);
    }

    public Optional<CartVO> selectQuantity(Long memberId, Long productId) {
        return cartMapper.selectQuantity(memberId, productId);
    }

    // 상품 추가
    public void increaseProduct(CartVO cartVO) {
        cartMapper.updatePlus(cartVO);
    }

    //상품 감소
    public void decreaseProduct(CartVO cartVO) {
        cartMapper.updateMinus(cartVO);
    }

    // 장바구니에서 상품 삭제
    public void deleteProduct(Long memberId, Long productId) {
        cartMapper.delete(memberId, productId);
    }


}
