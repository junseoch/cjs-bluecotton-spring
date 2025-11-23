package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.vo.shop.ProductImageVO;
import com.app.bluecotton.domain.vo.shop.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminProductMapper {

    public List<ProductVO> selectAllProducts();

    public ProductVO selectProductById(Long id);

    public void insertProduct(ProductVO productVO);

    public void updateProduct(ProductVO productVO);

    public void deleteProduct(Long id);

    public List<ProductImageVO> selectImagesByProductId(Long productId);

    public void insertProductImage(ProductImageVO imageVO);

    public void deleteImagesByProductId(Long productId);
}
