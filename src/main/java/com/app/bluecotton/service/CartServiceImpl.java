package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.CartResponseDTO;
import com.app.bluecotton.domain.vo.shop.CartVO;
import com.app.bluecotton.repository.CartDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;



    @Override
    public void addCart(CartVO cartVO) {
        Long memberId = cartVO.getMemberId();
        Long productId = cartVO.getProductId();


        Optional<CartVO> currentQuantities = cartDAO.selectQuantity(memberId, productId);

        //장바구니에 해당 상품이 있는지 없는지 확인
        currentQuantities.ifPresentOrElse( product-> {
            // 상품이 중복이 될 때
            cartDAO.increaseProduct(cartVO);
        }, () -> {
            //새로운 상품을 추가하는 경우
                cartDAO.add(cartVO);
            }
        );
    }

    public CartVO updateMinusCart(CartVO cartVO) {
        Long memberId = cartVO.getMemberId();
        Long productId = cartVO.getProductId();

        CartVO product = cartDAO.selectQuantity(memberId, productId)
                .orElseThrow(() -> new IllegalArgumentException("장바구니에 해당 상품이 존재하지 않습니다."));

        // 2. 수량 검증
        if (product.getQuantity() == 1) {
            throw new IllegalArgumentException("해당 상품의 수량을 더이상 줄일 수 없습니다.");
        }

        // 3. 수량 감소 실행
        if (product.getQuantity() > 1) {
            cartVO.setQuantity(1);
            cartDAO.decreaseProduct(cartVO);
        }
        return cartDAO.selectQuantity(memberId, productId)
                .orElseThrow(() -> new IllegalStateException("장바구니 업데이트 후 조회에 실패했습니다."));
    }
    @Override
    public void updatePlusCart(CartVO cartVO) {
        cartDAO.increaseProduct(cartVO);
    }

    @Override
    public void deleteCart(Long memberId, Long productId) {
        cartDAO.deleteProduct(memberId, productId);
    }

    @Override
    public List<CartResponseDTO> getCartList(Long memberId) {
        return cartDAO.selectAllCart(memberId);
    }

    @Override
    public Optional<CartVO> selectCartQuantity(Long memberId, Long productId) {
        return cartDAO.selectQuantity(memberId, productId);
    }
}
