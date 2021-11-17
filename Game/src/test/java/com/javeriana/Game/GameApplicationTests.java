package com.javeriana.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.javeriana.Game.model.Asset;
import com.javeriana.Game.model.AssetsByTeam;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Price;
import com.javeriana.Game.model.Ship;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.model.StarConected;
import com.javeriana.Game.model.Team;
import com.javeriana.Game.model.User;
import com.javeriana.Game.model.User.UserRoles;
import com.javeriana.Game.repository.AssetRepository;
import com.javeriana.Game.repository.AssetsByTeamRepository;
import com.javeriana.Game.repository.PlanetRepository;
import com.javeriana.Game.repository.PriceRepository;
import com.javeriana.Game.repository.ShipRepository;
import com.javeriana.Game.repository.StarConectedRepository;
import com.javeriana.Game.repository.StarRepository;
import com.javeriana.Game.repository.TeamRepository;
import com.javeriana.Game.repository.UserRepository;
import com.javeriana.Game.service.UserService;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.commons.text.RandomStringGenerator;
import org.hibernate.resource.beans.container.internal.NoSuchBeanException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
class GameApplicationTests {

	Random random = new Random(1234);

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

    @Autowired
    StarConectedRepository starConectedRepository;
	
	
	@Autowired
    TestRestTemplate rest;

	private ChromeDriver browser;
	private WebDriverWait wait;

	String baseUrl;

	@BeforeEach
	void init()
	{

		createShips();
        createTeams();
        int teamId = 1;
        for (int i = 0; i < 10; i++) {
            createUser(teamId);
            teamId++;
        }
        createAsset();
        createAssetByTeam();
        createStar();
        int starId = 1;
        for (int j = 0; j < 400; j++) {
            createPlanet(starId);
            starId++;
        }

        createPrice();

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        // options.addArguments("--headless");
        options.merge(DesiredCapabilities.chrome());

        this.browser = new ChromeDriver(options);
        this.wait = new WebDriverWait(browser, 5);
		this.baseUrl = "http://localhost:4200";
	}

	@AfterEach
    void end() {
        this.browser.quit();
    }
	
	@Test
	void verUsuarios() {
        browser.get(baseUrl + "/crud/usuario");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("liusuario")));
        WebElement liUsuario = browser.findElementById("liCodigo");
           
	}

	

	@Test
	void eliminarUsuarios() {
        browser.get(baseUrl + "/crud/usuario");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("liusuario")));

        // "txtCantidad"
        WebElement txtDatos = browser.findElement(By.id("txtDatos"));
        txtDatos.sendKeys(Keys.BACK_SPACE);
      
        
        WebElement btnEliminar = browser.findElement(By.id("btnEliminar"));
        btnEliminar.click();
        WebElement liusuario = browser.findElementById("liusuario");

	}

	@Test
	void ververTripulacion() {
        browser.get(baseUrl + "/tripulacion");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("litripulacion")));
        WebElement litripulacion = browser.findElementById("liCodigo");
	}

	void jugar()
	{
        browser.get(baseUrl + "/juego");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("liusuario")));
        WebElement litripulacion = browser.findElementById("liCodigo");
	}



	private void createTeams() {
        final int NUM_TEAMS = 10;

        RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .usingRandom(random::nextInt).build();
        int cont = 1;
        for (int k = 0; k < NUM_TEAMS; k++) {

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
            newTeam.setTeamCurrentMoney((long) money);
            newTeam.setTeamTimeGame(0.0);
            newTeam.setTeamPositionX((long) posX);
            newTeam.setTeamPositionY((long) posY);
            newTeam.setTeamPositionZ((long) posZ);

            try {

                Ship s = shipRepository.findById((long) cont).orElseThrow();
                cont++;
                // company.getEmployees().add(p);
                newTeam.setShip(s);
                teamRepository.save(newTeam);

            } catch (NoSuchBeanException e) {
                e.printStackTrace();
            }

        }

    }

    private void createUser(int teamId) {

        RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .usingRandom(random::nextInt).build();

        for (int i = 0; i < 10; i++) {
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
            newUser.setUserAdmin(false);

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

    private void createAsset() {
        final int NUM_ASSET = 500;

        RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .usingRandom(random::nextInt).build();
        for (int j = 0; j < NUM_ASSET; j++) {

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

    private void createShips() {
        final int NUM_SHIPS = 20;

        RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .usingRandom(random::nextInt).build();

        for (int j = 0; j < NUM_SHIPS; j++) {
            String type = randomGen.generate(5, 10);
            int id = random.nextInt(1000000);
            int speed = random.nextInt(1000000);
            int volume = random.nextInt(1000000);

            Ship newShip = new Ship();
            newShip.setShipId((long) id);
            newShip.setShipType(type);
            newShip.setShipSpeed((long) speed);
            newShip.setShipVolume((long) volume);
            shipRepository.save(newShip);

        }

    }

    private void createStar() {
        final int NUM_STAR = 40000;
        final int NUM_STAR_CONECTED = 15;

        RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .usingRandom(random::nextInt).build();
        for (int j = 0; j < NUM_STAR; j++) {
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

        for (int j = 0; j < 700; j++) {

            for (int i = 0; i < NUM_STAR_CONECTED; i++) {
                StarConected sc = new StarConected();
                Star star = starRepository.findById((long) j + 1 ).orElseThrow();
                sc.setStarFrom(star);
                Star s = starRepository.findById((long) random.nextInt(699) + 1 + 1).orElseThrow();
                sc.setStarTo(s);         
                starConectedRepository.save(sc);
                StarConected scB = new StarConected();
                scB.setStarFrom(s);
                scB.setStarTo(star);
                starConectedRepository.save(scB);
            }

        
        }
    }

    private void createPlanet(int starId) {

        RandomStringGenerator randomGen = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .usingRandom(random::nextInt).build();
        int NUM_PLANET = random.nextInt(2) + 1;
        for (int j = 0; j < NUM_PLANET; j++) {
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

    private void createAssetByTeam() {

        final int ASSETS_PER_ABT_PER_TEAM = 4;
        final int ABT_PER_TEAM = 5;
        for (Team team : teamRepository.findAll()) {
            for (int j = 0; j < ASSETS_PER_ABT_PER_TEAM; j++) {
                for (int i = 0; i < ABT_PER_TEAM; i++) {
                    try {
                        int id = random.nextInt(1000000);
                        int amount = random.nextInt(1000000);

                        Asset a = assetRepository.findById((long) random.nextInt(499) + 1).orElseThrow();
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

    private void createPrice() {

        final int PLANET_PER_PRICE_PER_ASSET = 4;
        final int PRICE_PER_PLANET = 5;

        for (Planet planet : planetRepository.findAll()) {
            for (int j = 0; j < PLANET_PER_PRICE_PER_ASSET; j++) {
                for (int i = 0; i < PRICE_PER_PLANET; i++) {
                    try {
                        int id = random.nextInt(1000000);
                        int amount = random.nextInt(1000000);
                        int demandFactor = random.nextInt(1000000);
                        int supplyFactor = random.nextInt(1000000);
                        Asset a = assetRepository.findById((long) random.nextInt(499) + 1).orElseThrow();
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


