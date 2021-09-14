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
import com.javeriana.Game.service.ShipService;
import com.javeriana.Game.service.UserService;

import org.apache.commons.text.RandomStringGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements ApplicationRunner {

    private static final Team NULL = null;
    private static final Planet NULLP = null;
    private static final Star NULLS = null;


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
        createPrice();
       
       
    }

 private void createTeams()
 {
    final int NUM_TEAMS = 10;
  
    final int NUM_ASSET = 500;
    final int NUM_STAR = 40000;
    final int NUM_SHIPS = 20;
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

private void createPrice()
{
    final int NUM_PRICES = 1200;
    Random random = new Random(1234);
    for(int j=0; j<NUM_PRICES; j++)
    {
        int id = random.nextInt(1000000);
        int amount = random.nextInt(1000000);
        int demandFactor= random.nextInt(1000000);
        int supplyFactor= random.nextInt(1000000);
        
        Price newPrice = new Price();
        newPrice.setPriceId((long) id);
        newPrice.setDemandFactor((long) demandFactor);
        newPrice.setAssetAmount(amount);
        newPrice.setSupplyFactor((long) supplyFactor);
        priceRepository.save(newPrice);

    }

}




}



