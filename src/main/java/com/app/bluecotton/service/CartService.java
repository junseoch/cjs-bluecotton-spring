package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.CartResponseDTO;
import com.app.bluecotton.domain.vo.shop.CartVO;

import java.util.List;
import java.util.Optional;

public interface CartService {

    public void addCart(CartVO cartVO);
    public void deleteCart( Long memberId, Long productId);
    public void updatePlusCart(CartVO cartVO);
    public CartVO updateMinusCart(CartVO cartVO);
    public List<CartResponseDTO> getCartList(Long memberId);
    public Optional<CartVO> selectCartQuantity(Long memberId, Long productId);
}
