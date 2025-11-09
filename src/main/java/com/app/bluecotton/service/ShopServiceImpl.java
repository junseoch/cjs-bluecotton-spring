package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.*;
import com.app.bluecotton.repository.ShopDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor

public class ShopServiceImpl implements ShopService {

    private final ShopDAO shopDAO;

    @Override
    public List<ProductListResponseDTO> getProductByFilter(Map<String, Object> filterParams) {
        return shopDAO.findProductsByFilter(filterParams);
    }

    @Override
    public ProductDetailResponseDTO getProductDetailHeader(Long id) {
        return shopDAO.findProductDetailHeader(id);
    }

    @Override
    public ProductInfoDetailResponseDTO getProductDetailInfo(Long id) {
        return shopDAO.findProductDetailInfo(id);
    }

    @Override
    public List<ProductReviewDetailResponseDTO> getProductReviewDetail(Map<String,Object> reviewParams) {
        return shopDAO.findProductReviewDetail(reviewParams);
    }

    @Override
    public ProductReviewStatsResponseDTO getProductReviewStats(Long id) {
        return shopDAO.findProductReviewStats(id);
    }

    @Override
    public List<ProductListResponseDTO> getLikedProducts(Long memberId) {
        return shopDAO.findLikedProducts(memberId);
    }

    @Override
    public void unLikeProduct(Long memberId, Long productId) {
        shopDAO.deleteLikedProduct(memberId, productId);
    }

    @Override
    public List<MyReviewListDTO> getMyReviews(Long id) {
        return shopDAO.findMyReviews(id);
    }


}
