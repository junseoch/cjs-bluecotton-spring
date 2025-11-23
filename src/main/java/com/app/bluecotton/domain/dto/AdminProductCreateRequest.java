package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.shop.ProductImageVO;
import com.app.bluecotton.domain.vo.shop.ProductVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminProductCreateRequest {
    private ProductVO product;
    private List<ProductImageVO> images;
}
