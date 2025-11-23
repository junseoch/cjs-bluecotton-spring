package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import com.app.bluecotton.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery/*")
public class DeliveryApi {

    private final DeliveryService deliveryService;

    @PostMapping("save")
    public ResponseEntity<?> saveDelivery(@RequestBody DeliveryVO vo) {

        deliveryService.save(vo);

        return ResponseEntity.ok(
                Map.of("message", "배송 정보 저장 완료")
        );
    }

    @GetMapping("member/{memberId}")
    public ResponseEntity<List<DeliveryVO>> getMemberDeliveries(@PathVariable Long memberId) {
        List<DeliveryVO> list = deliveryService.findByMember(memberId);
        return ResponseEntity.ok(list);
    }
}
