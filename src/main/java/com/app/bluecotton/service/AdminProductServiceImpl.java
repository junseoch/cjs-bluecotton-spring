package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.shop.ProductImageVO;
import com.app.bluecotton.domain.vo.shop.ProductVO;
import com.app.bluecotton.repository.AdminProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {
    private final AdminProductDAO adminProductDAO;

    @Override
    public Long createProduct(ProductVO productVO, List<ProductImageVO> images) {
        adminProductDAO.save(productVO);

        if (images != null) {
            for (ProductImageVO image : images) {
                image.setProductId(productVO.getId());
                adminProductDAO.saveImage(image);
            }
        }

        return productVO.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductVO> getProducts() {
        return adminProductDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductVO> getProduct(Long id) {
        return adminProductDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductImageVO> getProductImages(Long productId) {
        if (productId == null) return Collections.emptyList();
        return adminProductDAO.findImagesByProductId(productId);
    }

    @Override
    public void updateProduct(ProductVO productVO, List<ProductImageVO> images) {
        adminProductDAO.update(productVO);

        adminProductDAO.deleteImagesByProductId(productVO.getId());

        if (images != null) {
            for (ProductImageVO image : images) {
                image.setProductId(productVO.getId());
                adminProductDAO.saveImage(image);
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        adminProductDAO.deleteImagesByProductId(id);
        adminProductDAO.delete(id);
    }
}
