package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.shop.ProductImageVO;
import com.app.bluecotton.domain.vo.shop.ProductVO;

import java.util.List;
import java.util.Optional;

public interface AdminProductService {

    public Long createProduct(ProductVO productVO, List<ProductImageVO> images);

    public List<ProductVO> getProducts();

    public Optional<ProductVO> getProduct(Long id);

    public List<ProductImageVO> getProductImages(Long productId);

    public void updateProduct(ProductVO productVO, List<ProductImageVO> images);

    public void deleteProduct(Long id);
}
