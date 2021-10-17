package com.javeriana.Game.service;
import java.util.List;

import com.javeriana.Game.exceptions.AssetNotFoundException;
import com.javeriana.Game.exceptions.UserNotFoundException;
import com.javeriana.Game.model.Asset;
import com.javeriana.Game.model.User;
import com.javeriana.Game.repository.AssetRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    private final AssetRepository assetRepo;

    public  AssetService(AssetRepository assetRepo) {
        this.assetRepo=assetRepo;
    }

    public Asset addAsset(Asset asset) {
        return assetRepo.save(asset);
    }

    public Asset updateAsset(Asset asset) {
        return assetRepo.save(asset);
    }

    public List<Asset> findAllAssets() {
        return assetRepo.findAll();
    }

    public Asset findAssetById(Long id) {
        return assetRepo.findById(id).orElseThrow(() -> new AssetNotFoundException("Asset not by id: " + id +" not found"));
    }

}
