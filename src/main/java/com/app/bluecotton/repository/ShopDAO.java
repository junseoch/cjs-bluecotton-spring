package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.*;
import com.app.bluecotton.mapper.ShopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ShopDAO {

    private final ShopMapper shopMapper;

    // 메인 페이지 상품 조건 조회
    public List<ProductListResponseDTO> findProductsByFilter(Map<String,Object> filterParams) {
        return shopMapper.selectProductsByFilter(filterParams);
    }

    // 상세 페이지 상단 조회
    public ProductDetailResponseDTO findProductDetailHeader(Long id){
        return shopMapper.selectProductDetailHeader(id);
    }

    // 상세 페이지 상품 정보 조회
    public ProductInfoDetailResponseDTO findProductDetailInfo(Long id){
        return shopMapper.selectProductDetailInfo(id);
    }

    // 상세 페이지 "상품 리뷰" 조회
    public List<ProductReviewDetailResponseDTO> findProductReviewDetail(Map<String,Object> reviewParams){
        return shopMapper.selectProductReviewDetail(reviewParams);
    }

    // 상세 페이지 "리뷰 평점" 조회
    public ProductReviewStatsResponseDTO findProductReviewStats(Long id){
        return shopMapper.selectProductReviewStats(id);
    }

    // 마이페이지(샵) 찜한 상품 조회
    public List<ProductListResponseDTO> findLikedProducts(Long memberId){
        return shopMapper.selectMyLikedProducts(memberId);
    }

    // 마이페이지(샵) 찜한 상품 삭제
    public void deleteLikedProduct(Long memberId, Long productId){
        shopMapper.deleteMyLikedProduct(memberId, productId);
    }


    // 마이페이지(샵) 마이리뷰 조회
    public List<MyReviewListDTO> findMyReviews(Long id){
        return shopMapper.selectMyReview(id);
    }


}
