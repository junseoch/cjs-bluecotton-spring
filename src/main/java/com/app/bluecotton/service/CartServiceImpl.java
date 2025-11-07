package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.CartResponseDTO;
import com.app.bluecotton.domain.vo.shop.CartVO;
import com.app.bluecotton.repository.CartDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;

    @Override
    public void addCart(CartVO cartVO) {
        Long memberId = cartVO.getMemberId();
        Long productId = cartVO.getProductId();

        // 같은 상품 있으면 +1, 없으면 새로 추가(초기 1)
        boolean exists = cartDAO.selectQuantity(memberId, productId).isPresent();
        if (exists) {
            CartVO inc = new CartVO();
            inc.setMemberId(memberId);
            inc.setProductId(productId);
            inc.setQuantity(1); // ★ 중복 추가는 무조건 +1
            int rows = cartDAO.increaseProduct(inc);
            if (rows == 0) {
                // 동시성/조건 문제 대비: 없다고 나오면 삽입 리트라이
                cartDAO.add(defaultOne(memberId, productId));
            }
        } else {
            // 새 추가 시 수량 미지정이면 1로
            if (cartVO.getQuantity() <= 0) cartVO.setQuantity(1);
            cartDAO.add(cartVO);
        }
    }

    @Override
    public void updatePlusCart(CartVO cartVO) {

    }

    @Override
    public CartVO updateMinusCart(CartVO cartVO) {
        Long memberId = cartVO.getMemberId();
        Long productId = cartVO.getProductId();

        int current = cartDAO.selectQuantity(memberId, productId)
                .orElseThrow(() -> new IllegalArgumentException("장바구니에 해당 상품이 존재하지 않습니다."));

        if (current <= 1) {
            throw new IllegalArgumentException("해당 상품의 수량을 더 이상 줄일 수 없습니다.");
        }

        if (cartVO.getQuantity() <= 0) cartVO.setQuantity(1);

        int rows = cartDAO.decreaseProduct(cartVO);
        if (rows == 0) {
            throw new IllegalStateException("수량 감소가 반영되지 않았습니다. (조건 또는 매퍼 연결 확인 필요)");
        }

        int updated = cartDAO.selectQuantity(memberId, productId)
                .orElseThrow(() -> new IllegalStateException("장바구니 업데이트 후 조회에 실패했습니다."));

        CartVO result = new CartVO();
        result.setMemberId(memberId);
        result.setProductId(productId);
        result.setQuantity(updated);
        return result;
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
        return cartDAO.selectQuantity(memberId, productId)
                .map(q -> {
                    CartVO vo = new CartVO();
                    vo.setMemberId(memberId);
                    vo.setProductId(productId);
                    vo.setQuantity(q);
                    return vo;
                });
    }

    private CartVO defaultOne(Long memberId, Long productId) {
        CartVO vo = new CartVO();
        vo.setMemberId(memberId);
        vo.setProductId(productId);
        vo.setQuantity(1);
        return vo;
    }
}

