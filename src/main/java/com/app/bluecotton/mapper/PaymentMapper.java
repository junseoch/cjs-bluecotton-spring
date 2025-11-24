package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.MyShopOrderDTO;
import com.app.bluecotton.domain.vo.shop.PaymentStatus;
import com.app.bluecotton.domain.vo.shop.PaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface PaymentMapper {

    public  void insert(PaymentVO paymentVO);

    public Optional<PaymentVO> selectById(@Param("id") long id);

    public List<PaymentVO> selectByOrderId(@Param("orderId") Long orderId);

    public void updateStatus(PaymentVO paymentVO);

    public void delete(@Param("id") Long id);

    public Optional<PaymentVO> selectByMerchantUid(@Param("merchantUid") String merchantUid);

    public Long selectExpectedAmountByMerchantUid(@Param("merchantUid") String merchantUid);

    public int updateStatusByMerchantUid(@Param("merchantUid") String merchantUid,
                                  @Param("status") PaymentStatus status);

    public int markSuccessByMerchantUid(@Param("merchantUid") String merchantUid,
                                 @Param("impUid") String impUid,
                                 @Param("paidAmount") long paidAmount,
                                 @Param("status") PaymentStatus status);

    public int selectMemberCandy(@Param("memberId") Long memberId);

    public List<Map<String, Object>> selectByMemberIdCandy(@Param("memberId") Long memberId);

    public int selectTotalCandySpentByMemberId(@Param("memberId") Long memberId);

    public int updateMemberCandy(@Param("memberId") Long memberId,
                          @Param("amount") int amount);

    public List<MyShopOrderDTO> selectCompletedOrdersByMemberId(@Param("memberId") Long memberId);
}
