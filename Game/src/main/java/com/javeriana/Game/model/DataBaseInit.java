package com.javeriana.Game.model;


import java.util.NoSuchElementException;
import java.util.Random;

import javax.transaction.Transactional;

import com.javeriana.Game.model.User.UserRoles;
import com.javeriana.Game.repository.AssetRepository;
import com.javeriana.Game.repository.AssetsByTeamRepository;
import com.javeriana.Game.repository.PlanetRepository;
import com.javeriana.Game.repository.PriceRepository;
import com.javeriana.Game.repository.ShipRepository;
import com.javeriana.Game.repository.StarRepository;
import com.javeriana.Game.repository.TeamRepository;
import com.javeriana.Game.repository.UserRepository;
import com.javeriana.Game.service.UserService;

import org.apache.commons.text.RandomStringGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements ApplicationRunner {




    // Repositorios
    @Autowired
    PriceRepository priceRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    StarRepository starRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    AssetsByTeamRepository assetsByTeamRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

       createShips();
        createTeams();
        int teamId=1;
        for(int i=0;i<10;i++)
        {
            createUser(teamId);
            teamId++;
        }
        createAsset();
        createAssetByTeam();
        createStar();
        int starId=1;
        for(int j=0;j<400;j++)
        {
            createPlanet(starId);
            starId++;
        }
       
        createPrice();
       
       
    }

 private void createTeams()
 {
    final int NUM_TEAMS = 10;
    Random random = new Random(1234);
    RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
            .usingRandom(random::nextInt).build();
    int cont = 1;
            for(int k=0;k<NUM_TEAMS;k++)
            {
        
                int id = random.nextInt(1000000);   
                String name = randomGen.generate(5, 10);
                int money = random.nextInt(1000000);  
                int time = random.nextInt(1000000);  
                int posX = random.nextInt(1000000);  
                int posY = random.nextInt(1000000);  
                int posZ = random.nextInt(1000000);  
                

                Team newTeam = new Team();
                newTeam.setTeamId((long) id);
                newTeam.setTeamName(name);
                newTeam.setTeamCurrentMoney((long)money);
                newTeam.setTeamTimeGame((long)time);
                newTeam.setTeamPositionX((long)posX);
                newTeam.setTeamPositionY((long)posY);
                newTeam.setTeamPositionZ((long)posZ);
            
                try {

                    Ship s = shipRepository.findById((long)cont)
                    .orElseThrow();
                    cont++;
                    // company.getEmployees().add(p);
                    newTeam.setShip(s);
                    teamRepository.save(newTeam);
                   
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
        
            }
        
 }
 private void createUser(int teamId)
{
    Random random = new Random(1234);
    RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
            .usingRandom(random::nextInt).build();

    for(int i=0;i<10;i++)
    {
        String name = randomGen.generate(5, 10);
        String document = randomGen.generate(5, 10);
        String password = randomGen.generate(5, 10);
        int id = random.nextInt(1000000);
        UserRoles m = UserRoles.MERCHANT;
        UserRoles p = UserRoles.PILOT;
        UserRoles c = UserRoles.CAPTAIN;
        User newUser = new User();
        newUser.setUserId((long) id);
        newUser.setUserDocument(document);
        newUser.setUserName(name);
        newUser.setUserPassword(password);
    
        if (i < 4) {
            newUser.setUserRole(m);   
        } else if (i < 8) {
            newUser.setUserRole(p);
        } else {
            newUser.setUserRole(c);
        }
        try {
           
            Team t = teamRepository.findById((long) teamId).orElseThrow();
            newUser.setTeam(t);
            userRepository.save(newUser);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
       
    }
    
    
            
    
        
}

private void createAsset()
{
    final int NUM_ASSET = 500;
    Random random = new Random(1234);
    RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
            .usingRandom(random::nextInt).build();
    for(int j=0; j<NUM_ASSET; j++){

        String name = randomGen.generate(5, 10);
        int id = random.nextInt(1000000);
        int volume = random.nextInt(1000000);
        Asset a = new Asset();
        a.setAssetName(name);
        a.setAssetId((long) id);
        a.setAssetVolume((long) volume);
        assetRepository.save(a);

    }
}

private void createShips()
{
    final int NUM_SHIPS = 20;
    Random random = new Random(1234);
    RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
            .usingRandom(random::nextInt).build();

    for(int j=0; j<NUM_SHIPS; j++)
    {
        String type = randomGen.generate(5, 10);
        int id = random.nextInt(1000000);
        int speed = random.nextInt(1000000);
        int volume = random.nextInt(1000000);
       
        
        Ship newShip = new Ship();
        newShip.setShipId((long) id);
        newShip.setShipType(type);
        newShip.setShipSpeed((long)speed);
        newShip.setShipVolume( (long)volume);
        shipRepository.save(newShip);

    }


}
private void createStar()
{
    final int NUM_STAR = 4000;
    Random random = new Random(1234);
    RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
            .usingRandom(random::nextInt).build();
    for (int j = 0; j < NUM_STAR; j++)
    {
        String name = randomGen.generate(5, 10);
        int id = random.nextInt(1000000);

        int posX = random.nextInt(1000000);  
        int posY = random.nextInt(1000000);  
        int posZ = random.nextInt(1000000);  

        Star s = new Star();
        s.setStarId((long) id);
        s.setStarName(name);
        s.setStarPositionX((long) posX);
        s.setStarPositionY((long) posY);
        s.setStarPositionZ((long) posZ);
        
        starRepository.save(s);
    }

    for(Star star:starRepository.findAll())
    {
        //Star s = starRepository.findById((long) random.nextInt(39999)+1 ).orElseThrow();
        //star.getConnectedStarFrom().add(s);
        //star.getConnectedStars().add(s);
        //s.getConnectedStarFrom().add(star);
        //s.getConnectedStars().add(star);
        //starRepository.save(star);
        //starRepository.save(s);
    }
}
private void createPlanet(int starId)
{
   
    Random random = new Random(1234);
    RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
            .usingRandom(random::nextInt).build();
    int NUM_PLANET = random.nextInt(2) +1;
    for (int j = 0; j < NUM_PLANET; j++)
    {
        String name = randomGen.generate(5, 10);
        int id = random.nextInt(1000000);
        Planet p = new Planet();
        p.setPlanetId((long) id);
        p.setPlanetName(name);
        Star s = starRepository.findById((long) starId).orElseThrow();
        p.setStar(s);
        planetRepository.save(p);
    }
}
private void createAssetByTeam()
{
    Random random = new Random(1234);
    final int ASSETS_PER_ABT_PER_TEAM = 4;
    final int ABT_PER_TEAM = 5;
            for (Team team : teamRepository.findAll()) {
                for (int j = 0; j < ASSETS_PER_ABT_PER_TEAM; j++) {
                    for (int i = 0; i < ABT_PER_TEAM; i++) {
                        try {
                            int id = random.nextInt(1000000);
                            int amount = random.nextInt(1000000);
                            
                            Asset a = assetRepository.findById((long)random.nextInt(499)+1)
                                    .orElseThrow();
                            // company.getEmployees().add(p);
                            AssetsByTeam ABT = new AssetsByTeam();
                            ABT.setAsset(a);
                            ABT.setTeam(team);
                            ABT.setAssetsByTeamId((long) id);
                            ABT.setAssetAmount(amount);

                            assetsByTeamRepository.save(ABT);
                            
                        } catch (NoSuchElementException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
}

private void createPrice()
{

    final int PLANET_PER_PRICE_PER_ASSET = 4;
    final int PRICE_PER_PLANET = 5;
    Random random = new Random(1234);
   

    for (Planet planet : planetRepository.findAll()) {
        for (int j = 0; j < PLANET_PER_PRICE_PER_ASSET; j++) {
            for (int i = 0; i < PRICE_PER_PLANET; i++) {
                try {
                    int id = random.nextInt(1000000);
                    int amount = random.nextInt(1000000);
                    int demandFactor= random.nextInt(1000000);
                    int supplyFactor= random.nextInt(1000000);
                    Asset a = assetRepository.findById((long)random.nextInt(499)+1)
                                    .orElseThrow();
                    Price newPrice = new Price();
                    newPrice.setPriceId((long) id);
                    newPrice.setDemandFactor((long) demandFactor);
                    newPrice.setAssetAmount(amount);
                    newPrice.setSupplyFactor((long) supplyFactor);
                    newPrice.setPlanet(planet);
                    newPrice.setAsset(a);
                    priceRepository.save(newPrice);
                    
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}




}



