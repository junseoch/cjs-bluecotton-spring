package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.*;

import java.util.List;
import java.util.Map;

public interface ShopService {

    // 상품 조건 조회
    public List<ProductListResponseDTO> getProductByFilter(Map<String,Object> filterParams);

    // 상세 페이지 상단 조회
    public ProductDetailResponseDTO getProductDetailHeader(Long id);

    // 상세 페이지 상품 정보 조회
    public ProductInfoDetailResponseDTO getProductDetailInfo(Long id);

    // 상세 페이지 "상품 리뷰" 조회
    public List<ProductReviewDetailResponseDTO> getProductReviewDetail(Map<String,Object> reviewParams);

    // 상세 페이지 "리뷰 평점" 조회
    public ProductReviewStatsResponseDTO getProductReviewStats(Long id);

    // 마이페이지(샵) 찜한 상품 조회
    public List<ProductListResponseDTO> getLikedProducts(Long memberId);

    // 마이페이지(샵) 찜한 상품 삭제
    public void unLikeProduct(Long memberId, Long productId);

    // 마이페이지(샵) 마이리뷰 조회
    public List<MyReviewListDTO> getMyReviews(Long id);

}
