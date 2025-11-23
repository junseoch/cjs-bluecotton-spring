package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.shop.ProductCategory;
import com.app.bluecotton.domain.vo.shop.ProductPurchaseType;
import com.app.bluecotton.domain.vo.shop.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductListDTO {
    private Long id;
    private String productName;
    private Integer productPrice;
    private ProductCategory productCategory;
    private ProductType productType;
    private ProductPurchaseType productPurchaseType;
    private String mainImageUrl;
}
