package umc.assign.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.assign.domain.enums.RestaurantType;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private RestaurantType restaurantType;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public void addRegion(Region region) {
        this.region = region;
    }
}