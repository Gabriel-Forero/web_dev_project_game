package com.javeriana.Game.service;
import com.javeriana.Game.dto.PriceDTO;
import com.javeriana.Game.dto.mappers.MapperPriceDTO;
import com.javeriana.Game.model.*;
import com.javeriana.Game.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepo;

    public PriceService(PriceRepository priceRepo) {
        this.priceRepo = priceRepo;
    }

    public Price addPrice(Price price) {
        return priceRepo.save(price);
    }

    public List<Price> findAllPrices() {
        return (List<Price>) priceRepo.findAll();
    }

    public Price updatePrice(Price price) {
        return priceRepo.save(price);
    }

    public void deletePrice(Long id) {
        priceRepo.deleteById(id);
    }

    public PriceDTO findByPlanetAndAsset(Planet planet, Asset asset) {
        final MapperPriceDTO mapper = new MapperPriceDTO();
        return mapper.mapperToPriceDTO(priceRepo.findByPlanetAndAsset(planet.getPlanetId(),asset.getAssetId()));
    }

    public Price findByPlanetAndAssetReturn(Planet planet, Asset asset) {
        return priceRepo.findByPlanetAndAsset(planet.getPlanetId(),asset.getAssetId());
    }

    public PriceDTO findByPriceId(Long priceId) {
        final MapperPriceDTO mapper = new MapperPriceDTO();
        return mapper.mapperToPriceDTO(priceRepo.findByPriceId(priceId));
    }

    public Price findByPriceIdReturnPrice(Long priceId) {
        return priceRepo.findByPriceId(priceId);
    }

    public List<PriceDTO> findAllByPlanet(Long planetId) {
        final MapperPriceDTO mapper = new MapperPriceDTO();
        List<Price> assets = priceRepo.findAllByPlanet(planetId);
        List<PriceDTO> assetsDTOs= new ArrayList<>();
        for(Price p: assets){
            assetsDTOs.add(mapper.mapperToPriceDTO(p));
        }
        return assetsDTOs;
    }





}
