package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {

    // 메인 페이지 상품 조건 조회
    public List<ProductListResponseDTO> selectProductsByFilter(Map<String,Object> filterParams);


    // 상세 페이지 상품 상단 조회
    public ProductDetailResponseDTO selectProductDetailHeader(Long id);

    // 상세 페이지 상품 정보 조회
    public ProductInfoDetailResponseDTO selectProductDetailInfo(Long id);

    // 상세 페이지 "상품 리뷰" 조회
    public List<ProductReviewDetailResponseDTO> selectProductReviewDetail(Map<String,Object> reviewParams);

    // 상세 페이지 "리뷰 평점" 조회
    public ProductReviewStatsResponseDTO selectProductReviewStats(Long id);

    // 마이페이지(샵) 찜한 상품 조회
    public List<ProductListResponseDTO> selectMyLikedProducts(Long memberId);

    // 마이페이지(샵) 찜한 상품 삭제
    // 매개변수 여러개 일때는 이름 지정해야함
    public void deleteMyLikedProduct(@Param("memberId") Long memberId , @Param("productId") Long productId);

    // 마이페이지(샵) 마이리뷰 조회
    public List<MyReviewListDTO> selectMyReview(@Param("memberId") Long memberId);

    // 마이페이지(샵) 마이리뷰 수정


}
