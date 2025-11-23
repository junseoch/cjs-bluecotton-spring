package com.app.bluecotton.repository;

import com.app.bluecotton.domain.vo.shop.ProductImageVO;
import com.app.bluecotton.domain.vo.shop.ProductVO;
import com.app.bluecotton.mapper.AdminProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminProductDAO {
    private final AdminProductMapper adminProductMapper;

    public List<ProductVO> findAll() {
        return adminProductMapper.selectAllProducts();
    }

    public Optional<ProductVO> findById(Long id) {
        return Optional.ofNullable(adminProductMapper.selectProductById(id));
    }

    public void save(ProductVO productVO) {
        adminProductMapper.insertProduct(productVO);
    }

    public void update(ProductVO productVO) {
        adminProductMapper.updateProduct(productVO);
    }

    public void delete(Long id) {
        adminProductMapper.deleteProduct(id);
    }

    public List<ProductImageVO> findImagesByProductId(Long productId) {
        return adminProductMapper.selectImagesByProductId(productId);
    }

    public void saveImage(ProductImageVO imageVO) {
        adminProductMapper.insertProductImage(imageVO);
    }

    public void deleteImagesByProductId(Long productId) {
        adminProductMapper.deleteImagesByProductId(productId);
    }
}
