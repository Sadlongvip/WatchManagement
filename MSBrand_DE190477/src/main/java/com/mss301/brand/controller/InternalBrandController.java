package com.mss301.brand.controller;

import com.mss301.brand.dto.ApiResponse;
import com.mss301.brand.dto.AssignmentResponse;
import com.mss301.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// [TODO-5.4: API nội bộ /internal/brands/** cho Saga]
@RestController
@RequestMapping("/internal/brands")
@RequiredArgsConstructor
public class InternalBrandController {

    private final BrandService brandService;

    @PutMapping("/{brandId}/watches/{watchId}")
    public ResponseEntity<ApiResponse<AssignmentResponse>> assign(@PathVariable Integer brandId,
                                                                  @PathVariable Integer watchId) {
        return ResponseEntity.ok(ApiResponse.success(brandService.assignWatch(brandId, watchId), "Assigned"));
    }

    @DeleteMapping("/watches/{watchId}")
    public ResponseEntity<ApiResponse<AssignmentResponse>> unassign(@PathVariable Integer watchId) {
        return ResponseEntity.ok(ApiResponse.success(brandService.unassignWatch(watchId), "Unassigned"));
    }
}