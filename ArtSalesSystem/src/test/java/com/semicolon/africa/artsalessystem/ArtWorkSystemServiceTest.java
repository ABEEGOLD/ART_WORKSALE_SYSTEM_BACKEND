package com.semicolon.africa.artsalessystem;

import com.semicolon.africa.data.models.*;
import com.semicolon.africa.data.repositories.ArtWorkRepository;
import com.semicolon.africa.data.repositories.ArtistRepository;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.CreateArtWorkRequest;
import com.semicolon.africa.dtos.requests.UpdateArtWorkRequest;
import com.semicolon.africa.dtos.response.CreateArtWorkResponse;
import com.semicolon.africa.dtos.response.GetAllArtWorkResponse;
import com.semicolon.africa.dtos.response.UpdateArtWorkResponse;
import com.semicolon.africa.services.ArtWorkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import static com.semicolon.africa.data.models.Role.ARTIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ArtWorkSystemServiceTest {
    @Autowired
    private ArtWorkService artWorkService;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArtWorkRepository artWorkRepository;

    @Test
    public void testThatArtWorkIsCreated(){
        CreateArtWorkRequest request = getArtWorkCreated();

        CreateArtWorkResponse response = artWorkService.createArtwork(request);

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Artwork has been created successfully");


    }

    @Test
    public void testThatUserCanGetAllArtWork(){

        artWorkRepository.deleteAll();

        ArtWork art1 = new ArtWork();
        art1.setPrice(new BigDecimal("2000"));
        art1.setStatus(StatusArtwork.AVAILABLE);
        art1.setTitle("Furniture1");
        art1.setDescription("The Paint Of a Sky");
        art1.setImageUrl("https://www.furniture.com/images/furniture.jpg");
        art1 = artWorkRepository.save(art1);
//        System.out.println(art1);

        ArtWork art2 = new ArtWork();
        art2.setPrice(new BigDecimal("20000"));
        art2.setStatus(StatusArtwork.AVAILABLE);
        art2.setTitle("Furniture2");
        art2.setDescription("The Beauty World");
        art2.setImageUrl("https://www.cosmetics.com/images/cosmetics.jpg");
        art2 = artWorkRepository.save(art2);
//        System.out.println(art2);

        List<GetAllArtWorkResponse> artworks = artWorkService.getAllArtWork();

        assertThat(artworks).isNotNull();

//        assertThat(artworks).hasSize(2);

        artworks.sort(Comparator.comparing(GetAllArtWorkResponse::getTitle));

        assertThat((CharSequence) artworks.get(0).getTitle()).isEqualTo("Furniture1");
        assertThat((CharSequence) artworks.get(1).getTitle()).isEqualTo("Furniture2");



    }

    @Test
    public void testThatArtWorkCanBeUpdated(){
        CreateArtWorkRequest request = getArtWorkCreated();
        CreateArtWorkResponse response = artWorkService.createArtwork(request);

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Artwork has been created successfully");

        UpdateArtWorkRequest UpdatedRequest = new UpdateArtWorkRequest();
        UpdatedRequest.setId(response.getId());
        UpdatedRequest.setTitle("Cosmetics");
        UpdatedRequest.setImageUrl("https://www.cosmetics.com/images/furniture.jpg");
        UpdatedRequest.setDescription("The Beauty In And Out");
        UpdatedRequest.setPrice(new BigDecimal("3000"));

        UpdateArtWorkResponse responseUpdate = artWorkService.updateArtWork(UpdatedRequest);
        assertThat(responseUpdate).isNotNull();
        assertThat(responseUpdate.getMessage()).isEqualTo("Artwork has been updated successfully");

    }

    @Test
    public void testThatArtWorkIsMarkAsSold(){

    }

    public CreateArtWorkRequest getArtWorkCreated(){

        User user = new User();
        user.setEmail("artist@test.com");
        user.setName("David_Do");
        user.setPassword("password123");
        user.setRole(ARTIST);
        user = userRepository.save(user);

        Artist artist = new Artist();
        artist.setBio("World Best Artist");
        artist.setWebsite("https://www.worldbestartist.com");
        artist.setProfileImageUrl("Upload.xml");
        artist.setUser(user);
        artist = artistRepository.save(artist);

        CreateArtWorkRequest request = new CreateArtWorkRequest();

        request.setDescription("A Beautiful Lady");
        request.setTitle("The Lady");
        request.setPrice(new BigDecimal("20000"));

        request.setArtistId(artist.getId());


        return request;
    }


}
