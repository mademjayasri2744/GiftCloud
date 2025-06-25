package com.giftydelivery.service;

import com.giftydelivery.model.Gift;
import com.giftydelivery.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public Gift addGift(Gift gift) {
        return giftRepository.save(gift);
    }

    public List<Gift> getAllGifts() {
        return giftRepository.findAll();
    }

    public Gift getGiftById(Long id) {
        return giftRepository.findById(id).orElse(null);
    }

    public Gift updateGift(Long id, Gift gift) {
        Gift existingGift = giftRepository.findById(id).orElse(null);
        if (existingGift != null) {
            existingGift.setName(gift.getName());
            existingGift.setDescription(gift.getDescription());
            existingGift.setPrice(gift.getPrice());
            existingGift.setImageUrl(gift.getImageUrl());
            return giftRepository.save(existingGift);
        }
        return null;
    }

    public void deleteGift(Long id) {
        giftRepository.deleteById(id);
    }
}
