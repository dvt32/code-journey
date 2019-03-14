package net.dvt32.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.dvt32.models.Rating;
import net.dvt32.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
			new Rating("1234", 4),
			new Rating("5678", 3)
		);
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		
		return userRating;
	}
}
