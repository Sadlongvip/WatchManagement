package com.mss301.brand.controller;

import com.mss301.brand.dto.ApiResponse;
import com.mss301.brand.dto.BrandResponse;
import com.mss301.brand.dto.BrandWatchesResponse;
import com.mss301.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// [TODO-5.5: API public /api/brands, /{id}, /{id}/watches]
@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BrandResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(brandService.findAll(), "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BrandResponse>> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.success(brandService.findById(id), "Success"));
    }

    @GetMapping("/{id}/watches")
    public ResponseEntity<ApiResponse<BrandWatchesResponse>> watches(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.success(brandService.watchesOf(id), "Success"));
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> exists(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.existsById(id));
    }
}