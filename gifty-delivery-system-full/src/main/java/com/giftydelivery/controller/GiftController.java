package com.giftydelivery.controller;

import com.giftydelivery.model.Gift;
import com.giftydelivery.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService;

    // ✅ Add new gift
    @PostMapping
    public Gift addGift(@RequestBody Gift gift) {
        return giftService.addGift(gift); // ✅ matches method name in service
    }

    // ✅ Get all gifts
    @GetMapping
    public List<Gift> getAllGifts() {
        return giftService.getAllGifts();
    }

    // (Optional) Get gift by ID
    @GetMapping("/{id}")
    public Gift getGiftById(@PathVariable Long id) {
        return giftService.getGiftById(id);
    }

    // (Optional) Update gift
    @PutMapping("/{id}")
    public Gift updateGift(@PathVariable Long id, @RequestBody Gift gift) {
        return giftService.updateGift(id, gift);
    }

    // (Optional) Delete gift
    @DeleteMapping("/{id}")
    public void deleteGift(@PathVariable Long id) {
        giftService.deleteGift(id);
    }
}
